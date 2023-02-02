package ejemplos.models;

import java.util.Objects;
import java.util.UUID;

public class AlumnoJava {
    private final UUID id = UUID.randomUUID();
    private Double calificacion = 0.0;
    private String nombre; // ojo que un string puede ser null!!!!
    private String apellido;

    // constructor se debe llamar igual que la clase

    public AlumnoJava(String nombre, String apellido, Double calificacion) {
        System.out.println("*** Se ha creado un objeto Alumno ***");
        this.nombre = nombre;
        this.apellido = apellido;
        setCalificacion(calificacion);
    }

    public AlumnoJava(String nombre, String apellido) {
        System.out.println("*** Se ha creado un objeto Alumno ***");
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public AlumnoJava(String nombreCompleto, Double calificacion) {
        System.out.println("*** Se ha creado un objeto Alumno ***");
        setNombreCompleto(nombreCompleto);
        setCalificacion(calificacion);
    }

    public AlumnoJava(String nombre, String apellido, Double examen, Double practicas) {
        System.out.println("*** Se ha creado un objeto Alumno ***");
        setCalificacion((examen + practicas) / 2);
    }

    public String getId() {
        return id.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        this.apellido = apellido;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    private void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto.isEmpty()) {
            throw new IllegalArgumentException("El nombre completo no puede estar vacío");
        }
        this.nombre = nombreCompleto.split(" ")[0].trim();
        this.apellido = nombreCompleto.split(" ")[1].trim();
    }

    public Double getCalificacion(int precision) {
        return (int) (this.calificacion * Math.pow(10, precision)) / Math.pow(10, precision);
    }

    public void setCalificacion(Double calificacion) {
        // Excepcion si no está entre 0 y 10 --> require en Kotlin
        /*if (calificacion < 0 || calificacion > 10) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 10");
        }*/
        if (calificacion < 0) {
            this.calificacion = 0.0;
        } else if (calificacion > 10) {
            this.calificacion = 10.0;
        } else {
            this.calificacion = calificacion;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // somos el mismo objeto
        if (!(o instanceof AlumnoJava that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(calificacion, that.calificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, calificacion);
    }

    @Override
    public String toString() {
        return "AlumnoJava{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }

}
