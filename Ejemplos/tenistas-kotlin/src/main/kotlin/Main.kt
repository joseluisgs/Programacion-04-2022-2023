import factories.RaquetasFactory
import factories.TenistasFactory
import models.Director
import models.Raqueta
import models.Tenista
import models.Torneo
import modelsA.TipoReves
import java.time.LocalDate
import kotlin.system.exitProcess
// si tenemos dos clases que se llaman igual de distintos paquetes al importarlas podemos
// hacer un alias para que no se confundan
import modelsA.Tenista as TenistaA

fun main(args: Array<String>) {
    println("Hola Tenistas")

    val t1 = Tenista(
        "Rafael Nadal",
        LocalDate.parse("1986-06-03"),
        "España",
        Tenista.TipoReves.DOS_MANOS,
        Raqueta("Babolat", "Pure Aero", 120.0)
    )
    t1.puntos = 1000
    t1.ranking = 1
    println(t1)

    val t2 = Tenista(
        "Roger Federer",
        LocalDate.of(1981, 8, 8),
        "Suiza",
        Tenista.TipoReves.UNA_MANO,
        1000,
        2,
        Raqueta("Wilson", "Pro Staff", 125.0)
    )
    println(t2)

    t1.entrenar()
    t1.jugarPartido(t2)
    t1.descansar()

    val t3 = t1.copy()
    t1.puntos = 1000
    t1.ranking = 1
    println(t3)

    // Igualdad
    println(t1 == t3)
    println(t1.equals(t3))
    println(t1 === t3)
    println(t1 == t2)
    println(t1 === t2)

    val t4 = t1
    println(t1 == t4)
    println(t1 === t4)

    // hashCode
    println(t1.hashCode())
    println(t3.hashCode())
    println("***")
    println(t2.hashCode())
    println(t4.hashCode())
    println(t1.hashCode() == t3.hashCode())

    println(t1.coeficiente)

    val t5 = TenistasFactory.createTenistaRandom()
    println(t5)

    // Copiar
    val t6 = t1.copy()
    println(t6)
    val t7 = t1.copy(
        nombre = "Luis Vives Pelotas",
        pais = "Pepilandia",
        raqueta = RaquetasFactory.getInstance().createRaquetaRandom()
    )
    println(t7)

    // Desestructuracion
    var (nombre, _, pais) = t1
    println(nombre)
    println(pais)
    nombre = "Rafa"
    println(nombre)
    println(t1.nombre)

    val t8 = TenistaA("Rafa Nadal", "1986-06-03", "España", TipoReves.DOS_MANOS)
    println(t8)
    println(Tenista.TipoReves.DOS_MANOS.potencia)

    // Vamos a trabajar con los argumentos
    val tenistas = readArgsTenistas(args)

    println(tenistas)

    val torneo = Torneo(nombre = "Masters 1000 de Madrid", ciudad = "Madrid", fecha = LocalDate.of(2023, 5, 2))
    println(torneo)
    torneo.numTenistas = tenistas
    torneo.createRandomTenistas()
    torneo.sortTenistasByPuntos()
    println(torneo.entryList())

    val f1 = TenistasFactory
    val f2 = TenistasFactory
    println(f1)
    println(f2)

    val d1 = Director.Builder()
        .nombre("Rafa Nadal")
        .fechaNacimiento(LocalDate.of(1986, 6, 3))
        .pais("España")
        .build()

    println(d1)

    val d2 = Director.Builder()
        .fechaNacimiento(LocalDate.of(1981, 8, 8))
        .build()

    println(d2)

    val d3 = Director.Builder()
        .build()

    println(d3)
    
    val d4 = Director.Builder()
        .nombre("Rafa Nadal")
        .build()

}

private fun readArgsTenistas(args: Array<String>): Int {
    if (args.isEmpty()) {
        salida()
    } else {
        if (args[0] != "-tenistas") {
            salida()
        } else {
            val numTenistas = args[1].toIntOrNull()
            if (numTenistas == null) {
                salida()
            } else {
                return numTenistas
            }
        }
    }
    return 0
}

private fun salida() {
    println("Por favor ejecute el programa con el número de tenistas para el torneo")
    println("Ejemplo: java -jar tenistas.jar -tenistas 32")
    exitProcess(1)
}