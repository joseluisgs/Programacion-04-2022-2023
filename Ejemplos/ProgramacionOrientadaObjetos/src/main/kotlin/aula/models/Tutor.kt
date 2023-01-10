package aula.models

import aula.enums.TipoTutor

data class Tutor(val nombre: String, var tipo: TipoTutor = TipoTutor.TEORIA) {
    val id = nextId()

    override fun toString(): String {
        return "Tutor(id=$id, nombre='$nombre', tipo=$tipo)"
    }


    companion object {
        private var contador = 0
        private fun nextId() = ++contador
        fun reset() {
            contador = 0
        }
    }


    /*  enum class TipoTutor {
          TEORIA, PRACTICAS, EMPRESA
      }*/
}