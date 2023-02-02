package model;

public abstract class Droide {
    private int energia;
    private TipoDroide model;

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
        if (this.energia < 0) {
            this.energia = 0;
        }
    }

    public boolean isAlive() {
        return this.energia != 0;
    }

    public TipoDroide getModel() {
        return model;
    }

    public void setModel(TipoDroide model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Droide{" +
                "model=" + model +
                ", energia=" + energia +
                '}';
    }
}
