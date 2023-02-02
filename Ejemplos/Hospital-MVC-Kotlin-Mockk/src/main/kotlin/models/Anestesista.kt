package models

import java.util.*

open class Anestesista(
    id: UUID,
    nombre: String,
    val añosExperiencia: Int,
) : Medico(id, nombre = nombre), IAnestesista {
    override fun calculaBonus(): Double {
        return 30.0
    }

    override fun anestesiar() {
        println("Soy el anestesista $nombre y estoy anestesiando")
    }

    override fun toString(): String {
        return "Anestesista(id=$id, nombre='$nombre', añosExperiencia=$añosExperiencia)"
    }
}