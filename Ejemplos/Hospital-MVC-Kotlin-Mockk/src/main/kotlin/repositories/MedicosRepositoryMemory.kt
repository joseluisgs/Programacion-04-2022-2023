package repositories

import models.*
import java.util.*

private val logger = mu.KotlinLogging.logger {}

class MedicosRepositoryMemory : MedicosRepository {
    private val dbStep = 3
    private var db = Array<Medico?>(this.dbStep) { null }


    init {
        logger.debug { "Iniciando repositorio de Medicos en memoria" }

        db = arrayOf(
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
    }

    override fun getAll(): Array<Medico> {
        logger.debug { "Repositorio fun getAll" }
        val res = Array<Medico?>(numberOfMedicos()) { null }
        // Copiamos los elementos no nulos de db que no sean nulos
        var i = 0
        for (medico in db) {
            if (medico != null) {
                res[i] = medico
                i++
            }
        }
        return res as Array<Medico>
    }

    override fun getById(id: UUID): Medico? {
        logger.debug { "Repositorio fun getById" }
        for (medico in db) {
            if (medico != null && medico.id == id) {
                return medico
            }
        }
        return null
    }

    override fun create(medico: Medico): Medico {
        logger.debug { "Repositorio fun create" }
        if (db.size == numberOfMedicos()) {
            redimensionar(this.dbStep)
        }
        db[numberOfMedicos()] = medico
        return medico
    }

    override fun update(id: UUID, medico: Medico): Medico? {
        logger.debug { "Repositorio fun update" }
        for (i in db.indices) {
            if (db[i] != null && db[i]!!.id == id) {
                db[i] = medico
                return medico
            }
        }
        return null
    }

    override fun delete(id: UUID): Medico? {
        logger.debug { "Repositorio fun delete" }
        for (i in db.indices) {
            if (db[i] != null && db[i]!!.id == id) {
                val res = db[i]
                db[i] = null
                // Redimensionamos el array
                if (db.size - numberOfMedicos() > this.dbStep) {
                    redimensionar(-this.dbStep)
                }
                return res
            }
        }
        return null
    }

    override fun getMedicosByEspecialidad(especialidad: Especialidad): Array<Medico> {
        logger.debug { "Repositorio fun getMedicosByEspecialidad" }
        return when (especialidad) {
            Especialidad.CIRUJIA -> buscarCirujanos()
            Especialidad.ANESTESIA -> buscarAnestesistas()
            else -> emptyArray()
        }
    }

    override fun deleteAll() {
        logger.debug { "fun deleteAll" }
        for (i in db.indices) {
            db[i] = null
        }
    }

    override fun saveAll(medicos: Array<Medico>) {
        logger.debug { "Repositorio fun saveAll" }
        for (medico in medicos) {
            create(medico)
        }
    }

    private fun redimensionar(tam: Int) {
        logger.debug { "Repositorio fun redimensionar Positivo" }
        val newDb = Array<Medico?>(db.size + tam) { null }

        logger.debug { "Db.size = ${db.size}" }
        logger.debug { "newDb.size = ${newDb.size}" }

        var index = 0
        for (i in db.indices) {
            if (db[i] != null) {
                newDb[index] = db[i]
                index++
            }
        }

        db = newDb
    }

    private fun numberOfMedicos(): Int {
        logger.debug { "Repositorio fun numberOfMedicos" }
        var count = 0
        for (medico in db) {
            if (medico != null) {
                count++
            }
        }
        return count
    }

    private fun buscarCirujanos(): Array<Medico> {
        logger.debug { "Repositorio fun buscarCirujanos" }
        // cuantos cirujanos hay?
        var count = 0
        for (medico in db) {
            if (medico != null && medico is ICirujano) {
                count++
            }
        }
        val res = Array<Medico?>(count) { null }
        var i = 0
        for (medico in db) {
            if (medico != null && medico is ICirujano) {
                res[i] = medico
                i++
            }
        }
        return res as Array<Medico>
    }

    private fun buscarAnestesistas(): Array<Medico> {
        logger.debug { "Repositorio fun buscarAnestesistas" }
        // cuantos anestesistas hay?
        var count = 0
        for (medico in db) {
            if (medico != null && medico is IAnestesista) {
                count++
            }
        }
        val res = Array<Medico?>(count) { null }
        var i = 0
        for (medico in db) {
            if (medico != null && medico is IAnestesista) {
                res[i] = medico
                i++
            }
        }
        return res as Array<Medico>
    }
}