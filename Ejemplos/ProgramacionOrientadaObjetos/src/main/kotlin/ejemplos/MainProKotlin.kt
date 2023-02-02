package ejemplos

import ejemplos.models.AlumnoDataKotlin
import ejemplos.models.AlumnoProKotlin

fun main() {
    val a1 = AlumnoProKotlin(nombre = "Juan", apellido = "Perez", calificacion = 8.7238273)

    println(a1)
    println(a1.nombre)
    println(a1.apellido)
    println(a1.calificacion)
    println(a1.califcacionRedondeada)
    println(a1.isAprobado)
    println(a1.nombreCompleto)
    a1.nombreCompleto = "Pepito Data"
    println(a1)

    var a2 = AlumnoDataKotlin(nombre = "Ana", apellido = "Garcia", calificacion = 9.0)
    println(a2)
    println(a2.nombre)
    println(a2.apellido)
    println(a2.calificacion)
    println(a2.califcacionRedondeada)
    println(a2.isAprobado)

    val a3 = a2.copy(calificacion = 7.0)
    println(a3)

    val a4 = a2.copy(apellido = "Perez", calificacion = 5.0)

    // Con data clases yo puedo usar la desestructuracion de objetos
    val (_, nombre, _, calificacion) = a2
    println(nombre)
    println(calificacion)

    var arrayAlumnos = arrayOf(a3, a4)

    // For each
    for (alumno in arrayAlumnos) {
        println(alumno)
    }

    // forEach desestructurado
    for ((_, nombre, _, calificacion) in arrayAlumnos) {
        println("$nombre $calificacion")
    }

    // for indices
    for (i in arrayAlumnos.indices) {
        println(arrayAlumnos[i])
    }

    for (i in arrayAlumnos.withIndex()) {
        println("${i.index} ${i.value}")
    }

    for ((index, alumno) in arrayAlumnos.withIndex()) {
        println("$index: $alumno")
    }


}