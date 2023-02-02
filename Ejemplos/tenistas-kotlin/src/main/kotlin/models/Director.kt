package models

import java.time.LocalDate

// Patrón Builder
// https://refactoring.guru/es/design-patterns/builder
// https://www.baeldung.com/kotlin/builder-pattern

class Director private constructor(
    var nombre: String? = null,
    var pais: String? = null,
    var fechaNacimiento: LocalDate = LocalDate.now(),
) {

    // Builder
    class Builder {
        var nombre: String? = null
        var pais: String? = "España"
        var fechaNacimiento: LocalDate = LocalDate.now()

        fun nombre(nombre: String) = apply { this.nombre = nombre }
        fun pais(pais: String) = apply { this.pais = pais }
        fun fechaNacimiento(fechaNacimiento: LocalDate) = apply { this.fechaNacimiento = fechaNacimiento }

        fun build() = Director(nombre, pais, fechaNacimiento)
    }

    override fun toString(): String {
        return "Director(nombre=$nombre, pais=$pais, fechaNacimiento=$fechaNacimiento)"
    }
}