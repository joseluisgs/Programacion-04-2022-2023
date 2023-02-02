package `object`

import java.util.*

// https://refactoring.guru/es/design-patterns/singleton

// Con object crearmos el patron Singleto de manera segura (Thread Safe)

// Patron Singleton de Fabrica
class FabricaSingleton {
    val id = UUID.randomUUID().toString()
    val nombre = "Fabrica de Singleton"

    override fun toString(): String {
        return "FabricaSingleton(id='$id', nombre='$nombre')"
    }

    companion object {
        private val instance = FabricaSingleton()

        fun getInstance(): FabricaSingleton {
            return instance
        }
    }
}

object FabricaSingleton2 {
    val id = UUID.randomUUID().toString()
    val nombre = "Fabrica de Singleton"

    override fun toString(): String {
        return "FabricaSingleton(id='$id', nombre='$nombre')"
    }
}

fun main(args: Array<String>) {
    val f1 = FabricaSingleton.getInstance()
    val f2 = FabricaSingleton.getInstance()

    println(f1)
    println(f2)

    val f3 = FabricaSingleton2
    val f4 = FabricaSingleton2

    println(f3)
    println(f4)
}