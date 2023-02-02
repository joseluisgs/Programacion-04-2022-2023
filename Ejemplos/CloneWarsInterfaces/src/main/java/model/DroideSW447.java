package model;

public class DroideSW447 extends Droide {
    int defensa = (int) Math.round(Math.random() * (10 - 5) + 5);

    public DroideSW447(TipoDroide model, int energia) {
        super();
        this.setModel(model);
        this.setEnergia(energia);
    }

    @Override
    public String toString() {
        return "DroideSW447{" + super.toString() +
                " defensa=" + defensa +
                '}';
    }

    public int getDefensa() {
        return defensa;
    }
}
