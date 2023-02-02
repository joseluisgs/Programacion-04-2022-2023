public interface ICirujano {
    void operar();

    void suturar();

    default void desinfectar() {
        System.out.println("Desinfectando");
    }
}
