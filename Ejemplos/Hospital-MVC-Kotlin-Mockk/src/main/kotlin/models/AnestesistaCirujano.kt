package models

import java.util.*

class AnestesistaCirujano(
    id: UUID,
    nombre: String,
    añosExperiencia: Int,
    val quirofano: Int,
) : Anestesista(id, nombre, añosExperiencia), ICirujano {
    override fun operar() {
        println("Soy el anestesista cirujano $nombre y estoy operando")
    }

    override fun calculaBonus(): Double {
        return 75.0
    }

    override fun toString(): String {
        return "AnestesistaCirujano(id=$id, nombre='$nombre', añosExperiencia=$añosExperiencia, quirofano=$quirofano)"
    }
}