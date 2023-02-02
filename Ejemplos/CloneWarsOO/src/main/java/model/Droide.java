package model;

public class Droide {
    private int energia;
    private TipoDroide model;

    public Droide() {
        randomDroide();
    }

    private void randomDroide() {
        int random = (int) (Math.random() * 10);
        if (random < 3) {
            this.model = TipoDroide.SW447;
            this.energia = 50;
        } else if (random < 8) {
            this.model = TipoDroide.SW348;
            this.energia = 100;
        } else {
            this.model = TipoDroide.SW4421;
            this.energia = (int) (Math.random() * (150 - 100)) + 100;
        }
    }

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
