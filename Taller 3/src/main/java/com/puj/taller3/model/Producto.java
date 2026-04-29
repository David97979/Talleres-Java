package com.puj.taller3.model;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private final String codigo;
    private static int contadorp = 0;

    public Producto(String nombre,double precio, String categoria){
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        contadorp++;
        this.codigo =  categoria.toUpperCase() + "-" + contadorp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo(){
        return codigo;
    }
    @Override
    public String toString() {
        return nombre + " | Código: " + codigo + " | Precio: " + precio;
    }
    public void aplicarDescuento(double porcentaje) {
        precio -= precio * (porcentaje / 100);
    }
    public void aplicarDescuento() {
        aplicarDescuento(10);
    }
    public static  int getContadorp() {
        return contadorp;
    }
    public final void mostrarResumen(){
        System.out.println(nombre + " - " + codigo + " $ " + precio);
    }

}
