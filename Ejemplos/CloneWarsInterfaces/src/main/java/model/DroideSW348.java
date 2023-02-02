package model;

import java.util.UUID;

public class DroideSW348 extends Droide implements IDefensa {
    String numSerie = UUID.randomUUID().toString();

    public DroideSW348(TipoDroide model, int energia) {
        super();
        this.setModel(model);
        this.setEnergia(energia);
    }

    @Override
    public String toString() {
        return "DroideSW348{" + super.toString() +
                " numSerie='" + numSerie + '\'' +
                '}';
    }

    @Override
    public int defender(int ataque) {
        int defensa = (int) Math.round(Math.random() * (12 - 3) + 3);
        return Math.max(0, ataque - defensa);
    }
}
