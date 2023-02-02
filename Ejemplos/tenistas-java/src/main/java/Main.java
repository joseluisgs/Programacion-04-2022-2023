import factories.RaquetasFactory;
import factories.TenistasFactory;
import models.Director;
import models.Raqueta;
import models.Tenista;
import models.Torneo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola tenistas!");

        // Vamos a trabajar con los argumentos
        int tenistas = readArgsTenistas(args);

        System.out.println("Tenistas: " + tenistas);

        Raqueta raqueta = new Raqueta("Wilson", "Pro Staff", 200);
        System.out.println(raqueta);
        Tenista tenista = new Tenista("Rafa Nadal", LocalDate.of(1986, 6, 3), "España", Tenista.TipoReves.DOS_MANOS, raqueta);
        System.out.println(tenista);

        Raqueta raqueta2 = RaquetasFactory.getInstance().createRaquetaRandom();
        System.out.println(raqueta2);

        Tenista tenista2 = TenistasFactory.getInstance().createTenistaRandom();
        System.out.println(tenista2);

        Director d = new Director.Builder()
                .nombre("Pedro")
                .pais("España")
                .fechaNacimiento(LocalDate.of(1986, 6, 3))
                .build();

        Torneo torneo = new Torneo("Masters 1000 de Madrid", "Madrid", LocalDate.of(2023, 5, 2));
        System.out.println(torneo);
        torneo.setNumTenistas(tenistas);
        torneo.createRandomTenistas();
        torneo.sortTenistasByPuntos();
        System.out.println(torneo.entryList());


    }

    private static int readArgsTenistas(String[] args) {
        if (args.length == 0) {
            salida();
        } else {
            if (!args[0].equals("-tenistas")) {
                salida();
            } else {
                try {
                    return Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    salida();
                }
            }
        }
        return 0;
    }

    private static void salida() {
        System.err.println("Por favor ejecute el programa con el número de tenistas para el torneo");
        System.err.println("Ejemplo: java -jar tenistas.jar -tenistas 32");
        System.exit(0);
    }
}

