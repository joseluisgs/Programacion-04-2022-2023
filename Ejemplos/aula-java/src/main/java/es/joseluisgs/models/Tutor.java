package es.joseluisgs.models;

import es.joseluisgs.enums.TipoTutor;

import java.util.Objects;

public class Tutor {
    private final int id = nextId();
    private String nombre;
    private TipoTutor tipo;

    private static int contador = 0;
    private static int nextId() {
        return ++contador;
    }
    private static void resetId() {
        contador = 0;
    }

    // Constructor por defecto
    public Tutor(String nombre, TipoTutor tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Tutor(String nombre) {
        this.nombre = nombre;
        this.tipo = TipoTutor.TEORIA;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoTutor getTipo() {
        return tipo;
    }

    public void setTipo(TipoTutor tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tutor tutor)) return false;
        return id == tutor.id && nombre.equals(tutor.nombre) && tipo == tutor.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipo);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}

