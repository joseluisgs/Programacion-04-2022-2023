package aula

import aula.models.Alumno
import aula.models.Curso
import aula.models.Tutor
import kotlin.system.exitProcess

// Es mi estado compartido!!!
var curso = Curso("", "", Tutor(""))

fun main() {
    menuGestion()
}

fun simulacion() {

    Alumno.respirar()
    val a1 = Alumno.random()

    val alumnado = arrayOf(
        Alumno("Juan", 8.7238273),
        Alumno("Ana", 4.4),
        Alumno("Luis", 6.2567),
        Alumno("María", 9.75),
        Alumno("Pedro", 2.25)
    )

    curso.clear()

    curso = Curso("1º DAM", "2020/2021", Tutor("Juan"))

    // Me creo 5 alumnos
    curso.createAlumno(alumnado[0])
    curso.createAlumno(alumnado[1])
    curso.createAlumno(alumnado[2])
    curso.createAlumno(alumnado[3])
    curso.createAlumno(alumnado[4])

    println("Curso: $curso")

    println("Listar alumnos ordenados por nota descendente...")
    curso.getAllAlumnosOrderByNotasDesc()

    println("Obtener alumno por id")
    println(curso.getAlumnoById(3) ?: "No existe")
    println(curso.getAlumnoById(99) ?: "No existe")

    println("Crear alumno...")
    println(
        curso.createAlumno(
            Alumno(nombre = "Create", nota = 7.72)
        )
            ?: "Aula completa, no se ha podido insertar"
    )

    println("Actualizar alumno...")
    var alumno = curso.getAlumnoById(3)
    println(
        curso.updateAlumno(
            alumno?.copy(nombre = "Update", nota = 7.72)!!
        )
            ?: "No se ha podido actualizar"
    )

    alumno = curso.getAlumnoById(99)


    println("Eliminar alumno...")
    println(
        curso.deleteAlumnoById(1)
            ?: "No existe el alumno y no se ha podido eliminar"
    )
    println(
        curso.deleteAlumnoById(99)
            ?: "No existe el alumno y no se ha podido eliminar"
    )

    println(
        curso.deleteAlumno(curso.getAlumnoById(4)!!)
            ?: "No existe el alumno y no se ha podido eliminar"
    )
    println("Listar alumnos ordenados por nota descendente...")
    curso.getAllAlumnosOrderByNotasDesc()

    println("Informe de resultados...")
    println(curso.getInforme())
}

fun menuGestion() {
    val menu = """
        1. Crear Curso
        2. Listar alumnos
        3. Crear alumno
        4. Buscar alumno
        5. Actualizar alumno
        6. Eliminar alumno
        7. Informe de resultados
        8. Simulacion
        0. Salir
    """.trimIndent()

    do {
        println(menu)
        val menuChoice = readln().toIntOrNull() ?: -1
        when (menuChoice) {
            1 -> crearCurso()
            2 -> listarAlumnos()
            3 -> crearAlumno()
            4 -> buscarAlumno()
            5 -> actualizarAlumno()
            6 -> eliminarAlumno()
            7 -> informeResultados()
            8 -> simulacion()
            0 -> salir()
            else -> {
                println("Opción incorrecta, vuelve a intentarlo")
            }
        }
    } while (true)
}

fun informeResultados() {
    println("Informe de resultados")
    if (curso.nombre.isEmpty()) {
        println("ERROR: No hay curso creado")
    } else {
        println(curso.getInforme())
    }
}


fun eliminarAlumno() {
    println("Eliminar alumno")
    var id = -1
    do {
        println("Introduce el id del alumno a eliminar")
        id = readln().toIntOrNull() ?: -1
    } while (id == -1)
    val alumnoEliminado = curso.deleteAlumnoById(id)
    println("Alumno buscado: ${alumnoEliminado ?: "ERROR: No existe el alumno con id $id"}")
}

fun actualizarAlumno() {
    println("Actualizar alumno")
    var id = -1
    do {
        println("Introduce el id del alumno a actualizar")
        id = readln().toIntOrNull() ?: -1
    } while (id == -1)
    var alumno = curso.getAlumnoById(id)
    if (alumno != null) {
        var nombre = ""
        do {
            println("Nombre:")
            nombre = readln().trim()
        } while (nombre.isEmpty())
        var nota = 0.0
        do {
            println("Nota [0-10]:")
            nota = readln().toDoubleOrNull() ?: -1.0
        } while (nota !in 0.0..10.0)
        alumno = alumno.copy(nombre = nombre, nota = nota)
        val alumnoActualizado = curso.updateAlumno(alumno)
        println("Alumno buscado: ${alumnoActualizado ?: "ERROR: No existe el alumno con id $id"}") // Ya sabemos que no es nulo
    } else {
        println("No existe el alumno")
    }
}

fun buscarAlumno() {
    println("Buscar alumno")
    var id = -1
    do {
        println("Introduce el id del alumno")
        id = readln().toIntOrNull() ?: -1
    } while (id == -1)
    println("Buscando alumno")
    val alumnoBuscado = curso.getAlumnoById(id)
    println("Alumno buscado: ${alumnoBuscado ?: "ERROR: No existe el alumno con id $id"}")
}

fun crearAlumno() {
    println("Crear alumno")
    var nombre = ""
    do {
        println("Nombre:")
        nombre = readln().trim()
    } while (nombre.isEmpty())
    var nota = 0.0
    do {
        println("Nota [0-10]:")
        nota = readln().toDoubleOrNull() ?: -1.0
    } while (nota !in 0.0..10.0)
    val alumno = Alumno(nombre = nombre, nota = nota)
    val alumnoCreado = curso.createAlumno(alumno)
    println("Alumno creado: ${alumnoCreado ?: "ERROR: Aula completa, no se ha podido insertar"}")
}

fun listarAlumnos() {
    println("Listar alumnos ordenados por nota descendente")
    if (curso.id == 0) {
        println("ERROR: No hay curso creado")
    } else if (curso.totalAlumnos() == 0) {
        println("ERROR: No hay alumnos en el curso")
    } else {
        curso.getAllAlumnosOrderByNotasDesc()
    }
}

fun crearCurso() {
    println("Crear curso")

    var id = ""
    do {
        println("Id:")
        id = readln().trim()
    } while (id.isEmpty())

    var nombre: String = ""
    do {
        println("Introduce el nombre del curso:")
        nombre = readln().trim()
    } while (nombre.isEmpty())

    var año = ""
    do {
        println("Introduce el año del curso:")
        val añoRegex = Regex("[0-9]{4}/[0-9]{4}")
        año = readln().trim()
    } while (!añoRegex.matches(año))

    var tutor: String = ""
    do {
        println("Introduce el nombre del tutor:")
        tutor = readln().trim()
    } while (tutor.isEmpty())

    curso = Curso(nombre = nombre, año = año, tutor = Tutor(nombre = tutor))

    println("Curso creado: $curso")

}

fun salir() {
    println("Saliendo...")
    exitProcess(0)
}

