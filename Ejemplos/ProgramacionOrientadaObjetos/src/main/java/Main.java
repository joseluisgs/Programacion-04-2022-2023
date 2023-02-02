public class Main {
    public static void main(String[] args) {
        System.out.println("Hola Medicos!");

        Cirujano[] cirujanos = new Cirujano[3];
        cirujanos[0] = new Cirujano("Juan", "1234", "Traumatología");
        cirujanos[1] = new Cirujano("Pedro", "5678", "Cardiología");
        cirujanos[2] = new Cirujano("Maria", "9", "Oftalmología");

        for (Cirujano cirujano : cirujanos) {
            cirujano.saludar();
            cirujano.atender();
            cirujano.operar();
            cirujano.suturar();
            cirujano.desinfectar();
        }

        ICirujano[] iCirujanos = {
                new Cirujano("Juan", "1234", "Traumatología"),
                new Cirujano("Pedro", "5678", "Cardiología"),
                new AnestesistaCirujano("Maria", "9"),
                new CirujanoAnestesista("Maria", "9", "Oftalmología", 10, 4)
        };

        for (ICirujano cirujano : iCirujanos) {
            cirujano.operar();
            cirujano.suturar();
        }

        IAnestesista[] iAnestesistas = {
                new Anestesista("Juan", "1234", 10),
                new Anestesista("Pedro", "5678", 4),
                new AnestesistaCirujano("Maria", "9"),
                new CirujanoAnestesista("Maria", "9", "Oftalmología", 10, 4)
        };

        for (IAnestesista anestesista : iAnestesistas) {
            anestesista.administrarAnestesia();
            anestesista.eliminarAnestesia();
        }

        Medico[] medicos = {
                // new Medico("Juan", "1234"), --> es abstracta
                new Anestesista("Pedro", "5678", 4),
                new Cirujano("Maria", "9", "Oftalmología"),
                new AnestesistaCirujano("Maria", "9"),
                new CirujanoAnestesista("Maria", "9", "Oftalmología", 10, 4)
        };

        for (Medico medico : medicos) {
            medico.saludar();
            medico.atender();

            if (medico instanceof ICirujano cirujano) {
                cirujano.operar();
                cirujano.suturar();
            }

            if (medico instanceof IAnestesista anestesista) {
                anestesista.administrarAnestesia();
                anestesista.eliminarAnestesia();
            }

            if (medico instanceof Cirujano cirujano) {
                cirujano.desinfectar();
                cirujano.operar();
                cirujano.suturar();
            }

            if (medico instanceof Anestesista anestesista) {
                anestesista.administrarAnestesia();
                anestesista.eliminarAnestesia();

            }

            if (medico instanceof CirujanoAnestesista cirujanoAnestesista) {
                cirujanoAnestesista.desinfectar();
                cirujanoAnestesista.administrarAnestesia();
                cirujanoAnestesista.operar();
                cirujanoAnestesista.suturar();
                cirujanoAnestesista.eliminarAnestesia();
            }

            if (medico instanceof AnestesistaCirujano anestesistaCirujano) {
                anestesistaCirujano.desinfectar();
                anestesistaCirujano.administrarAnestesia();
                anestesistaCirujano.operar();
                anestesistaCirujano.suturar();
            }

        }
    }
}
