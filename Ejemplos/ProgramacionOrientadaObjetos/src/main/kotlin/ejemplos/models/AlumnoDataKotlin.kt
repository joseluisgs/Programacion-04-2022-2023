package ejemplos.models

import java.util.*

// Data class nos sirve para definir clases POKO (Pojo), si no no utilizar: tienen el toString, equals, hashCode, copy, component1, component2, etc.
data class AlumnoDataKotlin(
    // constructor ptimario y defino el estado del objeto fundamental!!!
    val id: UUID = UUID.randomUUID(),
    val nombre: String,
    val apellido: String,
    val calificacion: Double
) {
    // Otras variables del estado, pueden ser calculadas
    val califcacionRedondeada get() = (this.calificacion * 100).toInt() / 100.0
    val isAprobado get() = calificacion >= 5

    // constructores secundarios para otro tipo de inicialización
    constructor(nombreCompleto: String, calificacion: Double = 0.0) : this(
        nombre = nombreCompleto.split(" ")[0],
        apellido = nombreCompleto.split(" ")[1],
        calificacion = calificacion
    )

    constructor(nombre: String, apellido: String, examen: Double, practicas: Double) : this(
        nombre = nombre,
        apellido = apellido,
        calificacion = (examen + practicas) / 2
    )

    // Nos sirve para crear acciones que queremos que se ejecuten nada mas instanciarse el objeto
    init {
        println("*** Se ha iniciado un objeto Alumno ***")
        require(calificacion in 0.0..10.0) { "La calificación debe estar entre 0 y 10" }
        require(nombre.isNotEmpty()) { "El nombre no puede estar vacío" }
        require(apellido.isNotEmpty()) { "El apellido no puede estar vacío" }
    }

    // si queremos cambiar algo de toString, equals o hashcode lo sobreescribimos

}