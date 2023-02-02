package interfaces

abstract class Animal {
    var name: String = ""

    abstract fun comer()
}

interface Terrestre {
    fun caminar()
}

interface Acuatico {
    fun nadar()
}

interface Mamifero {
    fun mamar()
    fun respirar() {
        println("Respirando")
    }

    val piernas: Int
}

interface Oviparo {
    fun empollar()
}


class Perro : Animal(), Mamifero {
    fun ladrar() {
        println("Perro: Estoy ladrando")
    }

    override fun comer() {
        println("Perro: Estoy comiendo")
    }

    override fun mamar() {
        println("Perro: Estoy mamando")
    }

    override fun respirar() {
        println("Perro: Estoy respirando")
    }

    override var piernas: Int = 4
}

class Gato : Animal(), Mamifero {
    fun maullar() {
        println("Gato: Estoy maullando")
    }

    override fun comer() {
        println("Gato: Estoy comiendo")
    }

    override fun mamar() {
        println("Gato: Estoy mamando")
    }

    override val piernas: Int = 4
}

class Pajaro : Animal(), Oviparo {
    fun graznar() {
        println("Pato: Estoy piando")
    }

    override fun comer() {
        println("Pato: Estoy comiendo")
    }

    override fun empollar() {
        println("Pato: Estoy empollando")
    }
}

class Serpiente : Animal(), Oviparo {
    fun sisear() {
        println("Serpiente: Estoy siseando")
    }

    override fun comer() {
        println("Serpiente: Estoy comiendo")
    }

    override fun empollar() {
        println("Serpiente: Estoy empollando")
    }
}

class Ornitorrinco : Animal(), Mamifero, Oviparo {
    fun graznar() {
        println("Ornitorrinco: Estoy piando")
    }

    override val piernas: Int = 4

    override fun comer() {
        println("Ornitorrinco: Estoy comiendo")
    }

    override fun mamar() {
        println("Ornitorrinco: Estoy mamando")
    }

    override fun empollar() {
        println("Ornitorrinco: Estoy empollando")
    }
}

fun main() {
    val animales: Array<Animal> = arrayOf(
        Perro(),
        Gato(),
        Pajaro(),
        Serpiente(),
        Ornitorrinco()
    )
    val perro: Array<Perro> = arrayOf(Perro())
    val ornitorrinco: Array<Ornitorrinco> = arrayOf(Ornitorrinco())

    for (animal in animales) {
        animal.comer()
        if (animal is Mamifero) {
            animal.mamar()
        }
        if (animal is Oviparo) {
            animal.empollar()
        }
        if (animal is Perro) {
            animal.ladrar()
        }
    }

    val mamiferos: Array<Mamifero> = arrayOf(Perro(), Gato(), Ornitorrinco())
    for (mamifero in mamiferos) {
        mamifero.mamar()
        if (mamifero is Perro) {
            mamifero.ladrar()
        }
    }
    val oviparos: Array<Oviparo> = arrayOf(Pajaro(), Serpiente(), Ornitorrinco())
    for (oviparo in oviparos) {
        oviparo.empollar()
    }

    casoEspecial(Perro(), Perro(), Serpiente(), Perro(), Ornitorrinco())
    casoEspecial(Ornitorrinco(), Gato(), Pajaro(), Perro(), Ornitorrinco())
    casoEspecial(Ornitorrinco(), Ornitorrinco(), Ornitorrinco(), Perro(), Ornitorrinco())
}

fun casoEspecial(
    animal: Animal,
    mamifero: Mamifero,
    oviparo: Oviparo,
    perro: Perro,
    ornitorrinco: Ornitorrinco
) {
    animal.comer()
    mamifero.mamar()
    oviparo.empollar()
    perro.ladrar()
    perro.mamar()
    ornitorrinco.graznar()
    ornitorrinco.mamar()
    ornitorrinco.empollar()
    ornitorrinco.empollar()
}















