package models;

import java.time.LocalDate;
import java.util.Objects;

public class Tenista {
    private static int numeroTenistas = 0;
    private final int id;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final String pais;
    private final TipoReves tipoReves;
    private final Raqueta raqueta;

    private int ranking = 0;
    private int puntos = 0;

    public Tenista(String nombre, LocalDate fechaNacimiento, String pais, TipoReves tipoReves, Raqueta raqueta) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.tipoReves = tipoReves;
        this.raqueta = raqueta;

        init();

        this.id = nextId();
    }

    public Tenista(String nombre, LocalDate fechaNacimiento, String pais, TipoReves tipoReves, Raqueta raqueta, int ranking, int puntos) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.tipoReves = tipoReves;
        this.raqueta = raqueta;
        this.ranking = ranking;
        this.puntos = puntos;

        init();

        this.id = nextId();
    }

    private static int nextId() {
        return numeroTenistas++;
    }

    public double getCoeficiente() {
        if (puntos > 0 && ranking > 0)
            return (double) puntos / ranking;
        else
            return 0.0;
    }

    private void init() {
        if (nombre == null || nombre.isBlank())
            throw new IllegalStateException("El nombre no puede ser nulo o vacío");
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now()))
            throw new IllegalStateException("La fecha de nacimiento no puede ser nula o posterior a la actual");
        if (pais == null || pais.isBlank())
            throw new IllegalStateException("El país no puede ser nulo o vacío");
        if (tipoReves == null)
            throw new IllegalStateException("El tipo de revés no puede ser nulo");
        if (raqueta == null)
            throw new IllegalStateException("La raqueta no puede ser nula");
        if (ranking < 0)
            throw new IllegalStateException("El ranking no puede ser negativo");
        if (puntos < 0)
            throw new IllegalStateException("Los puntos no pueden ser negativos");
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public TipoReves getTipoReves() {
        return tipoReves;
    }

    public Raqueta getRaqueta() {
        return raqueta;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tenista tenista)) return false;
        return nombre.equals(tenista.nombre) && fechaNacimiento.equals(tenista.fechaNacimiento) && pais.equals(tenista.pais) && tipoReves == tenista.tipoReves && raqueta.equals(tenista.raqueta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento, pais, tipoReves, raqueta);
    }

    @Override
    public String toString() {
        return "Tenista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", pais='" + pais + '\'' +
                ", tipoReves=" + tipoReves +
                ", raqueta=" + raqueta +
                ", ranking=" + ranking +
                ", puntos=" + puntos +
                '}';
    }

    public enum TipoReves {
        UNA_MANO, DOS_MANOS
    }
}
