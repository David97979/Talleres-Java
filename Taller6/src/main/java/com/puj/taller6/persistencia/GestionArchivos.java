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
            }
            System.out.println("Archivo leido correctamente");
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    public void guardarObjetos() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {

            oos.writeObject(clientes);

            System.out.println("Objetos guardados correctamente");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void leerObjetos() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {

            clientes = (ArrayList<Cliente>) ois.readObject();

            System.out.println("Objetos cargados correctamente");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void generarReporteRiesgos() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("riesgos.txt"))) {

            for (Cliente cliente : clientes) {

                bw.write(cliente.getIdentificacion() + " - " + cliente.getNombre() + " - " + cliente.getCiudad());

                bw.newLine();

                bw.write("Cuentas bancarias");

                bw.newLine();

                for (Cuenta cuenta : cliente.getCuentas()) {
                    String tipo = "";

                    if (cuenta.getTipoCuenta().equalsIgnoreCase("CA")) {
                        tipo = "Cuenta de ahorros";
                    }

                    else if (cuenta.getTipoCuenta().equalsIgnoreCase("CC")) {
                        tipo = "Cuenta corriente";
                    }

                    else if (cuenta.getTipoCuenta().equalsIgnoreCase("TC")) {
                        tipo = "Tarjeta de crédito";
                    }

                    bw.write(tipo + " - " + cuenta.getBanco() + " - " + cuenta.getRed());

                    if (!cuenta.getCategoria().isEmpty()) {

                        bw.write(" - " + cuenta.getCategoria());
                    }

                    bw.newLine();
                }

                String reporte = "";

                if (cliente.getPuntaje() >= 150 && cliente.getPuntaje() <= 300) {
                    reporte = "Malo";
                }

                else if (cliente.getPuntaje() >= 301 && cliente.getPuntaje() <= 475) {
                    reporte = "Regular";
                }

                else if (cliente.getPuntaje() >= 476 && cliente.getPuntaje() <= 670) {
                    reporte = "Bueno";
                }

                else if (cliente.getPuntaje() >= 671 && cliente.getPuntaje() <= 950) {

                    reporte = "Excelente";
                }

                bw.write("Reporte: " + cliente.getPuntaje() + " - " + reporte);

                bw.newLine();

                bw.write("#");

                bw.newLine();
            }

            System.out.println("Archivo riesgos.txt generado correctamente");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void generarArchivoBanco(String bancoBuscado) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("banco.txt"))) {

            bw.write("Cuentas del banco " + bancoBuscado);
            bw.newLine();

            for (Cliente cliente : clientes) {

                boolean tieneBanco = false;

                for (Cuenta cuenta : cliente.getCuentas()) {
                    if (cuenta.getBanco().equalsIgnoreCase(bancoBuscado)) {
                        tieneBanco = true;
                    }
                }
                if (tieneBanco) {
                    bw.write("#");
                    bw.newLine();
                    bw.write(cliente.getIdentificacion() + " " + cliente.getNombre());
                    bw.newLine();

                    for (Cuenta cuenta : cliente.getCuentas()) {

                        if (cuenta.getBanco().equalsIgnoreCase(bancoBuscado)) {
                            String tipo = "";

                            if (cuenta.getTipoCuenta().equalsIgnoreCase("CA")) {
                                tipo = "Cuenta de ahorros";
                            }

                            else if (cuenta.getTipoCuenta().equalsIgnoreCase("CC")) {
                                tipo = "Cuenta corriente";
                            }

                            else if (cuenta.getTipoCuenta().equalsIgnoreCase("TC")) {

                                tipo = "Tarjeta de crédito";
                            }

                            bw.write(tipo + " " + cuenta.getSaldo() + " " + cuenta.getRed() + " " + cuenta.getCategoria());

                            bw.newLine();
                        }
                    }
                }
            }

            System.out.println("Archivo banco.txt generado correctamente");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

}
