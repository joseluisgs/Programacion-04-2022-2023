package mosca;

import java.util.Scanner;

public class JuegoMosca {

    public static void main(String[] args) {
        System.out.println("La Mosca Vector");
        int numIntentos = getNumIntentos();
        // Pedir tamaño de Matriz
        int numCasillas = pedirNumeroCasillas();
        // Crear Matriz
        Tablero tablero = new Tablero(numCasillas, numIntentos);

        tablero.init();
        tablero.cazarMosca();
    }


    private static int getNumIntentos() {
        Scanner sc = new Scanner(System.in);
        int intentos = 0;

        do {
            System.out.println("Introduce el número de intentos máximos, mayor a 1");
            intentos = sc.nextInt();
        } while (intentos < 1);

        return intentos;

    }

    private static int pedirNumeroCasillas() {
        Scanner sc = new Scanner(System.in);
        int numCasillas;
        do {
            System.out.println("Dime el número de casillas, siempre mayor a 5");
            numCasillas = sc.nextInt();
            System.out.println("Tamaño de vector es:" + numCasillas);
        } while (numCasillas < 5);
        return numCasillas;
    }

}
