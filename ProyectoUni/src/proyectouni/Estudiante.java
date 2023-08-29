/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectouni;

/**
 *
 * @author Josue
 */

class Estudiante {
    private String nombre;
    private String apellido;
    private int semestre;
    private String cedula;
    private String correoElectronico;
    private String celular;

    public Estudiante(String nombre, String apellido, int semestre, String cedula, String correoElectronico, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}