package herencia.models

open class Portero(nombre: String, edad: Int, numero: Int, val isZurdo: Boolean = false) :
    Jugador(nombre, edad, numero) {

    override fun entrenar() {
        println("Portero: Soy $nombre y estoy entrenando como portero")
    }

    fun pararPenalti() {
        println("Portero: Soy $nombre y estoy parando un penalti")
    }
}