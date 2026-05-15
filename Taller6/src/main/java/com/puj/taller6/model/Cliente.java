package com.puj.taller6.model;
import java.util.ArrayList;
import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String identificacion;
    private String direccion;
    private String ciudad;
    private int puntaje;

    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, String identificacion, String direccion, String ciudad) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.ciudad = ciudad;


        cuentas = new ArrayList<>();
    }
    public void agregarcuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
