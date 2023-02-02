package models

import factories.TenistasFactory
import java.time.LocalDate
import java.util.*

data class Torneo(
    val uuid: UUID = UUID.randomUUID(),
    val nombre: String,
    val ciudad: String,
    val fecha: LocalDate = LocalDate.now()
) {
    var numTenistas: Int = 0
        set(value) = if (value >= 0) field = value else field = 0

    var tenistas = Array<Tenista?>(numTenistas) { null }

    fun createRandomTenistas() {
        tenistas = Array<Tenista?>(numTenistas) { TenistasFactory.createTenistaRandom() }
    }

    fun entryList(): String {
        var salida = ""
        for (i in tenistas.indices) {
            salida += "${i + 1}: ${tenistas[i]}\n"
        }
        return salida
    }

    fun sortTenistasByPuntos() {
        // Burbuja por puntos
        for (i in tenistas.indices) {
            for (j in tenistas.indices) {
                if (tenistas[i]?.puntos!! > tenistas[j]?.puntos!!) {
                    val aux = tenistas[i]
                    tenistas[i] = tenistas[j]
                    tenistas[j] = aux
                }
            }
        }
        updateRanking()
    }

    private fun updateRanking() {
        for (i in tenistas.indices) {
            tenistas[i]?.ranking = i + 1
        }
    }

}