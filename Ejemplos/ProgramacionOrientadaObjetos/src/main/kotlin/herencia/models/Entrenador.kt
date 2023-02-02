package herencia.models

class Entrenador(nombre: String, edad: Int, val añosExperiencia: Int) : Persona(nombre, edad) {

    fun alinear() {
        println("Entrenador: Soy $nombre y estoy alineando")
    }

    // Estamos sobreescribiendo el método entrenar de la clase padre
    override fun entrenar() {
        println("Entrenador: Soy $nombre y estoy entrenando a mis jugadores como entrenador")
    }

    override fun hidratarse() {
        println("Entrenador: Soy $nombre y estoy hidratándome como entrenador")
    }

    fun entrenarComoPersona() {
        super.entrenar()
        super.fechaNacimiento
    }
}