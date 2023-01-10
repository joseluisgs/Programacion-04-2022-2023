package aula.models

data class Alumno(val nombre: String, var nota: Double) {
    val califcacion get() = (this.nota * 100).toInt() / 100.0
    val isAprobado get() = califcacion >= 5
    val calificacionDesc
        get() = when (califcacion) {
            in 0.0..4.99 -> "Suspenso"
            in 5.0..6.99 -> "Aprobado"
            in 7.0..8.99 -> "Notable"
            in 9.0..10.0 -> "Sobresaliente"
            else -> "Calificación no válida"
        }
    val id = nextId()

    companion object {
        private var contador = 0
        private fun nextId() = ++contador
        fun reset() {
            contador = 0
        }

        fun create(nombre: String, nota: Double) = Alumno(nombre, nota)
        fun respirar() = println("Respirando...")

        // Uno de los usos es para crear objetos a partir de datos aleatorios...
        fun random() = Alumno("Alumno $contador", (0..10).random().toDouble())
    }

    override fun toString(): String {
        return "Alumno(id=$id, nombre='$nombre', califcacion=$califcacion, isAprobado=$isAprobado, calificacionDesc='$calificacionDesc')"
    }
}