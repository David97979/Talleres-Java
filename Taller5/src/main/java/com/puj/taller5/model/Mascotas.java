package com.puj.taller5.model;
import com.puj.taller5.excepciones.DatoInvalidoException;

import java.io.*;

public class Mascotas implements Serializable{
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

    public void setCodigo(int codigo) throws DatoInvalidoException {
        if(codigo <=  0){
            throw new DatoInvalidoException("Codigo Invalido");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatoInvalidoException {
        if(nombre == null || nombre.isEmpty()){
            throw new DatoInvalidoException("Nombre Invalido");

        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws DatoInvalidoException {
        if (edad < 0) {
            throw new DatoInvalidoException("Edad inválida");
        }
        this.edad = edad;
    }

    public int getCedulaDueno() {
        return cedulaDueno;
    }

    public void setCedulaDueno(int cedulaDueno) throws DatoInvalidoException{
        if (cedulaDueno<= 0) {
            throw new DatoInvalidoException("Cédula inválida");
        }
        this.cedulaDueno = cedulaDueno;
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
