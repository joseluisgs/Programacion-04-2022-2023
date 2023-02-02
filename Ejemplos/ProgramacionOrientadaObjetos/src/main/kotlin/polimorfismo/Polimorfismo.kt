package polimorfismo

abstract class A {
    init {
        println("soy A")
    }

    abstract fun f()
}

class B : A() {
    init {
        println("soy B")
    }

    override fun f() {
        println("B")
    }
}

open class C : A() {
    init {
        println("soy C")
    }

    override fun f() {
        println("C")
    }
}

class D : C() {
    init {
        println("soy D")
    }

    override fun f() {
        println("D")
    }
}

class E : C() {
    init {
        println("soy E")
    }

    fun g() {
        println("E")
    }
}


fun main() {
    val b = B()
    println()
    val c = C()
    println()
    val d = D()
    println()
    val e = E()

    println("-----")

    // Polimorfismo
    val b1: A = B()
    println()
    val c1: A = C()
    println()
    val d1: A = D()
    println()
    val e1: A = E()
    println()
    val d2: C = D()
    println()
    val e2: C = E()

    println("-----")

    b.f()
    c.f()
    d.f()
    e.f()
    e.g()

    println("-----")

    b1.f()
    c1.f()
    d1.f()
    e1.f()
    d2.f()
    e2.f()

    println("-----")

    // e2.g() // No es posible llamar a g() desde una variable de tipo C
    (e2 as E).g() // Si es posible llamar a g() desde una variable de tipo C, pero es necesario hacer un casting
    println()
    (e2 as A).f() // Si es posible llamar a f() desde una variable de tipo C, pero es necesario hacer un casting
    //(e2 as B).f() // Si es posible llamar a f()

    if (e2 is A) println("e2 es de tipo A")
    //if (e2 is B) println("e2 es de tipo B")
    if (e2 is C) println("e2 es de tipo C")
    if (e2 is D) println("e2 es de tipo D")
    if (e2 is E) println("e2 es de tipo E")

    // Viva la programación orientada a objetos

    // Cuando trabajamos con colecciones de objetos de distinto tipo
    // Hay que usar el tipo minimo comun para definirlas

    val array1: Array<A> = arrayOf(b, c, d, e, b1, c1, d1, e1, d2, e2)
    val array2: Array<B> = arrayOf(b)
    val array3: Array<C> = arrayOf(c, e2)
    // val array4: Array<D> = arrayOf(d)
    val array5: Array<E> = arrayOf(e, e2)
    val array6: Array<Any> = arrayOf(b, c, d, e, b1, c1, d1, e1, d2, e2, "Hola", 1, 2.0, true)

    for (a in array6) {
        when (a) {
            is A -> println("a es de tipo A")
            is B -> println("a es de tipo B")
            is C -> println("a es de tipo C")
            is D -> println("a es de tipo D")
            is E -> println("a es de tipo E")
            is String -> println("a es de tipo String")
            is Int -> println("a es de tipo Int")
            is Double -> println("a es de tipo Double")
            is Boolean -> println("a es de tipo Boolean")
        }

        if (a is String) {
            println("Longitud es ${a.length}")
            val b = a
            println("Longitud es ${b.uppercase()}")
        }
    }

}