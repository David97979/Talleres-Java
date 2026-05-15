package com.puj.taller6.app;
import com.puj.taller6.model.Cliente;
import com.puj.taller6.model.Cuenta;
import com.puj.taller6.persistencia.GestionArchivos;

public class App 
{
    public static void main( String[] args )
    {
        GestionArchivos gestor = new GestionArchivos();
        gestor.leerArchivo();
        gestor.guardarObjetos();
        gestor.leerObjetos();
        gestor.generarReporteRiesgos();
        for (Cliente cliente : gestor.getClientes()) {

            System.out.println("CLIENTE");

            System.out.println("Nombre: " + cliente.getNombre());

            System.out.println("Identificación: " + cliente.getIdentificacion());

            System.out.println("Dirección: " + cliente.getDireccion());

            System.out.println("Ciudad: " + cliente.getCiudad());

            System.out.println("Puntaje: " + cliente.getPuntaje());

            System.out.println("CUENTAS");

            for (Cuenta cuenta : cliente.getCuentas()) {

                System.out.println("Tipo: "+ cuenta.getTipoCuenta());

                System.out.println("Saldo: "
                        + cuenta.getSaldo());

                System.out.println("Banco: " + cuenta.getBanco());

                System.out.println("Red: " + cuenta.getRed());

                System.out.println("Categoría: " + cuenta.getCategoria());

                System.out.println("-------------------");
            }
        }
    }
}


