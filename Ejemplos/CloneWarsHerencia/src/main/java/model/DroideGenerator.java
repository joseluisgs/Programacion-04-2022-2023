package model;

public class DroideGenerator {
    public static Droide getRandomDroide() {
        int random = (int) (Math.random() * 10);
        if (random < 3) {
            return new DroideSW447(TipoDroide.SW447, 50);
        } else if (random < 8) {
            return new DroideSW348(TipoDroide.SW348, 100);
        } else {
            int energia = (int) (Math.random() * (150 - 100)) + 100;
            return new DroideSW4421(TipoDroide.SW4421, energia);
        }
    }
}
