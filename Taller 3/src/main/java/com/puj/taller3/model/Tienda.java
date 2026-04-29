package com.puj.taller3.model;
import java.util.ArrayList;

public class Tienda {
    private String nombre;
    private ArrayList<Producto> inventario;
    private final static double IVA = 0.19;

    public Tienda(String nombre){
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
    }

    public void agregarProducto(Producto p){
        inventario.add(p);
    }
    public void mostrarInventario(){
        System.out.println("Invetario de la tienda:");
        for(Producto p : inventario){
            System.out.println(p);
        }
    }
    public static double calcularPrecioConIVA(double preciobase){
        return preciobase +(preciobase * IVA);
    }

    public String getNombre() {
        return nombre;

    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

