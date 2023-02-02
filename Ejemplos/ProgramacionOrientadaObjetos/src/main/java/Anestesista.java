public class Anestesista extends Medico implements IAnestesista {
    private final int añosExperiencia;

    public Anestesista(String nombre, String numeroColegiado, int añosExperiencia) {
        super(nombre, numeroColegiado);
        this.añosExperiencia = añosExperiencia;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public int getDosisAnestesia() {
        return dosisAnestesia;
    }

    @Override
    public void administrarAnestesia() {
        System.out.println("Soy el anestesista " + getNombre() + " administrando anestesia: " + dosisAnestesia + " mg");
    }

    @Override
    public void eliminarAnestesia() {
        System.out.println("Soy el anestesista " + getNombre() + " eliminando anestesia");
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy el anestesista " + getNombre());
    }

    @Override
    public void atender() {
        super.atender();
        System.out.println("Soy el anestesista " + getNombre() + " atendiendo al paciente");
    }
}
