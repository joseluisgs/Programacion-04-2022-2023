package model;

import java.util.UUID;

public class DroideSW348 extends Droide {
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
}
