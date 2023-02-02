package repositories

import models.Anestesista
import models.AnestesistaCirujano
import models.Cirujano
import models.Especialidad
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MedicosRepositoryMemoryTest {
    private lateinit var repository: MedicosRepository

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

    @BeforeAll
    fun setUpAll() {
        println("setUpAll")
    }

    @BeforeEach
    fun setUp() {
        repository = MedicosRepositoryMemory()
        repository.saveAll(misMedicos)
    }

    @Test
    fun getAll() {
        val medicos = repository.getAll()
        assertAll(
            { assertEquals(3, medicos.size) },
            { assertEquals(misMedicos[0], medicos[0]) },
            { assertEquals(misMedicos[1], medicos[1]) },
            { assertEquals(misMedicos[2], medicos[2]) }
        )
    }

    @Test
    fun getById() {
        val medico = repository.getById(misMedicos[0].id)
        assertEquals(misMedicos[0], medico)
    }

    @Test
    fun getByIdNotFound() {
        val medico = repository.getById(UUID.randomUUID())
        assertNull(medico)
    }

    @Test
    fun create() {
        val medico = Cirujano(
            id = UUID.fromString("ee031a69-f19a-4cff-bdd3-f81d7f1dc23d"),
            nombre = "Cirujano 1",
            habilidad = "Cirugía general"
        )

        val medicoCreado = repository.create(medico)
        assertAll(
            { assertEquals(medico, medicoCreado) },
            { assertEquals(medico.nombre, medicoCreado.nombre) },
        )
    }

    @Test
    fun create30Medicos() {
        val medicos = Array(30) { i ->
            Cirujano(
                id = UUID.randomUUID(),
                nombre = "Cirujano $i",
                habilidad = "Cirugía general"
            )
        }
        for (medico in medicos) {
            repository.create(medico)
        }
        val medicosCreados = repository.getAll()

        assertEquals(33, medicosCreados.size)

        for (medico in medicos) {
            assertTrue(medicosCreados.contains(medico))
        }
    }


    @Test
    fun update() {
        val medico = Cirujano(
            id = UUID.fromString("ee031a69-f19a-4cff-bdd3-f81d7f1dc23d"),
            nombre = "TEST",
            habilidad = "TEST"
        )
        val res = repository.update(medico.id, medico)

        assertAll(
            { assertEquals(medico, res) },
            { assertEquals(medico.nombre, res?.nombre) },
        )
    }

    @Test
    fun updateNotFound() {
        val medico = Cirujano(
            id = UUID.randomUUID(),
            nombre = "TEST",
            habilidad = "TEST"
        )
        val res = repository.update(medico.id, medico)

        assertNull(res)
    }

    @Test
    fun delete() {
        val medico = misMedicos[0]
        val res = repository.delete(misMedicos[0].id)

        assertAll(
            { assertEquals(medico, res) },
            { assertEquals(medico.nombre, res?.nombre) },
        )
    }

    @Test
    fun deleteNotFound() {
        val res = repository.delete(UUID.randomUUID())
        assertNull(res)
    }

    @Test
    fun delete10Medicos() {
        val medicos = Array(30) { i ->
            Cirujano(
                id = UUID.randomUUID(),
                nombre = "Cirujano $i",
                habilidad = "Cirugía general"
            )
        }
        for (medico in medicos) {
            repository.create(medico)
        }
        val medicosCreados = repository.getAll()

        assertEquals(33, medicosCreados.size)

        for (medico in medicos) {
            repository.delete(medico.id)
        }

        val medicosCreados2 = repository.getAll()

        assertEquals(3, medicosCreados2.size)
    }

    @Test
    fun getMedicosByEspecialidad() {
        val cirujanos = repository.getMedicosByEspecialidad(Especialidad.CIRUJIA)
        val anestesistas = repository.getMedicosByEspecialidad(Especialidad.ANESTESIA)

        assertAll(
            { assertEquals(2, cirujanos.size) },
            { assertEquals(2, anestesistas.size) },
        )
    }

    @Test
    fun deleteAll() {
        repository.deleteAll()
        val medicos = repository.getAll()
        assertEquals(0, medicos.size)
    }

}