// Al extender de la clase Cirujano, la clase CirujanoAnestesista hereda
// todos los métodos y atributos de la clase Cirujano, y sus interfaces!!!, y además puede
// implementar la interfaz IAnestesista

public class CirujanoAnestesista extends Cirujano implements IAnestesista {
    private final int experienciaAnestesia;
    private final int experienciaCirugia;

    public CirujanoAnestesista(String nombre, String numeroColegiado, String especialidad, int experienciaAnestesia, int experienciaCirugia) {
        super(nombre, numeroColegiado, especialidad);
        this.experienciaAnestesia = experienciaAnestesia;
        this.experienciaCirugia = experienciaCirugia;
    }

    public int getExperienciaAnestesia() {
        return experienciaAnestesia;
    }

    public int getExperienciaCirugia() {
        return experienciaCirugia;
    }

    @Override
    public void administrarAnestesia() {
        System.out.println("Soy el cirujano anestesista " + getNombre() + " administrando anestesia: " + dosisAnestesia + " mg");
    }

    @Override
    public void eliminarAnestesia() {
        System.out.println("Soy el cirujano anestesista " + getNombre() + " eliminando anestesia");
    }

    @Override
    public void desinfectar() {
        super.desinfectar();
    }

    @Override
    public void suturar() {
        System.out.println("Cirujano Anestesista " + getNombre() + " suturando");
    }
}
