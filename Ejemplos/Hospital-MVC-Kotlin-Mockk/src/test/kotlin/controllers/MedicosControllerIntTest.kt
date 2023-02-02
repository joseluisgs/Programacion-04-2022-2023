package controllers


import Exceptions.MedicoNotFoundException
import models.Anestesista
import models.AnestesistaCirujano
import models.Cirujano
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import repositories.MedicosRepository
import repositories.MedicosRepositoryMemory
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MedicosControllerIntTest {
    private lateinit var repository: MedicosRepository
    private lateinit var controller: MedicosController

    @BeforeEach
    fun setUp() {
        repository = MedicosRepositoryMemory()
        repository.saveAll(misMedicos)
        controller = MedicosController(repository)
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
        val res = controller.getAll()
        assertAll(
            { assertTrue(res.isNotEmpty()) },
            { assertTrue(res.contains(misMedicos[0])) },
        )
    }

    @Test
    fun getById() {
        val res = controller.getById(misMedicos[0].id)
        assertAll(
            { assertNotNull(res) },
            { assertEquals(misMedicos[0].nombre, res.nombre) },
        )
    }

    @Test
    fun getByIdNotFound() {
        val myId = UUID.randomUUID()
        val res = assertThrows<MedicoNotFoundException> {
            controller.getById(myId)
        }

        assertEquals("No se ha encontrado el medico con id: $myId", res.message)


    }

    @Test
    fun create() {
    }

    @Test
    fun update() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun getMedicosByEspecialidad() {
    }

    @Test
    fun deleteAll() {
    }
}