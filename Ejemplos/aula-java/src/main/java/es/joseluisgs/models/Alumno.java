package es.joseluisgs.models;

public class Alumno {
    private static int contador = 0;
    private final int id = nextId();
    private String nombre;
    private double nota;

    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    private static int nextId() {
        return ++contador;
    }

    public static void resetId() {
        contador = 0;
    }

    public static Alumno create(String nombre, double nota) {
        return new Alumno(nombre, nota);
    }

    public static void respirar() {
        System.out.println("Respirando");
    }

    public static Alumno random() {
        return new Alumno("Alumno " + nextId(), Math.random() * 10);
    }

    public static int getContador() {
        return contador;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

//    public double getNota() {
//        return nota;
//    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getCalificacion() {
        return (int) (nota * 100) / 100.0;
    }

    public boolean isAprobado() {
        return nota >= 5;
    }

    public String getCalificacionDesc() {
        if (getCalificacion() < 5) {
            return "Suspenso";
        } else if (nota < 7) {
            return "Aprobado";
        } else if (nota < 9) {
            return "Notable";
        } else if (nota <= 10) {
            return "Sobresaliente";
        } else {
            return "Calificación no válida";
        }
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", calificacion=" + getCalificacion() +
                ", isAprobado=" + isAprobado() +
                ", calificacionDesc=" + getCalificacionDesc() +
                '}';
    }
}
