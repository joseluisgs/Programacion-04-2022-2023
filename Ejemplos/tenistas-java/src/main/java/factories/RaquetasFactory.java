package factories;

import models.Raqueta;

import java.util.UUID;

public class RaquetasFactory {
    private static RaquetasFactory instance = null;
    private final String nombre = "Factory de Raquetas " + UUID.randomUUID();

    private RaquetasFactory() {
    }

    // Singleton pattern
    public static RaquetasFactory getInstance() {
        if (instance == null) {
            instance = new RaquetasFactory();
        }
        return instance;
    }

    public Raqueta createRaquetaRandom() {
        String[] marcas = {"Wilson", "Head", "Babolat", "Yonex", "Prince"};
        String[] modelos = {"Pro Staff", "Pro Tour", "Pro Tour 97", "Pro Tour 100", "Pro Tour 105", "Aero"};
        double[] precios = {100.0, 200.0, 300.0, 400.0, 500.0};

        String marca = marcas[(int) (Math.random() * marcas.length)];
        String modelo = modelos[(int) (Math.random() * modelos.length)];
        double precio = precios[(int) (Math.random() * precios.length)];

        return new Raqueta(marca, modelo, precio);
    }

    @Override
    public String toString() {
        return "RaquetasFactory{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
