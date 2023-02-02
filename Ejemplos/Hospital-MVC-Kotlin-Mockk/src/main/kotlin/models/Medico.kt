package models

import java.util.*

abstract class Medico(
    val id: UUID = UUID.randomUUID(),
    val nombre: String,
) {
    abstract fun calculaBonus(): Double

    override fun toString(): String {
        return "Medico(id=$id, nombre='$nombre')"
    }
}