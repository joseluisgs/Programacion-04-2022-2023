abstract class Medico {
    private String nombre;
    private String numeroColegiado;

    public Medico(String nombre, String numeroColegiado) {
        this.nombre = nombre;
        this.numeroColegiado = numeroColegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public abstract void saludar();  // <-- abstract method;

    public void atender() {
        System.out.println("Atendiendo al paciente");
    }


}
