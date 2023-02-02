package models;

import java.time.LocalDate;

public class Director {
    private String nombre;
    private String pais;
    private LocalDate fechaNacimiento;

    private Director() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Director{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    // Builder
    public static class Builder {
        private final Director director;

        public Builder() {
            director = new Director();
        }

        // Aplicamos interfaz fluoda devolviendo el this (es decir el objeto)
        public Builder nombre(String nombre) {
            director.nombre = nombre;
            return this;
        }

        public Builder pais(String pais) {
            director.pais = pais;
            return this;
        }

        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            director.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Director build() {
            return director;
        }
    }
}
