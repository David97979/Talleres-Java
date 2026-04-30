package com.puj.taller4.model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vehiculos {
    private String placa;
    private String marca;
    private LocalDate fechaMatricula;
    private boolean tieneRevisionTecno;
    private boolean arrendado; // no cos
    private LocalDate fechaDevolucion; // no cons
    private Cliente clienteActual;

    public Vehiculos(String placa, String marca, Date fechaMatricula, boolean tieneRevisionTecno, Cliente clienteActual) {
        this.placa = placa;
        this.marca = marca;
        this.fechaMatricula = fechaMatricula;
        this.tieneRevisionTecno = tieneRevisionTecno;
        this.clienteActual = clienteActual;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public boolean isTieneRevisionTecno() {
        return tieneRevisionTecno;
    }

    public void setTieneRevisionTecno(boolean tieneRevisionTecno) {
        this.tieneRevisionTecno = tieneRevisionTecno;
    }

    public boolean isArrendado() {
        return arrendado;
    }

    public void setArrendado(boolean arrendado) {
        this.arrendado = arrendado;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }
    public boolean necesitaRevision(){
        LocalDate fActual = LocalDate.now();
        int frevision= (int) ChronoUnit.YEARS.between(this.fechaMatricula, fActual);
        return frevision > 6;
    }
    public boolean tienePicoYPlaca(LocalDate fecha){
        int dia = fecha.getDate();
        char ultimaletra = placa.charAt(placa.length() -1);
        int ultimodigito = Character.getNumericValue(ultimaletra);

    }
}
