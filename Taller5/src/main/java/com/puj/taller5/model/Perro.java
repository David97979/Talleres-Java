package com.puj.taller5.model;


import com.puj.taller5.excepciones.DatoInvalidoException;

public class Perro extends Mascotas {
    private String raza;
    private boolean entrenamiento;

    public Perro(int codigo, String nombre, int edad, int cedulaDueno, String raza, boolean entrenamiento) {
        super(codigo,nombre,edad,cedulaDueno);
        this.raza = raza;
        this.entrenamiento = entrenamiento;

    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) throws DatoInvalidoException {
        if (raza == null || raza.isEmpty()) {
            throw new DatoInvalidoException("Raza inválida o vacia");
        }
        this.raza = raza;
    }

    public boolean isEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(boolean entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    @Override
    public String mostrarTipo() {
        return "Soy un perro";
    }

    @Override
    public String toString() {
        return super.toString() +
        ", Raza: " + raza +
        ", Entrenado: " + entrenamiento;
    }


}
