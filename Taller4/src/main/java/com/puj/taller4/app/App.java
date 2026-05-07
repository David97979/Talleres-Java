package com.puj.taller4.app;

import java.time.LocalDate;
import java.util.Scanner;

import com.puj.taller4.model.*;
import com.puj.taller4.exceptions.*;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        EmpresaArrendadora empresa = new EmpresaArrendadora();


        empresa.agregarVehiculo(new Vehiculo("RER123", "Renault", LocalDate.of(2012, 12, 10), true));
        empresa.agregarVehiculo(new Vehiculo("TLY536", "Volkswagen", LocalDate.of(2020, 5, 8), false));
        empresa.agregarVehiculo(new Vehiculo("FRB690", "Mazda", LocalDate.of(2015, 3, 12), true));
        empresa.agregarVehiculo(new Vehiculo("QUU145", "Renault", LocalDate.of(2000, 7, 15), true));
        empresa.agregarVehiculo(new Vehiculo("RLY287", "Chevrolet", LocalDate.of(2022, 8, 21), false));
        empresa.agregarVehiculo(new Vehiculo("FBX567", "Ford", LocalDate.of(2002, 9, 13), false));
        empresa.agregarVehiculo(new Vehiculo("IUJ786", "Volkswagen", LocalDate.of(2001, 10, 26), true));
        empresa.agregarVehiculo(new Vehiculo("RBX546", "Renault", LocalDate.of(2022, 10, 5), false));
        empresa.agregarVehiculo(new Vehiculo("RCV123", "Mazda", LocalDate.of(2005, 6, 11), true));
        empresa.agregarVehiculo(new Vehiculo("OPI458", "Chevrolet", LocalDate.of(2020, 2, 22), false));
        empresa.agregarVehiculo(new Vehiculo("UJM786", "Ford", LocalDate.of(2007, 4, 18), true));
        empresa.agregarVehiculo(new Vehiculo("IGH989", "Volkswagen", LocalDate.of(2016, 5, 19), false));
        empresa.agregarVehiculo(new Vehiculo("QAZ124", "Mazda", LocalDate.of(2018, 11, 15), true));
        empresa.agregarVehiculo(new Vehiculo("QET456", "Ford", LocalDate.of(2002, 11, 18), true));
        empresa.agregarVehiculo(new Vehiculo("QDV679", "Chevrolet", LocalDate.of(2005, 12, 19), true));

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("--- Sistema de Alquiler ---");


            System.out.print("Ingrese marca: ");
            String marca = sc.nextLine();

            ArrayList<Vehiculo> vehiculos = empresa.buscarPorMarca(marca);

            System.out.println("Vehículos encontrados:");

            int i = 1;
            for (Vehiculo v : vehiculos) {
                System.out.println(i + ". " + v.getMarca() + " (Placa: " + v.getPlaca() + ")");
                i++;
            }
            Vehiculo v = vehiculos.get(0);



            Cliente c = new Cliente("CC", "123", "Juan", "Perez",LocalDate.of(2000, 5, 10));
            System.out.println("Arrendando vehículo " + v.getMarca() + " al cliente " + c.getNombreCompleto() + "...");


            empresa.arrendarVehiculo(v, c, 5);

            System.out.println("Vehículo arrendado correctamente");

        } catch (VehiculoNoEncontradoException e) {
            System.out.println(e.getMessage());

        } catch (ClienteNoAptoException e) {
            System.out.println(e.getMessage());

        } catch (VehiculoNoDisponibleException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("--- Vehículos con revisión ---");
        empresa.imprimirVehiculosRequierenRevision();

        System.out.println("-- Vehículos arrendados ---");
        empresa.imprimirVehiculosArrendados();

        System.out.println("--- Buscar por placa (X) ---");
        empresa.imprimirVehiculosPorPlaca("X");

        sc.close();
    }

}
