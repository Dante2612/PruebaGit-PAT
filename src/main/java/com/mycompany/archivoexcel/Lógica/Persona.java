
package com.mycompany.archivoexcel.Lógica;

public class Persona {
    
    private String nombre, apellido, dirección, correo;
    private int numero, dni;
   

    public Persona() {
    }

    public Persona(int numero, String nombre, String apellido, int dni, String dirección, String correo) {
        this.numero = numero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.dirección = dirección;
        this.correo = correo;
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

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    

}