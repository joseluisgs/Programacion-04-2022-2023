package ejemplos.models

import java.util.*

class AlumnoProKotlin(
    // constructor ptimario y defino el estado del objeto fundamental!!!
    val id: UUID = UUID.randomUUID(),
    var nombre: String,
    var apellido: String,
    var calificacion: Double
) {
    // Otras variables del estado, pueden ser calculadas
    val califcacionRedondeada get() = (this.calificacion * 100).toInt() / 100.0
    val isAprobado get() = calificacion >= 5

    // O personalizar getter y setter
    var nombreCompleto: String
        get() = "$nombre $apellido"
        set(value) {
            val partes = value.trim().split(" ")
            require(partes.size >= 2) { "El nombre completo debe tener al menos un nombre y un apellido" }
            nombre = partes[0].trim()
            apellido = partes[1].trim()

        }

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AlumnoProKotlin) return false

        if (nombre != other.nombre) return false
        if (apellido != other.apellido) return false
        if (calificacion != other.calificacion) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + apellido.hashCode()
        result = 31 * result + calificacion.hashCode()
        return result
    }

    override fun toString(): String {
        return "AlumnoProKotlin(id=$id, nombreCompleto='$nombreCompleto', califcacionRedondeada=$califcacionRedondeada, isAprobado=$isAprobado)"
    }


}