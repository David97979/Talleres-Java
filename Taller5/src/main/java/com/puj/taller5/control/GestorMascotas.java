package com.puj.taller5.control;
import com.puj.taller5.model.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import com.puj.taller5.persistencia.ArchivosLyE;
import com.puj.taller5.excepciones.CedulaDuplicadaException;
import com.puj.taller5.excepciones.DatoInvalidoException;


public class GestorMascotas {
    private ArrayList<Mascotas> listaMascotas;
    private Set<Integer> cedulasRegistradas;

    public GestorMascotas() {
        listaMascotas = new ArrayList<>();
        cedulasRegistradas = new HashSet<>();
    }
    public void agregarPerro(Perro perro) throws CedulaDuplicadaException{
        if(cedulasRegistradas.contains(perro.getCedulaDueno())){
            throw new CedulaDuplicadaException("La cédula del dueño ya está registrada");
        }
        listaMascotas.add(perro);
        cedulasRegistradas.add(perro.getCedulaDueno());

    }
    public void agregarGato(Gato gato) throws CedulaDuplicadaException{
        if(cedulasRegistradas.contains(gato.getCedulaDueno())){
            throw new CedulaDuplicadaException("La cédula del dueño ya está registrada");
        }
        listaMascotas.add(gato);
        cedulasRegistradas.add(gato.getCedulaDueno());
    }
    public void listarMascotas() {
        for(Mascotas m : listaMascotas){
            System.out.println(m.mostrarTipo());
            System.out.println(m);
            System.out.println("-----------------");
        }
    }
    public void buscarPorCedula(int cedulaDueno) {
        boolean encontrado = false;
        for(Mascotas m : listaMascotas){
            if(m.getCedulaDueno() == cedulaDueno){
                System.out.println(m);
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("No se encontraron mascotas para la cédula: " + cedulaDueno);
        }
    }
    public void guardarEnArchivo(){
        try {
            ArchivosLyE.guardar(listaMascotas);
            System.out.println("Mascotas guardadas en el archivo exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }
    public void leerDesdeArchivo(){
        try {
            listaMascotas = ArchivosLyE.leer();
            cedulasRegistradas.clear();
            for(Mascotas m : listaMascotas){
                cedulasRegistradas.add(m.getCedulaDueno());
            }
            System.out.println("Mascotas cargadas desde el archivo exitosamente.");
        }
         catch (Exception e) {
            System.out.println("Error al leer desde el archivo: " + e.getMessage());
        }
    }


    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
      do {
            System.out.println("--- Menú de Gestión de Mascotas ---");
            System.out.println("1. Agregar Perro");
            System.out.println("2. Agregar Gato");
            System.out.println("3. Listar Mascotas");
            System.out.println("4. Buscar por Cédula");
            System.out.println("5. Guardar En Archivo");
            System.out.println("6. Cargar desde Archivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese código: ");
                        int codigoP = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese nombre: ");
                        String nombreP = sc.nextLine();
                        System.out.print("Ingrese edad: ");
                        int edadP = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese cédula del dueño: ");
                        int cedulaP = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese raza: ");
                        String razaP = sc.nextLine();
                        System.out.print("¿Está entrenado? (true/false): ");
                        boolean entrenamientoP = sc.nextBoolean();
                        Perro perro = new Perro(codigoP, nombreP, edadP, cedulaP, razaP, entrenamientoP);
                        agregarPerro(perro);
                        break;
                    case 2:
                        System.out.print("Ingrese código: ");
                        int codigoG = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese nombre: ");
                        String nombreG = sc.nextLine();
                        System.out.print("Ingrese edad: ");
                        int edadG = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese cédula del dueño: ");
                        int cedulaG = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese color: ");
                        String colorG = sc.nextLine();
                        System.out.print("¿Es cazador? (true/false): ");
                        boolean cazadorG = sc.nextBoolean();
                        Gato gato = new Gato(codigoG, nombreG, edadG, cedulaG, colorG, cazadorG);
                        agregarGato(gato);
                        break;
                    case 3:
                        listarMascotas();
                        break;
                    case 4:
                        System.out.print("Ingrese cédula del dueño a buscar: ");
                        int cedulaBuscar = sc.nextInt();
                        sc.nextLine();
                        buscarPorCedula(cedulaBuscar);
                        break;
                    case 5:
                        guardarEnArchivo();
                        break;
                    case 6:
                        leerDesdeArchivo();
                        break;

                    case 0:
                        System.out.println("Salida exitosamente.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");

                }
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }

      }
      while (opcion != 0);
    }

}
