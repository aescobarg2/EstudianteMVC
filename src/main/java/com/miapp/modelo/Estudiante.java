package com.miapp.modelo;

/**
 * Modelo: representa la entidad Estudiante.
 */
public class Estudiante {

    private int    id;
    private String nombre;
    private String apellido;
    private String carrera;
    private double promedio;

    public Estudiante(int id, String nombre,String apellido, String carrera, double promedio) {
        this.id       = id;
        this.nombre   = nombre;
        this.apellido = apellido;
        this.carrera  = carrera;
        this.promedio = promedio;

    }

    // ── Getters ──────────────────────────────────────────────────────────────

    public int    getId()       { return id; }
    public String getNombre()   { return nombre; }
    public String getApellido() {return apellido;}
    public String getCarrera()  { return carrera; }
    public double getPromedio() { return promedio; }

    // ── Setters ──────────────────────────────────────────────────────────────

    public void setId(int id)             { this.id = id; }
    public void setNombre(String nombre)  { this.nombre = nombre; }
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setCarrera(String carrera){ this.carrera = carrera; }
    public void setPromedio(double p)     { this.promedio = p; }

    @Override
    public String toString() {
        return "ID: " + id
             + " | Nombre: " + nombre
             + " | Carrera: " + carrera
             + " | Promedio: " + promedio;
    }
}
