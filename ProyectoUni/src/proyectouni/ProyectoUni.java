/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectouni;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Josue
 */

public class ProyectoUni {

    public static void main(String[] args) {
        GestionEstudiantes gestion = new GestionEstudiantes();
        cargarEstudiantesDesdeArchivo(gestion); // Cargamos estudiantes al inicio

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int opcion = mostrarMenu(scanner);

            switch (opcion) {
                
                case 1:
                    
                    // Código para agregar estudiante
                    System.out.println("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.next();

                    System.out.println("Ingrese el apellido del estudiante: ");
                    String apellido = scanner.next();

                    System.out.println("Ingrese el semestre del estudiante: ");
                    int semestre = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese la cedula del estudiante: ");
                    String cedula = scanner.nextLine();

                    System.out.println("Ingrese el correo del estudiante: ");
                    String correo = scanner.nextLine();

                    System.out.println("Ingrese el numero de celular del estudiante: ");
                    String celular = scanner.nextLine();

                    Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, semestre, cedula, correo, celular);
                    gestion.agregarEstudiante(nuevoEstudiante);

                    System.out.println("Estudiante agregado correctamente");
                    break;
                    
                case 2:
                    
                    // Código para consultar estudiante
                    System.out.println("Ingrese la cedula del estudiante a consultar: ");
                    cedula = scanner.next();

                    Estudiante estudianteConsulta = gestion.consultarEstudiante(cedula);

                    if (estudianteConsulta != null) {
                        System.out.println("Informacion del estudiante:");

                        System.out.println("Nombre: " + estudianteConsulta.getNombre());

                        System.out.println("Apellido: " + estudianteConsulta.getApellido());

                        System.out.println("Semestre: " + estudianteConsulta.getSemestre());

                        System.out.println("Cedula: " + estudianteConsulta.getCedula());

                        System.out.println("Correo Electro1nico: " + estudianteConsulta.getCorreoElectronico());

                        System.out.println("Celular: " + estudianteConsulta.getCelular());

                    } else {
                        System.out.println("Estudiante no encontrado");
                    }
                    break;
                    
                case 3:
                    
                    // Modificar estudiante
                    System.out.println("Ingrese la cedula del estudiante a modificar: ");
                    cedula = scanner.nextLine();

                    Estudiante estudianteModificar = gestion.consultarEstudiante(cedula);

                    if (estudianteModificar != null) {
                        System.out.println("Ingrese el nuevo nombre del estudiante: ");
                        String nuevoNombre = scanner.nextLine();

                        System.out.println("Ingrese el nuevo apellido del estudiante: ");
                        String nuevoApellido = scanner.nextLine();

                        System.out.println("Ingrese el nuevo semestre del estudiante: ");
                        int nuevoSemestre = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingrese el nuevo correo del estudiante: ");
                        String nuevoCorreo = scanner.nextLine();

                        System.out.println("Ingrese el nuevo numero de celular del estudiante: ");
                        String nuevoCelular = scanner.nextLine();

                        Estudiante nuevoEstudianteModificado = new Estudiante(nuevoNombre, nuevoApellido, nuevoSemestre, cedula, nuevoCorreo, nuevoCelular);
                        gestion.modificarEstudiante(cedula, nuevoEstudianteModificado);

                        System.out.println("Estudiante modificado correctamente");
                    } else {
                        System.out.println("Estudiante no encontrado");
                    }
                    break;
                    
                case 4:
                    
                    // Eliminar estudiante
                    System.out.println("Ingrese la cedula del estudiante a eliminar: ");
                    cedula = scanner.nextLine();
                    gestion.eliminarEstudiante(cedula);

                    System.out.println("Estudiante eliminado correctamente");

                    break;

                case 5:

                    // Registro por semestre
                    System.out.println("Ingrese el semestre para el registro: ");
                    int semestreRegistro = scanner.nextInt();
                    scanner.nextLine();

                    List<Estudiante> estudiantesPorSemestre = gestion.consultarEstudiantesPorSemestre(semestreRegistro);

                    if (!estudiantesPorSemestre.isEmpty()) {
                        System.out.println("Registro de estudiantes en el semestre " + semestreRegistro + ":");

                        for (Estudiante estudiante : estudiantesPorSemestre) {
                            System.out.println("Cedula: " + estudiante.getCedula());

                            System.out.println("Nombre: " + estudiante.getNombre());

                            System.out.println("Apellido: " + estudiante.getApellido());

                            System.out.println("Correo Electronico: " + estudiante.getCorreoElectronico());

                            System.out.println("Celular: " + estudiante.getCelular());

                            System.out.println();
                        }
                    } else {
                        System.out.println("No hay estudiantes registrados en el semestre " + semestreRegistro);
                    }

                    break;

                case 6:
                    
                    // Registro de todos los estudiantes
                    List<Estudiante> todosLosEstudiantes = gestion.consultarTodosLosEstudiantes();

                    if (!todosLosEstudiantes.isEmpty()) {
                        System.out.println("Registro de todos los estudiantes:");

                        for (Estudiante estudiante : todosLosEstudiantes) {
                            System.out.println("Cedula: " + estudiante.getCedula());
                            
                            System.out.println("Nombre: " + estudiante.getNombre());
                            
                            System.out.println("Apellido: " + estudiante.getApellido());
                            
                            System.out.println("Correo Electronico: " + estudiante.getCorreoElectronico());
                            
                            System.out.println("Celular: " + estudiante.getCelular());
                            System.out.println();
                        }
                    } else {
                        System.out.println("No hay estudiantes registrados.");
                    }

                    break;

                case 7:
                    
                    System.out.println("Saliendo del programa.");
                    guardarEstudiantesEnArchivo(gestion); // Guardar estudiantes en el archivo al salir
                    System.exit(0);
                    break;
            }
        }
    }

    private static int mostrarMenu(Scanner scanner) {
        System.out.println("Menu:");

        System.out.println("1. Agregar estudiante");

        System.out.println("2. Consultar estudiante");

        System.out.println("3. Modificar estudiante");

        System.out.println("4. Eliminar estudiante");

        System.out.println("5. Registro por semestre");

        System.out.println("6. Registro de todos los estudiantes");

        System.out.println("7. Salir");

        System.out.print("Elija una opcion: ");

        return scanner.nextInt();
    }

    private static void cargarEstudiantesDesdeArchivo(GestionEstudiantes gestion) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/estudiantes.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String nombre = parts[0];
                    String apellido = parts[1];
                    int semestre = Integer.parseInt(parts[2]);
                    String cedula = parts[3];
                    String correo = parts[4];
                    String celular = parts[5];
                    Estudiante estudiante = new Estudiante(nombre, apellido, semestre, cedula, correo, celular);
                    gestion.agregarEstudiante(estudiante);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los estudiantes desde el archivo.");
        }
    }

    private static void guardarEstudiantesEnArchivo(GestionEstudiantes gestion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/estudiantes.txt"))) {
            List<Estudiante> estudiantes = gestion.consultarTodosLosEstudiantes();
            for (Estudiante estudiante : estudiantes) {
                String linea = estudiante.getNombre() + "," + estudiante.getApellido() + "," + estudiante.getSemestre() + ","
                        + estudiante.getCedula() + "," + estudiante.getCorreoElectronico() + "," + estudiante.getCelular();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los estudiantes en el archivo.");
        }
    }
}
