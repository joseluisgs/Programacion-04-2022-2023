import Exceptions.MedicoBadRequest
import Exceptions.MedicoNotFoundException
import controllers.MedicosController
import models.Anestesista
import models.AnestesistaCirujano
import repositories.MedicosRepositoryMemory
import java.util.*

fun main(args: Array<String>) {
    println("Hola Hospital!")

    val medicosController = MedicosController(
        MedicosRepositoryMemory()
    )

    var res = medicosController.getAll()
    println(res.joinToString("\n"))

    val medico = medicosController.getById(res[0].id)
    println(medico)

    try {
        val medico2 = medicosController.getById(UUID.randomUUID())
        println(medico2)
    } catch (e: MedicoNotFoundException) {
        System.err.println("ERROR al consultar: ${e.message}")
    }

    val new = Anestesista(
        id = UUID.randomUUID(),
        nombre = "Anestesista 1",
        añosExperiencia = 5
    )

    val newMedico = medicosController.create(new)
    println(newMedico)

    val newFails = Anestesista(
        id = newMedico.id,
        nombre = "Caca",
        añosExperiencia = -1
    )

    try {
        val newMedico2 = medicosController.create(newFails)
        println(newMedico2)
    } catch (e: MedicoBadRequest) {
        System.err.println("ERROR al crear: ${e.message}")
    }

    val update = AnestesistaCirujano(
        id = newMedico.id,
        nombre = "Updated",
        añosExperiencia = 10,
        quirofano = 1
    )

    val updated = medicosController.update(update.id, update)
    println(updated)

    val deleted = medicosController.delete(updated.id)
    println(deleted)

}