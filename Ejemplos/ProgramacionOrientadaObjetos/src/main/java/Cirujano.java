public class Cirujano extends Medico implements ICirujano {
    private final String especialidad;

    public Cirujano(String nombre, String numeroColegiado, String especialidad) {
        super(nombre, numeroColegiado); // Debe ser la primera línea
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public void operar() {
        System.out.println("Cirujano " + getNombre() + " operando");
    }

    @Override
    public void suturar() {
        System.out.println("Cirujano " + getNombre() + " suturando");
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy el cirujano " + getNombre());
    }
}

