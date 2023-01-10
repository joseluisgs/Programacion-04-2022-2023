package models

import java.time.LocalDate
import java.util.*

data class Torneo(
    val uuid: UUID = UUID.randomUUID(),
    val nombre: String,
    val ciudad: String,
    val fecha: LocalDate = LocalDate.now(),
)