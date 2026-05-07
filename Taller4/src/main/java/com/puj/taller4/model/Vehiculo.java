package com.puj.taller4.model;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Vehiculo {
    private String placa;
    private String marca;
    private LocalDate fechaMatricula;
    private boolean tieneRevisionTecno;
    private boolean arrendado; // no cos
    private LocalDateTime fechaDevolucion; // no cons
    private Cliente clienteActual;

    public Vehiculo(String placa, String marca, LocalDateTime fechaMatricula, boolean tieneRevisionTecno) {

            this.placa = placa;
            this.marca = marca;
            this.fechaMatricula = fechaMatricula;
            this.tieneRevisionTecno = tieneRevisionTecno;

            // estos se inicializan solos
            this.arrendado = false;
            this.clienteActual = null;
            this.fechaDevolucion = null;

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

    public LocalDateTime getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDateTime fechaMatricula) {
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

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }
    public boolean necesitaRevision(){
        LocalDateTime fActual = LocalDateTime.now();
        int frevision= (int) ChronoUnit.YEARS.between(this.fechaMatricula, fActual);
        return frevision > 6;
    }
    public boolean tienePicoYPlaca(LocalDateTime fecha){
        int dia = fecha.getDayOfMonth();
        char ultimaletra = placa.charAt(placa.length() -1);
        int ultimodigito = Character.getNumericValue(ultimaletra);
        if (dia % 2 == 0 && ultimodigito % 2 == 0) {
            return true;
        }

        if (dia % 2 != 0 && ultimodigito % 2 != 0) {
            return true;
        }

        return false;

    }
    @Override
    public String toString() {
        String texto = "Vehículo: " + this.marca +
                " (Placa: " + this.placa + ")\n" +
                "Fecha Matrícula: " + this.fechaMatricula + "\n";

        if (this.arrendado) {
            texto += "Arrendado: Sí\n";
            texto += "Cliente: " + this.clienteActual.getNombreCompleto();
        } else {
            texto += "Arrendado: No";
        }

        return texto;
    }
}
