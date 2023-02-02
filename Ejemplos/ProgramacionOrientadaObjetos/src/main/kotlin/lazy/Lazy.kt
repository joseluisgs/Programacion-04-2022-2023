package lazy

class Persona(var edad: Int, nombre2: String) {
    // var nombre: String // No se puede dejar sin inicializar
    // val nombre: String = "Pepe" // Se puede dejar sin inicializar
    // val nombre = giveName()

    // Estamos creando una inicialización perezosa
    // delegando la inicialización a una función

    //val nombre: String by lazy { "Pepe" }
    val nombre: String by lazy { giveName() } // Se puede dejar sin inicializar

    // Si lo usamos antes de inicializarlo, nos dará una excepción

    fun saludar() {
        println("Hola, me llamo $nombre y tengo $edad años")
    }
}

fun main(args: Array<String>) {
    val p = Persona(20, "Pepe")
    p.saludar()
}

fun giveName(): String {
    println("Dame un nombre")
    return "Pepe"
}