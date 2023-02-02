package factories

import models.Tenista
import java.time.LocalDate
import java.util.*

// Patrón singleton con Object
// https://refactoring.guru/es/design-patterns/singleton
// https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview

// Patrón factory con companion object
// https://refactoring.guru/es/design-patterns/factory-method
object TenistasFactory {
    val nombre = "Factory de tenistas + ${UUID.randomUUID()}"


    fun createTenistaRandom(): Tenista {
        val arrayNombres = arrayOf(
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
        )
        val arrayPaises = arrayOf(
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
        )
        val arrayFechas = arrayOf(
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
        )
        return Tenista(
            arrayNombres.random(),
            LocalDate.parse(arrayFechas.random()),
            arrayPaises.random(),
            Tenista.TipoReves.values().random(),
            (0..1000).random(),
            (0..1000).random(),
            RaquetasFactory.getInstance().createRaquetaRandom()
        )
    }

    override fun toString(): String {
        return "TenistasFactory(nombre='$nombre')"
    }
}