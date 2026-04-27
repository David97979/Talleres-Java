package com.puj.taller2.model;

public class Estudiante {
    private String nombre;
    private String codigo;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void  setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    public Estudiante(String nombre, String codigo, int edad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.edad = edad;
    }

    public String toString(){
        return nombre + " (" + "Codigo: " + codigo +  ", Edad: " + edad + ")";
    }

}
