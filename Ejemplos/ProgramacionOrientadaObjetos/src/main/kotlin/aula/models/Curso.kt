package aula.models

data class Curso(val nombre: String, val año: String, val tutor: Tutor) {
    private val alumnado = Array<Alumno?>(30) { null }

    val id = nextId()

    companion object {
        private var contador = 0
        private fun nextId() = ++contador
        fun reset() {
            contador = 0
        }

    }

    override fun toString(): String {
        return "Curso(id='$id', nombre='$nombre', año='$año', tutor= '$tutor' alumnado=${alumnado.contentToString()})"
    }

    fun clear() {
        alumnado.fill(null)
        Alumno.reset()
    }

    fun totalAlumnos(): Int {
        var total = 0
        for (alumno in alumnado) {
            if (alumno != null) {
                total++
            }
        }
        return total
    }

    /**
     * Crea un alumno si hay espacio en el aula
     * @param alumno: Alumno a crear
     * @return Alumno creado o null si no se ha podido insertar
     */
    fun createAlumno(alumno: Alumno): Alumno? {
        // Buscamos una posición sin null
        var index = -1
        for (i in alumnado.indices) {
            if (alumnado[i] == null) {
                index = i
                break
            }
        }
        // Early return error
        return if (index == -1) {
            null
        } else {
            alumnado[index] = alumno
            alumno
        }
    }

    /**
     * Obtiene un alumno en base a su id
     * @param id del alumno
     * @return alumno encontrado o null si no existe
     */
    fun getAlumnoById(id: Int): Alumno? {
        // recorremos buscando el alumno
        /*for (alumno in aula) {
            if (alumno != null && alumno.id == id) {
                return alumno
            }
        }*/
        val index = getIndexById(id)
        return if (index != -1)
            alumnado[index]
        else
            return null
    }

    /**
     * Actualiza un alumno en base a su id
     * @param id del del alumno
     * @return alumno actualizado o null si no existe
     */
    fun updateAlumno(alumno: Alumno): Alumno? {
        val index = getIndexById(alumno.id)
        return if (index != -1) {
            alumnado[index] = alumno
            alumno
        } else
            null
    }

    /**
     * Elimina un alumno en base a su id
     * @param id del alumno
     * @return alumno eliminado o null si no existe
     */
    fun deleteAlumnoById(id: Int): Alumno? {
        val index = getIndexById(id)
        // Early return error
        return if (index != -1) {
            val alumno = alumnado[index]
            alumnado[index] = null
            alumno
        } else
            null
    }

    /**
     * Elimina un alumno en base a su id
     * @param id del alumno
     * @return alumno eliminado o null si no existe
     */
    fun deleteAlumno(alumno: Alumno): Alumno? {
        val index = getIndexById(alumno.id)
        // Early return error
        return if (index != -1) {
            alumnado[index] = null
            alumno
        } else
            null
    }


    /**
     * Obtiene el índdice del objeto con id
     * @param id id a buscar
     * @return indice si existe, -1 si no existe
     */
    private fun getIndexById(id: Int): Int {
        for (i in alumnado.indices) {
            if (alumnado[i]?.id == id)
                return i
        }
        return -1
    }


    /**
     * Devuelve todos los alumnos ordenados por nota de mayor a menor
     */
    fun getAllAlumnosOrderByNotasDesc() {
        // Ordenar por nota usando burbuja desc
        for (i in 0 until alumnado.size - 1) {
            for (j in 0 until alumnado.size - 1 - i) {
                /*if (aula[j]!=null && aula[j + 1]!=null && aula[j]!!.califcacion < aula[j + 1]!!.califcacion) {
                    val aux = aula[j]
                    aula[j] = aula[j + 1]
                    aula[j + 1] = aux
                }*/
                if ((alumnado[j]?.califcacion ?: -1.0) < (alumnado[j + 1]?.califcacion ?: -1.0)) {
                    val aux = alumnado[j]
                    alumnado[j] = alumnado[j + 1]
                    alumnado[j + 1] = aux
                }
            }
        }

        // Imprimir --> se puede mover fuera
        imprimirListado()
    }

    private fun imprimirListado() {
        for (alumno in alumnado) {
            if (alumno != null) {
                println(alumno)
            }
        }
    }

    fun getInforme(): String {
        val numAlumnos = getNumAlumnos()
        val numAprobados = getNumAprobados()
        val numSuspensos = numAlumnos - numAprobados
        val porcentageAprobados = numAprobados * 100.0 / numAlumnos
        val porcentageSuspensos = numSuspensos * 100.0 / numAlumnos
        val notaMedia = getNotaMedia()
        return """
        Curso: $nombre
        Año: $año
        Tutor/a: $tutor
        Número de alumnos: $numAlumnos
        Número de aprobados: $numAprobados
        Número de suspensos: $numSuspensos
        Porcentaje de aprobados: $porcentageAprobados%
        Porcentaje de suspensos: $porcentageSuspensos%
        Nota media: $notaMedia
    """.trimIndent()
    }

    fun getNotaMedia(): Double {
        var suma = 0.0
        var numAlumnos = 0
        for (alumno in alumnado) {
            if (alumno != null) {
                suma += alumno.califcacion
                numAlumnos++
            }
        }
        return (suma / numAlumnos * 100).toInt() / 100.0
    }

    fun getNumAprobados(): Int {
        var num = 0
        for (i in alumnado.indices) {
            if (alumnado[i]?.isAprobado == true) {
                num++
            }
        }
        return num
    }

    private fun getNumAlumnos(): Int {
        var num = 0
        for (i in alumnado.indices) {
            if (alumnado[i] != null) {
                num++
            }
        }
        return num
    }

}