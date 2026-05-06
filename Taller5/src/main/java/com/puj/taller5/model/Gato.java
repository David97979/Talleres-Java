package com.puj.taller5.model;

public class Gato extends Mascotas {
    private String color;
    private boolean cazador;

    public Gato(int codigo, String nombre, int edad, int cedulaDuenoString String color, boolean cazador) {
        super(codigo, nombre, edad, cedulaDuenoString);
        this.color = color;
        this.cazador = cazador;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", Color: " + color +
                ", Cazador: " + esCazador;
    }
}
