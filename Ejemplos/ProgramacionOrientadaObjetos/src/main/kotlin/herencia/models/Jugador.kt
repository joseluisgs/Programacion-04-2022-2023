package herencia.models

open class Jugador(nombre: String, edad: Int, val numero: Int) : Persona(nombre, edad) {

    fun jugar() {
        println("Jugador: Soy $nombre y estoy jugando")
    }

    // Estamos sobreescribiendo el método entrenar de la clase padre
    override fun entrenar() {
        println("Jugador: Soy $nombre y estoy entrenando como jugador")
    }

    override fun hidratarse() {
        println("Jugador: Soy $nombre y estoy hidratándome como jugador")
    }

    open fun datos() {
        println("Jugador: Soy $nombre y tengo $edad años con dorsal $numero")
    }

}
