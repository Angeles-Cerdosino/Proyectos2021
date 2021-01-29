/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author NotebookSFC
 */
public class Visitas 
{
 private int idVisita;
    private Empleados empleado;
    private Pacientes paciente;
    private String nombre;
    private int duracion;
    
    public Visitas (){};

    public Visitas(int idVisita, Empleados empleado, Pacientes paciente, String nombre, int duracion) {
        this.idVisita = idVisita;
        this.empleado = empleado;
        this.paciente = paciente;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    
    
}
