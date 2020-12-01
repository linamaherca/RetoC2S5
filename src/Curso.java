
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
public class Curso {
    private int id;
    private String nombre;
    private int capacidad;
    private Profesor idProfesor;
    ArrayList <Estudiante> estudiantes;

    public Curso(int id, String nombre, int capacidad, Profesor idProfesor) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.idProfesor = idProfesor;
    }

    public Curso(String nombre, int capacidad, Profesor idProfesor) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.idProfesor = idProfesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
}
