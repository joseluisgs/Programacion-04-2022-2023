package aula.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class CursoTest {
    private val curso = Curso("1º DAM", "2022/2023", Tutor("Pepe Perez"))
    val alumnado = arrayOf(
        Alumno("Juan", 8.7238273),
        Alumno("Ana", 4.4),
        Alumno("Luis", 6.2567),
        Alumno("María", 9.75),
        Alumno("Pedro", 2.25)
    )

    @BeforeEach
    fun setUpTest() {
        // Borramos todos los alumnos
        curso.clear()
        // Me creo 5 alumnos
        curso.createAlumno(alumnado[0])
        curso.createAlumno(alumnado[1])
        curso.createAlumno(alumnado[2])
        curso.createAlumno(alumnado[3])
        curso.createAlumno(alumnado[4])
        // Comprobamos que se han creado
    }


    @Test
    fun createAlumno() {
        // Crear alumno
        val alumno = Alumno(nombre = "Create", nota = 7.72)
        val alumnoCreado = curso.createAlumno(alumno)
        assertEquals(alumno, alumnoCreado)
        val otro = Alumno.create("Create", 7.72)
        assertEquals(otro, alumnoCreado)

    }

    @Test
    @Order(1)
    fun getAlumnoById() {
        // Obtener alumno por id
        val alumno = curso.getAlumnoById(3)
        assertAll(
            { assertNotNull(alumno) },
            { assertEquals(3, alumno?.id) },
            { assertEquals("Luis", alumno?.nombre) },
            { assertEquals(6.25, alumno?.califcacion) }
        )

        // y si no existe
        assertNull(curso.getAlumnoById(-99))

    }

    @Test
    fun updateAlumno() {
        // Obtener alumno por id
        val alumno = curso.getAlumnoById(3)
        alumno!!.nota = 7.75
        var alumnoActualizado = curso.updateAlumno(alumno)
        assertEquals(alumno, alumnoActualizado)
        //alumno.nota = 6.25
        //alumnoActualizado = curso.updateAlumno(alumno)
    }

    @Test
    fun deleteAlumnoById() {
        val id = alumnado[0].id
        val alumno = curso.deleteAlumnoById(id)
        assertAll(
            { assertNotNull(alumno) },
            { assertEquals(id, alumno?.id) },
        )

        // y si no existe
        assertNull(curso.deleteAlumnoById(-99))
    }

    @Test
    fun deleteAlumno() {
        val alumno = Alumno(nombre = "Delete", nota = 10.0)
        val alumnoEliminado = curso.deleteAlumno(alumno)
        assertEquals(alumno.id, alumnoEliminado?.id)
    }

    @Test
    @Order(2)
    fun getAllAlumnosOrderByNotasDesc() {
        // Ordenamos los alumnos
        curso.getAllAlumnosOrderByNotasDesc()
        // Comprobamos que están ordenados
        assertEquals(9.75, curso.getAlumnoById(4)!!.califcacion)
        assertEquals(8.72, curso.getAlumnoById(1)!!.califcacion)
        assertEquals(6.25, curso.getAlumnoById(3)!!.califcacion)
        assertEquals(4.4, curso.getAlumnoById(2)!!.califcacion)
        assertEquals(2.25, curso.getAlumnoById(5)!!.califcacion)
    }

    @Test
    @Order(4)
    fun getInforme() {
        // Obtener informe
        val informe = curso.getInforme()
        val esperado = """
            Curso: 1º DAM
            Año: 2022/2023
            Tutor/a: Pepe Perez
            Número de alumnos: 5
            Número de aprobados: 3
            Número de suspensos: 2
            Porcentaje de aprobados: 60.0%
            Porcentaje de suspensos: 40.0%
            Nota media: 6.27
        """.trimIndent()
        assertEquals(esperado, informe)
    }

    @Test
    @Order(3)
    fun getNotaMedia() {
        assertEquals(6.27, curso.getNotaMedia())
    }

    @Test
    fun getNumAprobados() {
        assertEquals(3, curso.getNumAprobados())
    }
}