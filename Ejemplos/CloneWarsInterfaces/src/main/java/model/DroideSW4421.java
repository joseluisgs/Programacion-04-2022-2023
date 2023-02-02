package model;

public class DroideSW4421 extends Droide {
    int velocidad = 100;

    public DroideSW4421(TipoDroide model, int energia) {
        super();
        this.setModel(model);
        this.setEnergia(energia);
    }

    @Override
    public String toString() {
        return "DroideSW4421{" + super.toString() +
                " velocidad=" + velocidad +
                '}';
    }
    
}
