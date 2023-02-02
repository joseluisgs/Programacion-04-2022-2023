package controllers


import Exceptions.MedicoBadRequest
import Exceptions.MedicoNotFoundException
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import models.Anestesista
import models.AnestesistaCirujano
import models.Cirujano
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import repositories.MedicosRepository
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockKExtension::class) // Vamos a usar Mockk
class MedicosControllerTest {
    @MockK
    private lateinit var repository: MedicosRepository

    @InjectMockKs
    private lateinit var controller: MedicosController

    // Es equivalente a esto
    // private var repo1 = mockk<MedicosRepository>()
    // private var controller1 = MedicosController(repo1)

    init {
        MockKAnnotations.init(this)
    }

    val misMedicos = arrayOf(
        Cirujano(
            id = UUID.fromString("ee031a69-f19a-4cff-bdd3-f81d7f1dc23d"),
            nombre = "Cirujano 1",
            habilidad = "Cirugía general"
        ),
        Anestesista(
            id = UUID.fromString("29dd6206-a589-445c-929d-ef5fe5f3e8bf"),
            nombre = "Anestesista 1",
            añosExperiencia = 5
        ),
        AnestesistaCirujano(
            id = UUID.fromString("6eada70b-7e6e-4840-996a-3d859b95f0fa"),
            nombre = "Anestesista Cirujano 1",
            añosExperiencia = 10,
            quirofano = 1
        )
    )


    @Test
    fun getAll() {
        // Cuando se llame al método getAll del repositorio devolverá misMedicos
        every { repository.getAll() } returns misMedicos

        val res = controller.getAll()

        assertAll(
            { assertNotNull(res) },
            { assertEquals(misMedicos.size, res.size) },
            { assertEquals(misMedicos[0].nombre, res[0].nombre) },
            { assertEquals(misMedicos[1].nombre, res[1].nombre) },
            { assertEquals(misMedicos[2].nombre, res[2].nombre) },
        )

        // Verifico si realmente se ha llamado al método getAll del repositorio
        verify { repository.getAll() }
    }

    @Test
    fun getById() {
        // Cuando se llame al método getById del repositorio devolverá misMedicos[0]
        every { repository.getById(misMedicos[0].id) } returns misMedicos[0]

        val res = controller.getById(misMedicos[0].id)
        assertAll(
            { assertNotNull(res) },
            { assertEquals(misMedicos[0].nombre, res.nombre) },
        )

        // Verifico si realmente se ha llamado al método getById del repositorio
        verify { repository.getById(misMedicos[0].id) }
    }

    @Test
    fun getByIdNotFound() {
        // Cuando se llame al método getById del repositorio devolverá null
        every { repository.getById(any()) } returns null

        val res = assertThrows<MedicoNotFoundException> {
            controller.getById(misMedicos[0].id)
        }

        assertEquals("No se ha encontrado el medico con id: ${misMedicos[0].id}", res.message)

        verify { repository.getById(any()) }
    }

    @Test
    fun create() {
        // Cuando se llame al método create del repositorio devolverá misMedicos[0]
        every { repository.create(misMedicos[0]) } returns misMedicos[0]

        val res = controller.create(misMedicos[0])

        assertAll(
            { assertNotNull(res) },
            { assertEquals(misMedicos[0].nombre, res.nombre) },
        )
    }

    @Test
    fun checkInvalidNombre() {
        val cirujano = Cirujano(
            id = UUID.fromString("ee031a69-f19a-4cff-bdd3-f81d7f1dc23d"),
            nombre = "",
            habilidad = "Cirugía general"
        )

        // Cuando se llame al método create del repositorio devolverá null
        val res = assertThrows<MedicoBadRequest> {
            controller.create(cirujano)
        }

        assertEquals("No se ha podido crear el medico: El nombre no puede estar vacío", res.message)

    }

    @Test
    fun update() {
        // Cuando se llame al método update del repositorio devolverá misMedicos[0]
        every { repository.getById(any()) } returns misMedicos[0]
        every { repository.update(any(), any()) } returns misMedicos[0]

        val res = controller.update(misMedicos[0].id, misMedicos[0])

        assertAll(
            { assertNotNull(res) },
            { assertEquals(misMedicos[0].nombre, res.nombre) },
        )

        verify { repository.getById(any()) }
        verify { repository.update(any(), any()) }
    }

    @Test
    fun updateNotFound() {
        // Cuando se llame al método update del repositorio devolverá misMedicos[0]
        every { repository.getById(any()) } returns null

        val res = assertThrows<MedicoNotFoundException> {
            controller.update(misMedicos[0].id, misMedicos[0])
        }

        assertEquals("No se ha encontrado el medico con id: ${misMedicos[0].id}", res.message)

        verify { repository.getById(any()) }
    }

    @Test
    fun delete() {
        // Cuando se llame al método delete del repositorio devolverá misMedicos[0]
        every { repository.getById(any()) } returns misMedicos[0]
        every { repository.delete(any()) } returns misMedicos[0]

        val res = controller.delete(misMedicos[0].id)

        assertAll(
            { assertNotNull(res) },
            { assertEquals(misMedicos[0].nombre, res.nombre) },
        )
    }

    @Test
    fun deleteNotFound() {
        // Cuando se llame al método delete del repositorio devolverá null
        every { repository.getById(any()) } returns null

        val res = assertThrows<MedicoNotFoundException> {
            controller.delete(misMedicos[0].id)
        }

        assertEquals("No se ha encontrado el medico con id: ${misMedicos[0].id}", res.message)
    }

    @Test
    fun getMedicosByEspecialidad() {
    }

    @Test
    fun deleteAll() {
    }
}