package models;

import factories.TenistasFactory;

import java.time.LocalDate;
import java.util.UUID;

public class Torneo {
    private final UUID uuid = UUID.randomUUID();
    private final String nombre;
    private final String ciudad;
    private final LocalDate fecha;
    Tenista[] tenistas = null;
    private int numTenistas = 0;


    public Torneo(String nombre, String ciudad, LocalDate fecha) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    public int getNumTenistas() {
        return numTenistas;
    }

    // Para variar voy a usar la interfaz fluida
   /* public void setNumTenistas(int numTenistas) {
        this.numTenistas = numTenistas;
    }*/
    public Torneo setNumTenistas(int numTenistas) {
        if (numTenistas < 0)
            throw new IllegalArgumentException("El número de tenistas no puede ser negativo");
        this.numTenistas = numTenistas;
        return this;
    }

    public void createRandomTenistas() {
        tenistas = new Tenista[numTenistas];
        for (int i = 0; i < numTenistas; i++) {
            tenistas[i] = TenistasFactory.getInstance().createTenistaRandom();
        }
    }

    public String entryList() {
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < numTenistas; i++) {
            salida.append(i + 1).append(": ").append(tenistas[i]).append("\n");
        }
        return salida.toString();
    }

    public void sortTenistasByPuntos() {
        for (int i = 0; i < numTenistas; i++) {
            for (int j = i + 1; j < numTenistas; j++) {
                if (tenistas[i].getPuntos() < tenistas[j].getPuntos()) {
                    Tenista aux = tenistas[i];
                    tenistas[i] = tenistas[j];
                    tenistas[j] = aux;
                }
            }
        }
        updateRanking();
    }

    private void updateRanking() {
        for (int i = 0; i < numTenistas; i++) {
            tenistas[i].setRanking(i + 1);
        }
    }


    @Override
    public String toString() {
        return "Torneo{" +
                "uuid=" + uuid +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fecha=" + fecha +
                ", numTenistas=" + numTenistas +
                '}';
    }
}
