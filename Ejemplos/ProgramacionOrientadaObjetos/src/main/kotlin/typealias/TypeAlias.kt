package inline

typealias IdAlumno2 = Int
typealias IdModulo2 = Int
typealias IdCentro2 = Int

typealias ArrayAlumno = Array<Alumno2>
// typealias MatrizAlumno = Array<Array<Alumno2>>
typealias MatrizAlumno = Array<ArrayAlumno>

class Alumno2(
    val id: IdAlumno2,
    val idModlulo: IdModulo2,
    val idCentro: IdCentro2,
    val nombre: String
)


fun main() {
    //val alumno = Alumno(1, 2, 3, "Nombre")
    val alumno = Alumno2(1, 2, 3, "Nombre")

    val array: ArrayAlumno = arrayOf(
        Alumno2(1, 2, 3, "Nombre"),
        Alumno2(1, 2, 3, "Nombre"),
        Alumno2(1, 2, 3, "Nombre")
    )

    for (alumno in array) {
        println(alumno)
    }

    val matriz = MatrizAlumno(3) {
        ArrayAlumno(3) { Alumno2(1, 2, 3, "Nombre") }
    }

    for (fila in matriz) {
        for (alumno in fila) {
            println(alumno)
        }
    }
}