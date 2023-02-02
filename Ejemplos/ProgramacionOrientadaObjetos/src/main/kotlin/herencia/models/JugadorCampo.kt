package herencia.models

class JugadorCampo(nombre: String, edad: Int, numero: Int, val demarcacion: String, val isZurdo: Boolean = false) :
    Jugador(nombre, edad, numero) {

    override fun entrenar() {
        println("Jugador Campo: Soy $nombre y estoy entrenando como jugador de campo")
    }

    override fun datos() {
        println("Jugador Campos: Soy $nombre y tengo $edad años con dorsal $numero y soy $demarcacion")
    }

    fun lanzarFalta() {
        println("Jugador Campo: Soy $nombre y estoy lanzando una falta")
    }

    override fun hidratarse() {
        println("Jugador Campo: Soy $nombre y estoy hidratándome como jugador de campo")
    }


}