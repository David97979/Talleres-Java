package com.puj.taller5.model;
import java.io.*;

public class Mascotas {
    private int codigo;
    private String nombre;
    private int edad;
    private int cedulaDueno;

    public Mascotas(int codigo, String nombre, int edad, int cedulaDueno) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.cedulaDueno = cedulaDueno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad inválida");
        }
        this.edad = edad;
    }

    public int getCedulaDueno() {
        return cedulaDueno;
    }

    public void setCedulaDueno(int cedulaDueno) {
        if (cedulaDueno == null || cedulaDueno.isEmpty()) {
            throw new IllegalArgumentException("Cédula inválida");
        }
    }
    public String mostrarTipo(){
        return "Soy Mascota";
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Nombre: " + nombre +
                ", Edad: " + edad +
                ", Dueño: " + cedulaDueno;
    }
}
