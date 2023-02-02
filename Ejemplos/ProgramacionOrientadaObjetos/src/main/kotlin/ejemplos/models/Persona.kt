package ejemplos.models

/**
 * Con las clases definimos los objetos
 * Tienen un estado con antributos, definido por las propiedades
 * Y un comportamiento con acciones, definido por los métodos
 */
class Persona {
    // Estado (atributos) mediante propiedades
    var nombre: String = "Pepe"
    var edad: Int = 22
    private val created = System.currentTimeMillis() // Solo de lectura y privada

    // EEsta propiedad es privada no se puede acceder desde fuera
    private var isPrivado = true

    // Comportamiento mediante métodos
    fun hablar() {
        println("Hola, soy $nombre y tengo $edad años")
    }

    fun esMayorDeEdad(): Boolean {
        return edad >= 18
    }

    // Este método es privado no se puede acceder desde fuera
    private fun hacerPrivado() {
        isPrivado = !esMayorDeEdad()
    }
}