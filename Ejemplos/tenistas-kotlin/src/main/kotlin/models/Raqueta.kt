package models

data class Raqueta(
    val marca: String,
    val modelo: String,
    val precio: Double,
) {
    val id: Int = nextId()

    init {
        check(marca.isNotEmpty()) { "La marca no puede estar vacia" }
        check(modelo.isNotEmpty()) { "El modelo no puede estar vacio" }
        check(precio >= 0) { "El precio no puede ser negativo" }
    }

    companion object {
        private var numeroRaquetas = 0

        fun nextId(): Int {
            numeroRaquetas++
            return numeroRaquetas
        }
    }
}
