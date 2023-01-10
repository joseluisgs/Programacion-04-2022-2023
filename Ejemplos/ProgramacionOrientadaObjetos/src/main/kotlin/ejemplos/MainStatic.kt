package ejemplos

import ejemplos.models.Perro
import ejemplos.models.PerroJava

fun main() {
    val p1 = PerroJava("Firulais", "caniche")
    val p2 = PerroJava("Salchi", "salchicha")
    println(p1)
    PerroJava.ladrar()
    PerroJava.nombre = "Pepito"

    val p3 = PerroJava("Sergi", "Buldog Frances")

    val p4 = Perro("Firulais", "caniche")
    Perro.ladrar()
    Perro.nombre = "Pepito"


}