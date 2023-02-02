package model;

public class Cuadricula {
    private static Cuadricula instance;
    private final Droide[][] espacio;
    private final int dimension;
    private final int numDroides;
    private final int tiempoMax;
    private final int efectoDisparoNormal = 25;
    private final int efectoDisparoCritical = 50;
    private Droide[] droidesEnemigos;
    private int disparos;
    private int aciertos;


    private Cuadricula(int dimension, int numDroides, int tiempoMax) {
        this.dimension = dimension;
        this.numDroides = numDroides;
        this.tiempoMax = tiempoMax * 60 * 1000; // tiempo en milisegundos porque me lo dan en minutos
        espacio = new Droide[dimension][dimension];
    }

    public static Cuadricula getInstance(int dimension, int numDroides, int tiempoMax) {
        if (instance == null) {
            instance = new Cuadricula(dimension, numDroides, tiempoMax);
        }
        return instance;
    }


    public void init() {
        System.out.println("Iniciando cuadricula...");
        initDroidesEnemigos();
        colocarDroidesEnemigos();
        printEspacio();
    }

    private void printEspacio() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (espacio[i][j] != null) {
                    System.out.print("[" + espacio[i][j].getModel() + "-" + espacio[i][j].getEnergia() + "]");
                } else {
                    System.out.print("[          ]");
                }
            }
            System.out.println();
        }
    }

    private void colocarDroidesEnemigos() {
        System.out.println("Colocando droides enemigos...");
        limpiarEspacio();
        for (int i = 0; i < droidesEnemigos.length; i++) {
            int fil;
            int col;
            // si esta vivo
            if (droidesEnemigos[i].isAlive()) {
                do {
                    fil = (int) (Math.random() * dimension);
                    col = (int) (Math.random() * dimension);
                } while (espacio[fil][col] != null);
                espacio[fil][col] = droidesEnemigos[i];
            }
        }
    }

    private void limpiarEspacio() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                espacio[i][j] = null;
            }
        }
    }

    private void initDroidesEnemigos() {
        droidesEnemigos = new Droide[numDroides];
        for (int i = 0; i < numDroides; i++) {
            droidesEnemigos[i] = Droide.getRandomDroide();
        }
    }

    public void run() {
        System.out.println("Ejecutando cuadricula...");
        int tiempo = 0;
        boolean salida = false;
        do {
            System.out.println("Tiempo: " + tiempo);
            System.out.println("escaneando y apuntando...");
            // Obtengo la posicion a disparar
            int fil = (int) (Math.random() * dimension);
            int col = (int) (Math.random() * dimension);
            System.out.println("Disparando en: [" + fil + "][" + col + "]");
            // Disparo
            disparos++;
            // Acierto si es != null
            if (espacio[fil][col] != null) {
                aciertos++;
                int efecto = getEfecto();
                Droide d = espacio[fil][col];

                // Si el androide es del tipo SW447, tiene una defensa que lo delimita de los disparos
                if (d instanceof DroideSW447) {
                    System.out.println("El droide SW447 tiene una defensa que lo delimita de los disparos");
                    efecto = efecto - ((DroideSW447) d).getDefensa();
                    efecto = Math.max(efecto, 0);

                    // Si implementa una interfaz de defensa
                } else if (d instanceof IDefensa) {
                    System.out.println("El droide implementa una interfaz de Escudo de Defensa");
                    efecto = ((IDefensa) d).defender(efecto);
                }

                d.setEnergia(d.getEnergia() - efecto);
                System.out.println("Has acertado con un daño de: " + efecto + " a: " + d);

            } else {
                System.out.println("Fallo");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tiempo += 1000;
            // Cambian de posicion los droides
            if (tiempo % 3000 == 0) {
                colocarDroidesEnemigos();
            }
            // Imprimo el espacio
            printEspacio();
            boolean finTiempo = tiempo >= tiempoMax;
            boolean todosMuertos = numDroides == droidesEnemigosMuertos();
            salida = finTiempo || todosMuertos;
        } while (!salida);
    }

    private int getEfecto() {
        int efecto = (int) (Math.random() * 100);
        if (efecto <= 15) {
            return efectoDisparoCritical;
        } else {
            return efectoDisparoNormal;
        }
    }

    public void report() {
        System.out.println("Reporte de cuadricula...");
        System.out.println("Droides enemigos: " + numDroides);
        System.out.println("Droides enemigos muertos: " + droidesEnemigosMuertos());
        System.out.println("Droides enemigos vivos: " + (numDroides - droidesEnemigosMuertos()));
        System.out.println("Disparos realizados: " + disparos);
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Procentaje de aciertos: " + procentajeAciertos() + "%");
        System.out.println("Enemigos ordenados por energia: ");
        ordenarEnemigosPorEnergia();
        imprimirEnemigos();
    }

    private float procentajeAciertos() {
        float res = 0;
        if (disparos != 0) {
            res = (((float) aciertos) / disparos) * 100;
            return (float) Math.round(res * 100) / 100;
        } else {
            return 0;
        }
    }

    private void ordenarEnemigosPorEnergia() {
        for (int i = 0; i < droidesEnemigos.length; i++) {
            for (int j = i + 1; j < droidesEnemigos.length; j++) {
                if (droidesEnemigos[i].getEnergia() < droidesEnemigos[j].getEnergia()) {
                    Droide aux = droidesEnemigos[i];
                    droidesEnemigos[i] = droidesEnemigos[j];
                    droidesEnemigos[j] = aux;
                }
            }
        }
    }

    private void imprimirEnemigos() {
        for (int i = 0; i < droidesEnemigos.length; i++) {
            System.out.println("[" + i + "] " + droidesEnemigos[i]);
        }
    }

    private int droidesEnemigosMuertos() {
        int muertos = 0;
        for (int i = 0; i < droidesEnemigos.length; i++) {
            if (!droidesEnemigos[i].isAlive()) {
                muertos++;
            }
        }
        return muertos;
    }
}
