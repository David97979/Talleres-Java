package com.puj.taller5.model;

public class Perro extends Mascotas {
    private String raza;
    private boolean Entrenamiento;

    public Perro(int codigo, String nombre, int edad, int cedulaDueno, String raza, boolean entrenamiento) {
        super(codigo,nombre,edad,cedulaDueno);
        this.raza = raza;
        Entrenamiento = entrenamiento;

    }
    @Override

    public String toString() {
        return super.toString() +
                ", Raza: " + raza +
                ", Entrenado: " + tieneEntrenamiento;
    }


}
