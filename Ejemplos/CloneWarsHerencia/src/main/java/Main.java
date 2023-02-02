import model.Cuadricula;

public class Main {
    public static void main(String[] args) {
        // Compruebo numero de parámetros
        if (args.length != 6) {
            System.out.println("Usage: java -jar Programa -c <dimension cuadricula> -d <numero droides> -t<tiempo de ejecución>");
        } else
            try {
                int dimension = Integer.parseInt(args[1]);
                int droides = Integer.parseInt(args[3]);
                int tiempo = Integer.parseInt(args[5]);
                // Compruebo que los parámetros sean correctos
                if (checkParameters(dimension, droides, tiempo)) {
                    // Creo Cuadricula
                    Cuadricula cuadricula = new Cuadricula(dimension, droides, tiempo);
                    cuadricula.init();
                    cuadricula.run();
                    cuadricula.report();

                } else {
                    System.out.println("Usage: java -jar Programa -c <dimension cuadricula> -d <numero droides> -t<tiempo de ejecución>");
                }

            } catch (NumberFormatException e) {
                System.out.println("Los parámetros deben ser enteros positivos");
                System.out.println("Usage: java -jar Programa -c <dimension cuadricula> -d <numero droides> -t<tiempo de ejecución>");
            }
    }

    private static boolean checkParameters(int dimension, int droides, int tiempo) {
        boolean result = true;
        if (dimension < 5 || dimension > 9) {
            System.out.println("La dimension debe estar entre 5 y 9");
            result = false;
        }
        if (droides < 5 || droides > 30) {
            System.out.println("El numero de droides debe estar entre 5 y 30");
            result = false;
        }
        if (tiempo < 1 || tiempo > 3) {
            System.out.println("El tiempo de ejecución debe estar entre 1 y 3 minutos");
            result = false;
        }
        return result;
    }
}
