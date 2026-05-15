package com.puj.taller6.model;

import java.io.Serializable;

public abstract class Cuenta implements Serializable {
    protected double saldo;
    protected String banco;
    protected String red;

    public Cuenta(double saldo, String banco, String red) {

        this.saldo = saldo;
        this.banco = banco;
        this.red = red;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public abstract String getTipoCuenta();
}