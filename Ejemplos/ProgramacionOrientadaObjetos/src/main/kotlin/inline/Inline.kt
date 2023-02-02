package inline

inline class idCurso(val id: Int)

/*class Alumno(
    val id: Int,
    val idModlulo: Int,
    val idCentro: Int,
    val nombre: String
)*/

/*inline class IdAlumno(val id: Int)
inline class IdModulo(val id: Int)
inline class IdCentro(val id: Int)*/

@JvmInline
value class IdAlumno(val id: Int)
@JvmInline
value class IdModulo(val id: Int)
@JvmInline
value class IdCentro(val id: Int)

class Alumno(
    val id: IdAlumno,
    val idModlulo: IdModulo,
    val idCentro: IdCentro,
    val nombre: String
)

fun main() {
    //val alumno = Alumno(1, 2, 3, "Nombre")
    val alumno = Alumno(IdAlumno(1), IdModulo(2), IdCentro(3), "Nombre")
}