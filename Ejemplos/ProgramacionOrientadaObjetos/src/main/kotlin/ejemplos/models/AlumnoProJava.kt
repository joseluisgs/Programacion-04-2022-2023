package ejemplos.models

import java.util.*
import kotlin.math.pow

class AlumnoProJava {
    // Estado del objeto (si puede ser los atributos privado mejor)
    private val id = UUID.randomUUID() // identificador único universal
    private var nombre = ""
    private var apellido = ""
    private var calificacion = 0.0


    // Pre defecto siempre tenemos el constructor vacío
    // podemos hacer uso de parámetros pro defecto para ahorrarnos definir varios constructores
    constructor(nombre: String, apellido: String, calificacion: Double = 0.0) {
        println("*** Se ha creado un objeto Alumno ***")
        this.nombre = nombre
        this.apellido = apellido
        setCalificacion(calificacion)
    }

    constructor(nombreCompleto: String, calificacion: Double = 0.0) {
        println("*** Se ha creado un objeto Alumno ***")
        setNombreCompleto(nombreCompleto)
        setCalificacion(calificacion)
    }

    constructor(nombre: String, apellido: String, examen: Double, practicas: Double) {
        println("*** Se ha creado un objeto Alumno ***")
        this.nombre = nombre
        this.apellido = apellido
        setCalificacion((examen + practicas) / 2)
    }

    // Nos sirve para crear acciones que queremos que se ejecuten nada mas instanciarse el objeto
    // es decir iniciarse
    init {
        println("*** Se ha iniciado un objeto Alumno ***")
    }

    // Método de presentación
    fun presentar() {
        println("Hola, soy ${getNombreCompleto()} y mi id es $id y mi calificación es ${getCalificacion(2)} y estoy aprobado: ${getAprobado()}")
    }

    fun info() = "$id $nombre $calificacion ${getAprobado()}"

    // Definimos los Getter & Setter
    /**
     * Con los Getter mostramos cómo quremos que se muestre la información
     * Con los Setter filtramos cómo se actualiza el estado
     * Tambien podemos obtener campos calculados
     */

    fun getId() = id.toString()

    // fun getNombre() = nombre

    fun setNombre(nombre: String) {
        this.nombre = nombre.trim()
    }

    // fun getApellido() = apellido

    fun setApellido(apellido: String) {
        this.apellido = apellido.trim()
    }

    fun getNombreCompleto() = "$nombre $apellido"

    private fun setNombreCompleto(nombreCompleto: String) {
        require(nombreCompleto.isNotEmpty()) { "El nombre completo no puede estar vacío" }
        this.nombre = nombreCompleto.split(" ")[0].trim()
        this.apellido = nombreCompleto.split(" ")[1].trim()
    }

    fun getCalificacion(precision: Int): Double {
        return (this.calificacion * 10.0.pow(precision)).toInt() / 10.0.pow(precision)
    }

    fun setCalificacion(calificacion: Double) {
        // require(calificacion in 0.0..10.0) { "La calificación debe estar entre 0 y 10" }
        when {
            calificacion < 0.0 -> this.calificacion = 0.0
            calificacion > 10.0 -> this.calificacion = 10.0
            else -> this.calificacion = calificacion
        }
    }

    fun getAprobado() = calificacion >= 5

    fun calificacionEvaluacion(): Int {
        return if (calificacion < 1) 1
        else {
            calificacion.toInt()
        }
    }

    // Con el método equals podemos comparar objetos indicando cuando son iguales
    override fun equals(other: Any?): Boolean {
        return if (other is AlumnoProJava) {
            this.nombre == other.nombre &&
                    this.apellido == other.apellido &&
                    this.calificacion == other.calificacion
        } else {
            false
        }

    }

    // Definimos el método toString para que nos muestre la información que queremos
    override fun toString() =
        "Alumno: (id=$id, nombre=$nombre, apellido=$apellido, calificación=$calificacion, aprobado=${getAprobado()})"

    // Definimos el método hashCode para que nos devuelva un valor único para cada objeto
    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + apellido.hashCode()
        result = 31 * result + calificacion.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }

}