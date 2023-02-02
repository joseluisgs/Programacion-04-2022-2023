package Exceptions

sealed class MedicoException(message: String) : RuntimeException(message)
class MedicoNotFoundException(id: String) : MedicoException("No se ha encontrado el medico con id: $id")
class MedicoBadRequest(motivo: String) : MedicoException("No se ha podido crear el medico: $motivo")


