package herencia.models

import java.time.LocalDate
import java.util.*

// al decir que es open estamos indicando que esta clase puede ser heredada e instanciada
// si ponemos abstract no se puede instanciar pero si heredar
// si ponemos sealed no se puede instanciar ni heredar
// si ponemos final no se puede heredar pero si instanciar
abstract class Persona(val nombre: String, val edad: Int) {
    open val id = UUID.randomUUID().toString()
    protected val fechaNacimiento = LocalDate.now().minusYears(edad.toLong()).toString()

    constructor(nombre: String, fechaNacimiento: LocalDate) :
            this(nombre, fechaNacimiento.until(LocalDate.now()).years)

    fun presentarse() {
        println("Persona: Hola soy llamo $nombre y tengo $edad años con id $id y nací en $fechaNacimiento")
    }

    open fun entrenar() {
        println("Persona: Soy $nombre y estoy entrenando")
    }

    abstract fun hidratarse()

}