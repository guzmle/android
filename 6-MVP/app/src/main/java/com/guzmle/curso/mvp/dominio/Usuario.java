package com.guzmle.curso.mvp.dominio;

import java.util.Calendar;

/**
 * Clase que representa los datos de un usuario
 */
public class Usuario {

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private char sexo;
    private Calendar fechaNacimiento;
    private String numeroDocumento;

    @Override
    public String toString() {
        return nombre + " " + apellido;
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


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public char getSexo() {
        return sexo;
    }


    public void setSexo(char sexo) {
        this.sexo = sexo;
    }


    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getNumeroDocumento() {
        return numeroDocumento;
    }


    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
