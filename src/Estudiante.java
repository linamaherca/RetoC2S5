
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author linam
 */
public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String celular;
    private int edad;
    ArrayList <Curso> idCurso;

    public Estudiante(int id, String nombre, String celular, int edad) {
        this.idEstudiante = id;
        this.nombre = nombre;
        this.celular = celular;
        this.edad = edad;
    }

    public Estudiante(String nombre, String celular, int edad) {
        this.nombre = nombre;
        this.celular = celular;
        this.edad = edad;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Curso> getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(ArrayList<Curso> idCurso) {
        this.idCurso = idCurso;
    }
    
    
}

