package controllers

import Exceptions.MedicoBadRequest
import Exceptions.MedicoNotFoundException
import models.*
import repositories.MedicosRepository
import java.util.*

private val logger = mu.KotlinLogging.logger {}

class MedicosController(
    private val medicosRepository: MedicosRepository
) {

    init {
        logger.debug { "Iniciando controlador de Medicos" }
    }

    fun getAll(): Array<Medico> {
        logger.debug { "Controlador getAll" }
        return medicosRepository.getAll()
    }

    /**
     * Devuelve el medico con el id indicado
     * @param id id del medico a buscar
     * @return medico con el id indicado
     * @throws MedicoNotFoundException si no existe el medico con el id indicado
     */
    fun getById(id: UUID): Medico {
        logger.debug { "Controlador getById" }
        return medicosRepository.getById(id)
            ?: throw MedicoNotFoundException(id.toString())
    }

    fun create(medico: Medico): Medico {
        logger.debug { "Controlador create" }
        // Analizamos los campos
        comprobarRestriccionesDominio(medico)

        return medicosRepository.create(medico)
    }

    fun update(id: UUID, medico: Medico): Medico {
        logger.debug { "Controlador update" }
        // Comprobamos las restricciones del dominio
        comprobarRestriccionesDominio(medico)

        // Comprobamos que el medico a actualizar existe
        val existe = this.getById(id)

        return medicosRepository.update(id, medico)!!
    }

    fun delete(id: UUID): Medico {
        logger.debug { "Controlador delete" }
        val existe = this.getById(id)
        return medicosRepository.delete(id)!!
    }

    fun getMedicosByEspecialidad(especialidad: Especialidad) = medicosRepository.getMedicosByEspecialidad(especialidad)
    fun deleteAll() = medicosRepository.deleteAll()

    private fun comprobarRestriccionesDominio(medico: Medico) {
        logger.debug { "Controlador comprobarRestriccionesDominio" }
        require(medico.nombre.isNotBlank()) { throw MedicoBadRequest("El nombre no puede estar vacío") }

        when (medico) {
            is AnestesistaCirujano -> {
                require(medico.quirofano > 0) { throw MedicoBadRequest("El quírofoano debe ser mayor a 0") }
            }

            is Cirujano -> {
                require(medico.habilidad.isNotBlank()) { throw MedicoBadRequest("La especialidad no puede estar vacía") }
            }

            is Anestesista -> {
                require(medico.añosExperiencia >= 0) { throw MedicoBadRequest("La experiencia debe ser mayor a 0") }
            }
        }
    }
}