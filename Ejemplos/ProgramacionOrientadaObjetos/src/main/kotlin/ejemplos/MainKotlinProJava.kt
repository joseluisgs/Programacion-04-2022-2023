package ejemplos

import ejemplos.models.AlumnoProJava

fun main(args: Array<String>) {
    println("Hola Objetos!!!")

    val a1 = AlumnoProJava("Juan", "Perez", -1.0)
    println(a1.info())
    a1.setNombre("Pepe")
    a1.setApellido("Perez")
    a1.setCalificacion(7.77777) // Prueba a poner -1 o 11
    a1.presentar()
    println(a1.info())
    val aprobado = a1.getAprobado()
    println(a1.getNombreCompleto())
    println(aprobado)
    println(a1.getCalificacion(2))
    println(a1.calificacionEvaluacion())

    // Podemos definir o crear el alumnos con los constructores que hemos definido
    val a2 = AlumnoProJava("Ana", "Garcia")
    val a3 = AlumnoProJava(calificacion = 8.0, apellido = "Garcia", nombre = "Luis")
    val a4 = AlumnoProJava(apellido = "Altunez", nombre = "Pedro")
    val a5 = AlumnoProJava("Maria Garcia", 9.0)
    val a6 = AlumnoProJava("Luis Perez")
    val a7 = AlumnoProJava(apellido = "Perez", nombre = "Luis", examen = 8.0, practicas = 9.0)
    val a8 = AlumnoProJava("Luis", "Perez", 9.0, 8.0)

    val listaAlumnoProJavas = Array<AlumnoProJava?>(5) { null }
    listaAlumnoProJavas[0] = a1
    listaAlumnoProJavas[1] = a2
    listaAlumnoProJavas[2] = a3
    listaAlumnoProJavas[3] = a4

    // CUIDADO CON LOS NULOS!!!!

    for (alumno in listaAlumnoProJavas) {
        alumno?.presentar()
    }

    var acumulado = 0.0
    for (alumno in listaAlumnoProJavas) {
        acumulado += alumno?.getCalificacion(2) ?: 0.0
    }
    // Hay que ver el tamaño real por los nulos!!!
    var tamañoReal = 0
    for (i in 0 until listaAlumnoProJavas.size) {
        if (listaAlumnoProJavas[i] != null) {
            tamañoReal++
        }
    }
    println("El promedio de calificaciones es: ${acumulado / tamañoReal}")

    // Ordenamos por nota de mayor a menor con burbuja basada en calificacion
    for (i in 0 until listaAlumnoProJavas.size - 1) {
        for (j in 0 until listaAlumnoProJavas.size - 1 - i) {
            if ((listaAlumnoProJavas[j]?.getCalificacion(2) ?: -1.0) < (listaAlumnoProJavas[j + 1]?.getCalificacion(2)
                    ?: -1.0)
            ) {
                val aux = listaAlumnoProJavas[j]
                listaAlumnoProJavas[j] = listaAlumnoProJavas[j + 1]
                listaAlumnoProJavas[j + 1] = aux
            }
        }
    }

    println("Lista de alumnos ordenada por calificación de mayor a menor")
    for (alumno in listaAlumnoProJavas) {
        alumno?.presentar()
    }

    // val pares = Array<Pair<Int, Boolean>?>(10) { null }

    val p1 = AlumnoProJava("Juan", "Perez", 7.0)
    val p2 = AlumnoProJava("Juan", "Perez", 7.0)
    val p3 = p1

    println(p1.info())
    println(p2.info())
    println(p3.info())

    // Igualdad == : dos objetos son iguales si tienen el mismo estado: tener el equals
    println("p1 equals p2: ${p1.equals(p2)}")
    println("p1 == p2: ${p1 == p2}")

    // Identidad === : dos objetos son iguales si son el mismo objeto
    println("p1 === p2: ${p1 === p2}")
    println("p1 === p3: ${p1 === p3}")

    // Podemos definirnos nuestro propio toString()
    println(p1)

    println("p1.hashCode(): ${p1.hashCode()}")

    // Podemos saber si dos objetos son iguales en base a su hashcode
    println("p1.hashCode() == p2.hashCode(): ${p1.hashCode() == p2.hashCode()}")


}