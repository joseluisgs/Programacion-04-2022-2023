package herencia

import herencia.models.*

fun main() {
    /*
    // Es abstracta y no se puede instanciar
    val p1 = Persona("Juan", 30)
     p1.presentarse()
     p1.entrenar()*/

    println()

    val e1 = Entrenador("Pedro", 40, 10)
    e1.presentarse()
    e1.entrenar()
    e1.entrenarComoPersona()

    println()

    val j1 = Jugador("Carlos", 20, 10)
    j1.presentarse()
    j1.entrenar()
    j1.datos()

    println()

    val j2 = JugadorCampo("Carlos", 20, 10, "Delantero", true)
    j2.presentarse()
    j2.entrenar()
    j2.datos()
    j2.lanzarFalta()

    println()

    val o1 = Portero("Luis", 25, 1, true)
    o1.presentarse()
    o1.entrenar()
    o1.datos()
    o1.pararPenalti()


    println("******")


    val seleccion: Array<Persona> = arrayOf(
        Entrenador("Pedro", 40, 10),
        Jugador("Carlos", 20, 10),
        Jugador("Pepe", 22, 11),
        JugadorCampo("Alvaro", 20, 0, "Delantero", true),
        JugadorCampo("Antonio", 20, 10, "Delantero", false),
        Portero("Luis", 25, 1, true)
    )

    for (persona in seleccion) {
        persona.presentarse()
        persona.entrenar()
        println()
    }

    println("-----")

    // todos pueden parar un penalty?
    for (persona in seleccion) {
        if (persona is Portero) {
            persona.pararPenalti()
        }
    }

    println("------")

    for (persona in seleccion) {
        if (persona is JugadorCampo) {
            persona.lanzarFalta()
        }
    }

    println("------")

    // Como me hidrato?
    for (persona in seleccion) {
        persona.hidratarse()
    }

    // Puedo hidratarme como jugador
    for (persona in seleccion) {
        if (persona is Jugador) {
            persona.hidratarse()
        }
        if (persona is Portero) {
            persona.hidratarse()
        }
        if (persona is JugadorCampo) {
            persona.hidratarse()
        }
    }

    println()

}