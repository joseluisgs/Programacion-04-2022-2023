package modelsA

// Clase POJO
// Constructor primario con el estado ya definido
class Tenista constructor(
    val nombre: String,
    val fechaNacimiento: String,
    val pais: String,
    val tipoReves: TipoReves = TipoReves.DOS_MANOS,
) {
    var id = nextId()

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
        check(fechaNacimiento.isNotEmpty()) { "La fecha de nacimiento no puede estar vacia" }
        check(pais.isNotEmpty()) { "El pais no puede estar vacio" }
        println("Tenista creado")
    }

    // Constructor secundario
    constructor(
        nombre: String,
        fechaNacimiento: String,
        pais: String,
        tipoReves: TipoReves = TipoReves.DOS_MANOS,
        puntos: Int = 0,
        ranking: Int = 1
    ) : this(nombre, fechaNacimiento, pais, tipoReves) {
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

    // Representación del objeto como String
    override fun toString(): String {
        return "Tenista(id=$id, nombre='$nombre', fechaNacimiento='$fechaNacimiento', pais='$pais', tipoReves='$tipoReves', puntos=$puntos, ranking=$ranking)"
    }

    // Igualdad
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Tenista) return false
        return this.id == other.id && this.nombre == other.nombre
                && this.fechaNacimiento == other.fechaNacimiento && this.pais == other.pais
    }

    // hashCode
    override fun hashCode(): Int {
        var result = id
        result = 31 * result + nombre.hashCode()
        result = 31 * result + fechaNacimiento.hashCode()
        result = 31 * result + pais.hashCode()
        return result
    }

    // Clone
    fun copy(): Tenista {
        val t = Tenista(this.nombre, this.fechaNacimiento, this.pais, this.tipoReves, this.puntos, this.ranking)
        t.id = this.id
        return t
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
}