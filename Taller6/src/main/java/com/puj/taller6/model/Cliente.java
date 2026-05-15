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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }
    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    @Override
    public String toString() {
        return "Cliente:" + " (" +
                "nombre:" + nombre +
                ", identificacion:" + identificacion  +
                ", direccion:" + direccion +
                ", ciudad:" + ciudad +
                ", puntaje:" + puntaje +
                ", cuentas:" + cuentas +
                ")";
    }
}
