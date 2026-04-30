package com.puj.taller4.model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Clientes {
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Clientes(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, Date fechaNacimiento) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int CalcularEdad(){
        LocalDate fActual = LocalDate.now();
        int edad = (int) ChronoUnit.YEARS.between(this.fechaNacimiento, fActual);
        return edad;

    }
    public String getNombreCompleto(){
        return this.nombres + " " + this.apellidos;
    }
    @Override
    public String toString() {
        return "Cliente: " + getNombreCompleto() +
                "Tipo ID: " + tipoIdentificacion +
                "Número ID: " + numeroIdentificacion +
                "Fecha Nacimiento: " + fechaNacimiento +
                "Edad: " + calcularEdad();
    }

}
