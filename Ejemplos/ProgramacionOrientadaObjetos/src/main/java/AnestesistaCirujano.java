public class AnestesistaCirujano extends Medico implements IAnestesista, ICirujano {

    public AnestesistaCirujano(String nombre, String numeroColegiado) {
        super(nombre, numeroColegiado);
    }

    @Override
    public void administrarAnestesia() {
        System.out.println("Soy el anestesista cirujano " + getNombre() + " administrando anestesia");
    }

    @Override
    public void eliminarAnestesia() {
        System.out.println("Soy el anestesista cirujano " + getNombre() + " eliminando anestesia");
    }

    @Override
    public void operar() {
        System.out.println("Soy el anestesista cirujano " + getNombre() + " operando");
    }

    @Override
    public void suturar() {
        System.out.println("Soy el anestesista cirujano " + getNombre() + " suturando");
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy el anestesista cirujano " + getNombre());
    }
}
