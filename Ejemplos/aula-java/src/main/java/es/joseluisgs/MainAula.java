package es.joseluisgs;

import es.joseluisgs.models.Alumno;
import es.joseluisgs.models.Curso;
import es.joseluisgs.models.Tutor;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MainAula {
    private static final Scanner sc = new Scanner(System.in);
    private static Curso curso;

    public static void main(String[] args) {
        menuGestion();
    }

    private static void menuGestion() {
        var menu = """
                    1. Crear Curso
                    2. Listar alumnos
                    3. Crear alumno
                    4. Buscar alumno
                    5. Actualizar alumno
                    6. Eliminar alumno
                    7. Informe de resultados
                    8. Simulacion
                    0. Salir
                """.trim();

        do {
            System.out.println(menu);
            var menuChoice = leerEntero();
            switch (menuChoice) {
                case 1 -> crearCurso();
                case 2 -> listarAlumnos();
                case 3 -> crearAlumno();
                case 4 -> buscarAlumno();
                case 5 -> actualizarAlumno();
                case 6 -> eliminarAlumno();
                case 7 -> informeResultados();
                case 8 -> simulacion();
                case 0 -> salir();
                default -> System.out.println("Opción no válida");
            }
        } while (true);
    }

    private static void informeResultados() {
        System.out.println("Informe de resultados");
        if (curso.getNombre().isEmpty()) {
            System.out.println("ERROR: No hay curso creado");
        } else {
            System.out.println(curso.getInforme());
        }

    }

    private static void eliminarAlumno() {
        System.out.println("Eliminar alumno");
        var id = -1;
        do {
            System.out.println("Introduce el id del alumno");
            var stringId = sc.nextLine().trim();
            Pattern pattern = Pattern.compile("[0-9]+");
            if (pattern.matcher(stringId).matches()) {
                id = Integer.parseInt(stringId);
            }
        } while (id == -1);
        System.out.println("Elimanndo alumno");
        var alumnoElimnado = curso.deleteAlumnoById(id);
        if (alumnoElimnado != null) {
            System.out.println("Alumno " + alumnoElimnado);
        } else {
            System.out.println("No se ha podido encontrar el alumno con id: " + id);
        }
    }

    private static void actualizarAlumno() {
        System.out.println("Actualizar alumno");
        var id = -1;
        do {
            System.out.println("Introduce el id del alumno");
            var stringId = sc.nextLine().trim();
            Pattern pattern = Pattern.compile("[0-9]+");
            if (pattern.matcher(stringId).matches()) {
                id = Integer.parseInt(stringId);
            }
        } while (id == -1);
        var alumno = curso.getAlumnoById(id);
        if (alumno != null) {
            var nombre = "";
            do {
                System.out.println("Nombre:");
                nombre = sc.nextLine().trim();
            } while (nombre.isEmpty());
            var nota = -1.0;
            do {
                System.out.println("Nota [0-10]:");
                var stringNota = sc.nextLine().trim();
                Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
                if (pattern.matcher(stringNota).matches()) {
                    nota = Double.parseDouble(stringNota);
                }
            } while (nota < 0 || nota > 10);
            var alumnoActualizado = curso.updateAlumno(alumno);
            System.out.println("Alumno actualizado: " + alumnoActualizado);
        } else {
            System.out.println("No existe el alumno");
        }
    }

    private static void crearAlumno() {
        System.out.println("Crear alumno");
        var nombre = "";
        do {
            System.out.println("Nombre:");
            nombre = sc.nextLine().trim();
        } while (nombre.isEmpty());
        var nota = -1.0;
        do {
            System.out.println("Nota [0-10]:");
            var stringNota = sc.nextLine().trim();
            Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
            if (pattern.matcher(stringNota).matches()) {
                nota = Double.parseDouble(stringNota);
            }
        } while (nota < 0 || nota > 10);
        var alumno = new Alumno(nombre, nota);
        var alumnoCreado = curso.createAlumno(alumno);
        if (alumnoCreado != null) {
            System.out.println("Alumno: " + alumnoCreado);
        } else {
            System.out.println("No se ha podido crear el alumno");
        }
    }

    private static void buscarAlumno() {
        System.out.println("Buscar alumno");
        var id = -1;
        do {
            System.out.println("Introduce el id del alumno");
            var stringId = sc.nextLine().trim();
            Pattern pattern = Pattern.compile("[0-9]+");
            if (pattern.matcher(stringId).matches()) {
                id = Integer.parseInt(stringId);
            }
        } while (id == -1);
        System.out.println("Buscando alumno");
        var alumnoBuscado = curso.getAlumnoById(id);
        if (alumnoBuscado != null) {
            System.out.println("Alumno " + alumnoBuscado);
        } else {
            System.out.println("No se ha podido encontrar el alumno con id: " + id);
        }
    }

    private static void listarAlumnos() {
        System.out.println("Listar alumnos ordenados por nota descendente");
        if (curso.getId() == 0) {
            System.out.println("ERROR: No hay curso creado");
        } else if (curso.totalAlumnos() == 0) {
            System.out.println("ERROR: No hay alumnos en el curso");
        } else {
            curso.getAllAlumnosOrderByNotasDesc();
        }
    }

    private static void crearCurso() {
        System.out.println("Crear curso");

        var id = "";
        do {
            System.out.println("Id:");
            id = sc.nextLine().trim();
        } while (id.isEmpty());

        var nombre = "";
        do {
            System.out.println("Introduce el nombre del curso:");
            nombre = sc.nextLine().trim();
        } while (nombre.isEmpty());

        var año = "";
        Pattern añoRegex;
        do {
            System.out.println("Introduce el año del curso:");
            añoRegex = Pattern.compile("[0-9]{4}/[0-9]{4}");
            año = sc.nextLine().trim();
        } while (!añoRegex.matcher(año).matches());

        var tutor = "";
        do {
            System.out.println("Introduce el nombre del tutor:");
            tutor = sc.nextLine().trim();
        } while (tutor.isEmpty());

        curso = new Curso(nombre, año, new Tutor(tutor));

        System.out.println("Curso creado: " + curso);
    }

    private static void salir() {
        System.out.println("Hasta pronto");
        System.exit(0);
    }

    private static int leerEntero() {
        var input = sc.nextLine();
        // regex para numeros enteros
        var regex = "\\d";
        if (input.matches(regex)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("No es un número entero");
            return -1;
        }
    }

    private static void simulacion() {
        Alumno.respirar();
        var a1 = Alumno.random();

        Alumno[] alumnado = {
                new Alumno("Juan", 8.7238273),
                new Alumno("Ana", 4.4),
                new Alumno("Luis", 6.2567),
                new Alumno("María", 9.75),
                new Alumno("Pedro", 2.25)
        };
        
        curso = new Curso("1º DAM", "2020/2021", new Tutor("Juan"));

        // Me creo 5 alumnos
        curso.createAlumno(alumnado[0]);
        curso.createAlumno(alumnado[1]);
        curso.createAlumno(alumnado[2]);
        curso.createAlumno(alumnado[3]);
        curso.createAlumno(alumnado[4]);

        System.out.println("Curso: $curso");

        System.out.println("Listar alumnos ordenados por nota descendente...");
        curso.getAllAlumnosOrderByNotasDesc();

        System.out.println("Obtener alumno por id");
        var alumno = curso.getAlumnoById(3);
        if (alumno != null) {
            System.out.println("Alumno con id 3: " + alumno);
        }
        alumno = curso.getAlumnoById(99);
        if (alumno != null) {
            System.out.println("Alumno con id 99: " + alumno);
        }

        System.out.println("Crear alumno...");

        alumno = curso.createAlumno(new Alumno("Create", 7.72));
        if (alumno != null) {
            System.out.println("Alumno creado: " + alumno);
        } else {
            System.out.println("Aula completa, no se ha podido insertar");
        }

        System.out.println("Actualizar alumno...");
        alumno = curso.getAlumnoById(3);

        if (alumno != null) {
            alumno.setNombre("Update");
            alumno.setNota(7.72);
            alumno = curso.updateAlumno(alumno);
        } else {
            System.out.println("No se ha podido actualizar");
        }


        System.out.println("Eliminar alumno...");
        alumno = curso.deleteAlumnoById(1);
        if (alumno != null) {
            System.out.println("Alumno eliminado: " + alumno);
        } else {
            System.out.println("No se ha podido eliminar el alumno/a");
        }

        System.out.println("Listar alumnos ordenados por nota descendente...");
        curso.getAllAlumnosOrderByNotasDesc();

        System.out.println("Informe de resultados...");
        System.out.println(curso.getInforme());
    }

    // Fin de clase
}