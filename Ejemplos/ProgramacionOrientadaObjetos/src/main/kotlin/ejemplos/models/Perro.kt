package ejemplos.models

class Perro(val nombre: String, val raza: String) {

    // Definimos todas las propiedades y metodos de clase en el companion object
    companion object {
        var nombre = "Firulais" // cuidado si se llaman igual una propiedad de clase

        // y una propiedad de instancia, se puede confundir
        fun ladrar() {
            println("Guau guau")
        }
    }

    override fun toString(): String {
        return "Perro(nombre='$nombre', raza='$raza')"
    }
}