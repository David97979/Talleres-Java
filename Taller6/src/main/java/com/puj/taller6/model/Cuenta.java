package com.puj.taller6.model;
import java.io.Serializable;
public class Cuenta  implements Serializable {

    private String tipoCuenta;
    private double saldo;
    private String banco;
    private String red;
    private String categoria;

    public Cuenta(String tipoCuenta, double saldo, String banco, String red, String categoria) {
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.banco = banco;
        this.red = red;
        this.categoria = categoria;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getBanco() {
        return banco;
    }

    public String getRed() {
        return red;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString(){
        return "Cuenta: " + tipoCuenta + " - " + saldo + " - " + banco;
    }

}

