
package com.emergentes.model;

import java.util.Date;


public class Estudiante {
    
    private int id;
    private String nombres;
    private String apellidos;
    private String seminario;
    private int confirmado;
    private String fecha;

    public Estudiante() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.seminario = "";
        this.confirmado = 0;
        this.fecha = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
    
    
    
}
