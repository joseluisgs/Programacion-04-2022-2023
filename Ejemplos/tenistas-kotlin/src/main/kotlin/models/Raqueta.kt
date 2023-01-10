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

        fun random(): Raqueta {
            val marcas = arrayOf("Wilson", "Head", "Babolat", "Yonex", "Prince")
            val modelos = arrayOf("Pro Staff", "Pro Tour", "Pro Tour 97", "Pro Tour 100", "Pro Tour 105", "Aero")
            val precios = arrayOf(100.0, 200.0, 300.0, 400.0, 500.0)

            val marca = marcas.random()
            val modelo = modelos.random()
            val precio = precios.random()

            return Raqueta(marca, modelo, precio)
        }
    }
}
