package ejemplos.models;

public class PerroJava {
    // Muy peligrooso es compartido por todos!!!!!!
    public static String nombre = "Firulais";
    // private String nombre;
    private String raza;

    public PerroJava(String nombre, String raza) {
        PerroJava.nombre = nombre;
        this.raza = raza;
    }

    public static void ladrar() {
        System.out.println("Guau!");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        PerroJava.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "PerroJava{" +
                "nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                '}';
    }
}
