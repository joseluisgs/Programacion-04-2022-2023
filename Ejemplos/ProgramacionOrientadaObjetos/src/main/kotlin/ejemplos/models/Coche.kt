package ejemplos.models

class Coche {
    var matricula = "1234AAA"
    var marca = "Seat"
    var modelo = "Ibiza"
    val añoFabricacion = 2018

    private var velocidad = 200
    private var rotura = false

    fun info() {
        println("Matrícula: $matricula, Marca: $marca, Modelo: $modelo, Año de fabricación: $añoFabricacion, Velocidad: $velocidad y Rotura: $rotura")
    }

    fun acelerar() {
        println("Acelerando...")
        velocidad++
        romper()
    }

    fun frenar() {
        println("Frenando...")
        velocidad--
        romper()
    }

    private fun romper() {
        if ((1..10).random() <= 4) rotura = true
    }
}