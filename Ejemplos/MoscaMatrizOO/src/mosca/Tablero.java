package mosca;

import java.util.Scanner;

public class Tablero {
    private final Mosca MOSCA = new Mosca();
    private int numIntentos = 5;
    private final Mosca[][] casillas;
    private int[] posMosca = {0, 0};
    private boolean estaMuerta = false;

    public Tablero(int numCasillas, int numIntentos) {
        this.numIntentos = numIntentos;
        casillas = new Mosca[numCasillas][numCasillas];
    }

    public void init() {
        iniciarCasillas();
        situarMosca();
        imprimirCasillas();
    }

    public void iniciarCasillas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = null;
            }
        }
    }

    public void situarMosca() {
        int fila = getPosicion(casillas);
        int columna = getPosicion(casillas);
        casillas[fila][columna] = MOSCA;
    }

    private int getPosicion(Mosca[][] casillas) {
        int fila;
        do {
            fila = (int) (Math.random() * casillas.length);
            //System.out.println(s + (fila + 1));
        } while (fila < 0 || fila >= casillas.length);
        return fila;
    }

    public void imprimirCasillas() {
        //System.out.print("{ ");
        for (Mosca[] fila : casillas) {
            System.out.print("{ ");
            for (Mosca columna : fila) {
                if (columna == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println("} ");
        }
        //System.out.println("}");
    }

    public int[] posicionGolpear() {
        Scanner sc = new Scanner(System.in);
        this.posMosca = new int[]{0, 0};

        do {
            System.out.println("Introduce la posición de la Fila a atacar: ");
            posMosca[0] = sc.nextInt() - 1;
            System.out.println("La posición Fila elegida es: " + (posMosca[0] + 1));
        } while (posMosca[0] < 0 || posMosca[0] >= casillas.length);

        do {
            System.out.println("Introduce la posición de la Columna a atacar: ");
            posMosca[1] = sc.nextInt() - 1;
            System.out.println("La posición Columna elegida es: " + (posMosca[1] + 1));
        } while (posMosca[1] < 0 || posMosca[1] >= casillas.length);

        return (posMosca);
    }

    public boolean analizarGolpeo() {
        // Logica del juego
        // Acertamos
        if (casillas[posMosca[0]][posMosca[1]] == MOSCA) {
            estaMuerta = true;

            // Analizamos los limites
        } else {
            // Eje X horizontal
            boolean o = posMosca[0] != 0 && casillas[posMosca[0] - 1][posMosca[1]] == MOSCA;
            boolean e = posMosca[0] != casillas.length - 1 && casillas[posMosca[0] + 1][posMosca[1]] == MOSCA;
            // Eje Y vertical
            boolean n = posMosca[1] != 0 && casillas[posMosca[0]][posMosca[1] - 1] == MOSCA;
            boolean s = posMosca[1] != casillas.length - 1 && casillas[posMosca[0]][posMosca[1] + 1] == MOSCA;

            // Diagonal superior izquierda
            boolean no = posMosca[0] != 0 && posMosca[1] != 0 && casillas[posMosca[0] - 1][posMosca[1] - 1] == MOSCA;
            // Diagonal superior derecha
            boolean ne = posMosca[0] != 0 && posMosca[1] != casillas.length - 1 && casillas[posMosca[0] - 1][posMosca[1] + 1] == MOSCA;
            // Diagnal inferior izquierda
            boolean so = posMosca[0] != casillas.length - 1 && posMosca[1] != 0 && casillas[posMosca[0] + 1][posMosca[1] - 1] == MOSCA;
            // Diagnal inferior derecha
            boolean se = posMosca[0] != casillas.length - 1 && posMosca[1] != casillas.length - 1 && casillas[posMosca[0] + 1][posMosca[1] + 1] == MOSCA;

            if (o || e || n || s || no || ne || so || se) {
                // Revoloteamos
                System.out.println("¡CASI!");
                iniciarCasillas();
                situarMosca();
            }
        }


        if (!estaMuerta) {
            System.out.println("¡Has fallado!");
        }
        imprimirCasillas();
        return estaMuerta;
    }

    public int[] getPosicion() {
        return posMosca;
    }

    public void cazarMosca() {
        do {
            // Pedirle la posición donde vas a dar un tortazo
            posicionGolpear();

            // Anlizamos el Golpeo
            estaMuerta = analizarGolpeo();
            numIntentos--;
            System.out.println("Te quedan " + numIntentos + " intentos");
        } while (!estaMuerta && numIntentos > 0);

        if (estaMuerta)
            System.out.println("¡Has cazado a la maldita mosca!");
        else
            System.out.println("¡Has perdido!");

        System.out.println("Estaba en: {"
                + (getPosicion()[0] + 1) + ", "
                + (getPosicion()[1] + 1) +
                "}");
        imprimirCasillas();
    }
}
