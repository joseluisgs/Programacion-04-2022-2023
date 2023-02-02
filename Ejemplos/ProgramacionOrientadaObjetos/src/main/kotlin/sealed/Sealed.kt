package sealed

sealed interface Tocar {
    fun tocar() {
        println("tocando")
    }
}

interface IGuitarra : Tocar {
    fun rasgar() {
        println("rasgando")
    }
}

interface IBateria : Tocar {
    fun golpear() {
        println("golpeando")
    }
}

interface IBajista : Tocar {
    fun slapping() {
        println("tocando bajo")
    }
}

sealed class Musico(val nome: String) : Tocar
class Baterista(nome: String, val experiencia: Int) : Musico(nome), IBateria
class Guitarrista(nome: String, val nivel: Int) : Musico(nome), IGuitarra
class Bajista(nome: String, val bajo: String) : Musico(nome), IBajista

fun main() {
    val array: Array<Musico> = arrayOf(
        Baterista("Ringo", 10),
        Guitarrista("Jimi", 10),
        Bajista("Flea", "Fender")
    )

    for (musico in array) {
        when (musico) {
            is Baterista -> println("Baterista ${musico.nome} toca bateria")
            is Guitarrista -> println("Guitarrista ${musico.nome} toca guitarra")
            is Bajista -> println("Bajista ${musico.nome} toca bajo")
        }
    }

    val array2: Array<Tocar> = arrayOf(
        Baterista("Ringo", 10),
        Guitarrista("Jimi", 10),
        Bajista("Flea", "Fender")
    )
    for (tocar in array2) {
        when (tocar) {
            is IBateria -> println("Bateria ${tocar.tocar()} toca bateria")
            is IGuitarra -> println("Guitarra ${tocar.tocar()} toca guitarra")
            is IBajista -> println("Bajo ${tocar.tocar()} toca bajo")
            is Baterista -> println("Baterista ${tocar.nome} toca bateria")
            is Guitarrista -> println("Guitarrista ${tocar.nome} toca guitarra")
            is Bajista -> println("Bajista ${tocar.nome} toca bajo")
            is Musico -> println("Musico ${tocar.nome} toca")
            else -> println("Tocar ${tocar.tocar()}")

        }
    }
}