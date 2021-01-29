/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author NotebookSFC
 */
public class DTOVisitas 
{
//Nombre del paciente, nombre del visitante, nombre del recepcionista, duración
    private int idVisita;
    private String Paciente;
    private String Visitante;
    private String Recepcionista;
    private int duracion;
    
    public DTOVisitas () {};

    public DTOVisitas(int idVisita, String Paciente, String Visitante, String Recepcionista, int duracion) {
        this.idVisita = idVisita;
        this.Paciente = Paciente;
        this.Visitante = Visitante;
        this.Recepcionista = Recepcionista;
        this.duracion = duracion;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public String getPaciente() {
        return Paciente;
    }

    public void setPaciente(String Paciente) {
        this.Paciente = Paciente;
    }

    public String getVisitante() {
        return Visitante;
    }

    public void setVisitante(String Visitante) {
        this.Visitante = Visitante;
    }

    public String getRecepcionista() {
        return Recepcionista;
    }

    public void setRecepcionista(String Recepcionista) {
        this.Recepcionista = Recepcionista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    
    
    
    
}
