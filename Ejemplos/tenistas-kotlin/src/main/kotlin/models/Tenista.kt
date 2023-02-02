package models

import java.time.LocalDate


// Clase POJO
data class Tenista(
    val nombre: String,
    val fechaNacimiento: LocalDate,
    val pais: String,
    val tipoReves: TipoReves = TipoReves.DOS_MANOS,
    val raqueta: Raqueta
) {
    val id = nextId()

    // Propiedades
    var puntos: Int = 0
        set(value) = if (value >= 0) field = value else field = 0

    var ranking: Int = 0
        /*set(value) {
            require(value >= 0) { "El ranking no puede ser negativo" }
            field = value
        }*/
        set(value) = if (value >= 0) field =
            value else throw IllegalArgumentException("El ranking no puede ser negativo")

    // Campo calculado
    val coeficiente: Double
        get() = if (puntos > 0 && ranking > 0) puntos.toDouble() / ranking else 0.0

    // Inicializador
    init {
        // Me ejecuto cuando se crea el objeto, es decir, despues del constructor primario
        // y antes del secundario

        // Puedo usarlo para comprobar cosas del constructor primario
        check(nombre.isNotEmpty()) { "El nombre no puede estar vacio" }
        check(fechaNacimiento.isBefore(LocalDate.now())) { "La fecha de nacimiento no puede ser mayor que la fecha actual" }
        check(pais.isNotEmpty()) { "El pais no puede estar vacio" }
        println("Tenista creado")
    }

    // Constructor secundario
    constructor(
        nombre: String,
        fechaNacimiento: LocalDate,
        pais: String,
        tipoReves: TipoReves = TipoReves.DOS_MANOS,
        puntos: Int = 0,
        ranking: Int = 0,
        raqueta: Raqueta
    ) : this(nombre, fechaNacimiento, pais, tipoReves, raqueta) {
        this.puntos = puntos
        this.ranking = ranking
        println("Constructor secundario")
    }

    // Métodos y propiedades de clase
    companion object {
        private var numeroTenistas = 0

        fun nextId(): Int {
            numeroTenistas++
            return numeroTenistas
        }

    }

    // Representación del objeto como String, si no como es data class solo salen los campos
    // que le he metido en el constructor primario
    override fun toString(): String {
        return "Tenista(id=$id, nombre='$nombre', fechaNacimiento='$fechaNacimiento', pais='$pais', tipoReves='$tipoReves', puntos=$puntos, ranking=$ranking, raqueta=$raqueta)"
    }


    fun jugarPartido(contrincante: Tenista) {
        println("${this.nombre} juego contra ${contrincante.nombre}")
    }

    fun entrenar() {
        println("Entrenando")
    }

    fun descansar() {
        println("Descansando")
    }

    private fun comer() {
        println("Comiendo")
    }

    // Clases internas
    enum class TipoReves(val potencia: Double) {
        UNA_MANO(34.5), DOS_MANOS(45.6)
    }
}