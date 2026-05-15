package com.puj.taller6.model;

public class CuentaAhorro extends Cuenta {
    public CuentaAhorro(double saldo, String banco, String red) {
        super(saldo, banco, red);
    }

    @Override
    public String getTipoCuenta() {
        return "Cuenta de ahorros";
    }
}
