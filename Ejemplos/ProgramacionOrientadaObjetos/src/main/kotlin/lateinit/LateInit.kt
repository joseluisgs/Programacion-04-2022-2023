package lateinit

class Persona(var edad: Int, nombre2: String) {
    // var nombre: String // No se puede dejar sin inicializar
    lateinit var nombre: String // Se puede dejar sin inicializar

    // Si lo usamos antes de inicializarlo, nos dará una excepción

    fun saludar() {
        println("Hola, me llamo $nombre y tengo $edad años")
    }
}

fun main(args: Array<String>) {
    val p = Persona(20, "Pepe")
    p.nombre = "Juan"
    p.saludar()
}