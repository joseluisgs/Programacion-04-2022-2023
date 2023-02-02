package models

import java.util.*

class Cirujano(
    id: UUID,
    nombre: String,
    val habilidad: String,
) : Medico(id = id, nombre = nombre), ICirujano {
    override fun calculaBonus(): Double {
        return 50.0
    }

    override fun operar() {
        println("Soy el cirujano $nombre y estoy operando")
    }

    override fun toString(): String {
        return "Cirujano(id=$id, nombre='$nombre', habilidad='$habilidad')"
    }

}