package es.joseluisgs.models;

import java.util.Arrays;

public class Curso {
    private static int contador = 0;
    private final int id = nextId();
    private final String nombre;
    private final String año;
    private final Tutor tutor;
    private final Alumno[] alumnos = new Alumno[30]; // es un array de 30 posicionesAlumno  null de momento

    public Curso(String nombre, String año, Tutor tutor) {
        this.nombre = nombre;
        this.año = año;
        this.tutor = tutor;
    }

    private static int nextId() {
        return ++contador;
    }

    private static void resetId() {
        contador = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAño() {
        return año;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

//    public void setAlumnos(Alumno[] alumnos) {
//        this.alumnos = alumnos;
//    }


    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", año='" + año + '\'' +
                ", tutor=" + tutor +
                ", alumnos=" + Arrays.toString(alumnos) +
                '}';
    }

    public void clear() {
        Arrays.fill(alumnos, null);
//        for (int i = 0; i < alumnos.length; i++) {
//            alumnos[i] = null;
//        }
        Alumno.resetId();
    }

    public int totalAlumnos() {
        int total = 0;
        for (Alumno alumno : alumnos) {
            if (alumno != null) {
                total++;
            }
        }
        return total;
    }

    private int getIndexById(int id) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Alumno createAlumno(Alumno alumno) {
        var indice = -1;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            return null;
        } else {
            alumnos[indice] = alumno;
            return alumno;
        }
    }

    public Alumno getAlumnoById(int id) {
        var indice = getIndexById(id);
        if (indice == -1) {
            return null;
        } else {
            return alumnos[indice];
        }
    }

    public Alumno updateAlumno(Alumno alumno) {
        var indice = getIndexById(alumno.getId());
        if (indice == -1) {
            return null;
        } else {
            alumnos[indice] = alumno;
            return alumno;
        }
    }

    public Alumno deleteAlumnoById(int id) {
        var indice = getIndexById(id);
        if (indice == -1) {
            return null;
        } else {
            var alumno = alumnos[indice];
            alumnos[indice] = null;
            return alumno;
        }
    }

    public Alumno deleteAlumno(Alumno alumno) {
        return deleteAlumnoById(alumno.getId());
    }

    public void imprimirListado() {
        for (Alumno alumno : alumnos) {
            if (alumno != null) {
                System.out.println(alumno);
            }
        }
    }

    public void getAllAlumnosOrderByNotasDesc() {
        // Método de ordenaciñon burbuja descedente por notas
        for (int i = 0; i < alumnos.length - 1; i++) {
            for (int j = 0; j < alumnos.length - 1 - i; j++) {
                // Cuidado con los nulos!!!!
                if (alumnos[j] != null && alumnos[j + 1] != null) {
                    if (alumnos[j].getCalificacion() < alumnos[j + 1].getCalificacion()) {
                        Alumno aux = alumnos[j];
                        alumnos[j] = alumnos[j + 1];
                        alumnos[j + 1] = aux;
                    }
                }
            }
        }

        imprimirListado();
    }

    private int getNumAlumnos() {
        int total = 0;
        for (Alumno alumno : alumnos) {
            if (alumno != null) {
                total++;
            }
        }
        return total;
    }

    private int getNumAprobados() {
        int total = 0;
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.isAprobado()) {
                total++;
            }
        }
        return total;
    }

    public double getNotaMedia() {
        int total = 0;
        for (Alumno alumno : alumnos) {
            if (alumno != null) {
                total += alumno.getCalificacion();
            }
        }
        return (((total / getNumAlumnos()) * 100) / 100.0);
    }

    public String getInforme() {
        var numAlumnos = getNumAlumnos();
        var numAprobados = getNumAprobados();
        var numSuspensos = numAlumnos - numAprobados;
        var porcentageAprobados = (int) ((numAprobados * 100.0 / numAlumnos) * 100) / 100.0;
        var porcentageSuspensos = numSuspensos * 100.0 / numAlumnos;
        var notaMedia = getNotaMedia();

        String sb = "Curso: " + nombre +
                " Año: " + año + "\n" +
                " Tutor/a: " + tutor + "\n" +
                " Número de alumnos: " + numAlumnos + "\n" +
                " Número de aprobados: " + numAprobados + "\n" +
                " Número de suspensos: " + numSuspensos + "\n" +
                " Porcentaje de aprobados: " + porcentageAprobados + "\n" +
                " Porcentaje de suspensos: " + String.format("%.2f", porcentageSuspensos) + "\n" +
                " Nota media: " + notaMedia + "\n";
        return sb;

    }
}
