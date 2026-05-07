package com.puj.taller4.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;
import com.puj.taller4.exceptions.*;

public class EmpresaArrendadora {
    private ArrayList<Vehiculo> vehiculos;
    public EmpresaArrendadora() {
        vehiculos = new ArrayList<>();
    }
    public void agregarVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }
    public ArrayList<Vehiculo> buscarPorMarca(String marca) throws VehiculoNoEncontradoException {
        ArrayList<Vehiculo> encontrados = new ArrayList<>();

        for (Vehiculo v : vehiculos) {
            if (v.getMarca().equalsIgnoreCase(marca)) {
                encontrados.add(v);
            }
        }

        if (encontrados.isEmpty()) {
            throw new VehiculoNoEncontradoException("No se encontró vehículo de esa marca");
        }

        return encontrados;
    }
    public void arrendarVehiculo(Vehiculo v, Cliente c, int dias) throws ClienteNoAptoException, VehiculoNoDisponibleException {
        if (c.CalcularEdad() < 18) {
            throw new ClienteNoAptoException("El cliente no es mayor de edad");
        }

        if (v.necesitaRevision()) {
            throw new VehiculoNoDisponibleException("El vehículo necesita revisión");
        }

        v.setArrendado(true);
        v.setClienteActual(c);

        LocalDateTime fechaDevolucion = LocalDate.now().plusDays(dias).atTime(10, 0);

        if (v.tienePicoYPlaca(fechaDevolucion.toLocalDate())) {
            System.out.println("*** Advertencia: El vehículo tiene pico y placa ese día.");
            System.out.println("    Nueva hora de devolución: antes de las 6:00 a.m. ***");
            fechaDevolucion = fechaDevolucion.withHour(5).withMinute(59);
        }

        v.setFechaDevolucion(fechaDevolucion);
    }

    public void imprimirVehiculosRequierenRevision() {
        for (Vehiculo v : vehiculos) {
            if (v.necesitaRevision()) {
                System.out.println(v);
            }
        }
    }
    public void imprimirVehiculosArrendados() {
        for (Vehiculo v : vehiculos) {
            if (v.isArrendado()) {
                System.out.println(v);
            }
        }
    }
    public void imprimirVehiculosPorPlaca(String patron) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().toLowerCase().contains(patron.toLowerCase())) {
                System.out.println(v);
            }
        }
    }
}
