/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectouni;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue
 */

class GestionEstudiantes {
    private List<Estudiante> listaEstudiantes = new ArrayList<>();

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public Estudiante consultarEstudiante(String cedula) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    public List<Estudiante> consultarEstudiantesPorSemestre(int semestre) {
        List<Estudiante> estudiantesPorSemestre = new ArrayList<>();

        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getSemestre() == semestre) {
                estudiantesPorSemestre.add(estudiante);
            }
        }

        return estudiantesPorSemestre;
    }

    public List<Estudiante> consultarTodosLosEstudiantes() {
        return listaEstudiantes;
    }

    public void modificarEstudiante(String cedula, Estudiante nuevoEstudiante) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante estudianteActual = listaEstudiantes.get(i);
            if (estudianteActual.getCedula().equals(cedula)) {
                listaEstudiantes.set(i, nuevoEstudiante);
                return;
            }
        }
    }

    public void eliminarEstudiante(String cedula) {
        listaEstudiantes.removeIf(estudiante -> estudiante.getCedula().equals(cedula));
    }
}