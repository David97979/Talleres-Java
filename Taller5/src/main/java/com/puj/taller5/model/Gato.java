package com.puj.taller5.model;

import com.puj.taller5.excepciones.DatoInvalidoException;

public class Gato extends Mascotas {
    private String color;
    private boolean cazador;

    public Gato(int codigo, String nombre, int edad, int cedulaDueno, String color, boolean cazador) {
        super(codigo, nombre, edad, cedulaDueno);
        this.color = color;
        this.cazador = cazador;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws DatoInvalidoException {
        if (color == null || color.isEmpty()) {
            throw new DatoInvalidoException("Color inválido o vacio");
        }
        this.color = color;
    }

    public boolean isCazador() {
        return cazador;
    }

    public void setCazador(boolean cazador) {

        this.cazador = cazador;
    }
    @Override
    public String mostrarTipo(){
        return "Soy un gato";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Color: " + color +
                ", Cazador: " + cazador;
    }
}
