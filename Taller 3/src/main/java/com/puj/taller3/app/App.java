package com.puj.taller3.app;
import com.puj.taller3.model.Producto;
import com.puj.taller3.model.Tienda;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "--- Sistema de Tienda ---");

        Tienda tienda = new Tienda("MI tienda");

        Producto p1 = new Producto("TV Samsung", 2000000, "ELEC");
        Producto p2 = new Producto("Camisa Polo", 100000, "ROPA");
        Producto p3 = new Producto("Laptop ASUS", 4000000, "ELEC");

        tienda.agregarProducto(p1);
        tienda.agregarProducto(p2);
        tienda.agregarProducto(p3);

        p1.aplicarDescuento();
        p3.aplicarDescuento(20);

        tienda.mostrarInventario();

        System.out.println("Total de productos creados:" +  Producto.getContadorp());

        double precioIVA = Tienda.calcularPrecioConIVA(p3.getPrecio());
        System.out.println(" Precio con IVA Laptop: " + precioIVA);
        System.out.println(" Precio con IVA Laptop: " + precioIVA);

    }
}
