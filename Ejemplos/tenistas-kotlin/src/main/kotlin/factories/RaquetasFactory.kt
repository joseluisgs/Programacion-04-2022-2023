package factories

import models.Raqueta
import java.util.*

// Patrón factory con companion object
// https://refactoring.guru/es/design-patterns/factory-method

class RaquetasFactory private constructor() {
    val nombre = "Factory de Raquetas + ${UUID.randomUUID()}"

    companion object {
        // Patrón Singleton
        // donde almaceno la instancia única
        private var instance: RaquetasFactory? = null
        fun getInstance(): RaquetasFactory {
            if (instance == null) {
                instance = RaquetasFactory()
            }
            return instance!!
        }
    }

    fun createRaquetaRandom(): Raqueta {
        val marcas = arrayOf("Wilson", "Head", "Babolat", "Yonex", "Prince")
        val modelos = arrayOf("Pro Staff", "Pro Tour", "Pro Tour 97", "Pro Tour 100", "Pro Tour 105", "Aero")
        val precios = arrayOf(100.0, 200.0, 300.0, 400.0, 500.0)

        val marca = marcas.random()
        val modelo = modelos.random()
        val precio = precios.random()

        return Raqueta(marca, modelo, precio)
    }

    override fun toString(): String {
        return "TenistasFactory(nombre='$nombre')"
    }
}