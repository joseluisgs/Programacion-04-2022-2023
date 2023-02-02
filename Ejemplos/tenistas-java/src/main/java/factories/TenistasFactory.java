package factories;

import models.Raqueta;
import models.Tenista;

import java.time.LocalDate;
import java.util.UUID;

public class TenistasFactory {
    private static TenistasFactory instance = null;
    private final String nombre = "Factory de Raquetas " + UUID.randomUUID();

    private TenistasFactory() {
    }

    // Singleton pattern
    public static TenistasFactory getInstance() {
        if (instance == null) {
            instance = new TenistasFactory();
        }
        return instance;
    }

    public Tenista createTenistaRandom() {
        String[] arrayNombres = {
                "Rafael Nadal",
                "Roger Federer",
                "Novak Djokovic",
                "Pepe Perez",
                "Sergio Dudita",
                "Juanito Alimaña",
                "Eustaquia Habichuela",
                "Pepa Pig",
                "Pepito Grillo",
                "Pikachu",
                "Charmander",
                "Squirtle",
                "Bulbasaur",
                "Ash Ketchum",
                "Misty",
                "Brock",
                "Gary Oak",
        };
        String[] arrayPaises = {
                "España",
                "Suiza",
                "Serbia",
                "Francia",
                "Alemania",
                "Italia",
                "Portugal",
                "Rusia",
                "China",
                "Japón",
                "Estados Unidos",
                "Canadá",
                "Australia",
                "Nueva Zelanda",
                "Argentina",
                "Brasil",
        };
        String[] arrayFechas = {
                "1986-06-03",
                "1981-08-08",
                "1987-05-22",
                "1990-01-01",
                "1992-02-02",
                "1993-03-03",
                "1994-04-04",
                "1995-05-05",
                "1996-06-06",
                "1997-07-07",
                "1998-08-08",
                "1999-09-09",
                "2000-10-10",
                "2001-11-11",
                "2002-12-12",
        };

        String nombre = arrayNombres[(int) (Math.random() * arrayNombres.length)];
        LocalDate fechaNacimiento = LocalDate.parse(arrayFechas[(int) (Math.random() * arrayFechas.length)]);
        String pais = arrayPaises[(int) (Math.random() * arrayPaises.length)];
        Tenista.TipoReves reves = Tenista.TipoReves.values()[(int) (Math.random() * Tenista.TipoReves.values().length)];
        Raqueta raqueta = RaquetasFactory.getInstance().createRaquetaRandom();
        int ranking = (int) (Math.random() * 1000);
        int puntos = (int) (Math.random() * 1000);

        return new Tenista(nombre, fechaNacimiento, pais, reves, raqueta, ranking, puntos);
    }

    @Override
    public String toString() {
        return "TenistasFactory{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
