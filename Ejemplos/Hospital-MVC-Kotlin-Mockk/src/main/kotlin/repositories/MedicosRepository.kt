package repositories

import models.Especialidad
import models.Medico
import java.util.*

interface MedicosRepository {
    fun getAll(): Array<Medico>
    fun getById(id: UUID): Medico?
    fun create(medico: Medico): Medico
    fun update(id: UUID, medico: Medico): Medico?
    fun delete(id: UUID): Medico?
    fun getMedicosByEspecialidad(especialidad: Especialidad): Array<Medico>
    fun deleteAll()
    fun saveAll(medicos: Array<Medico>)
}