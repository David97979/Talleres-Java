package com.puj.taller6.persistencia;
import com.puj.taller6.model.Cliente;
import com.puj.taller6.model.Cuenta;
import java.util.ArrayList;
import java.io.*;

import java.io.*;
import java.util.ArrayList;

public class GestionArchivos {
    private ArrayList<Cliente> clientes;

    public GestionArchivos() {
        clientes = new ArrayList<>();
    }

    public void leerArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {

            String linea;
            Cliente clienteActual = null;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if ("FIN".equals(linea)) {
                    break;
                } else if (linea.contains("/")) {
                    String[] datos = linea.split("/");
                    clienteActual = new Cliente(datos[0], datos[1], datos[2], datos[3]);
                    clientes.add(clienteActual);
                } else if (linea.startsWith("PC=")) {
                    int puntaje = Integer.parseInt(linea.split("=")[1]);
                    clienteActual.setPuntaje(puntaje);

                } else if ("#".equals(linea)) {

                } else {
                    String[] datosCuenta = linea.split(",");
                    String tipoCuenta = datosCuenta[0];
                    double saldo = Double.parseDouble(datosCuenta[1]);
                    String banco = datosCuenta[2];
                    String red = "";
                    String categoria = "";
                    if (datosCuenta.length >= 4) {
                        red = datosCuenta[3];
                    }
                    if (datosCuenta.length == 5) {
                        categoria = datosCuenta[4];
                    }
                    Cuenta cuenta = new Cuenta(tipoCuenta, saldo, banco, red, categoria);
                    clienteActual.agregarcuenta(cuenta);
                }
                System.out.println("Archivo leido correctamente");

            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
}
