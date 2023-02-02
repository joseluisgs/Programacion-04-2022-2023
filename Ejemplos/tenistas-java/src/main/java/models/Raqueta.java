package models;

// Para hacer clases POJO (Plain Old Java Object) inmutables
// Podemos usar record de Java 14

import java.util.Objects;

public class Raqueta {
    private static int numeroRaquetas = 0;
    private final int id;
    private final String marca;
    private final String modelo;
    private final double precio;

    public Raqueta(String marca, String modelo, double precio) {
        if (marca == null || marca.isBlank())
            throw new IllegalArgumentException("La marca no puede ser nula o vacía");
        if (modelo == null || modelo.isBlank())
            throw new IllegalArgumentException("El modelo no puede ser nulo o vacío");
        if (precio <= 0)
            throw new IllegalArgumentException("El precio no puede ser negativo o cero");

        this.id = nextId();
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    private static int nextId() {
        return numeroRaquetas++;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Raqueta raqueta)) return false;
        return Double.compare(raqueta.precio, precio) == 0 && marca.equals(raqueta.marca)
                && modelo.equals(raqueta.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, precio);
    }

    @Override
    public String toString() {
        return "Raqueta{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                '}';
    }
}