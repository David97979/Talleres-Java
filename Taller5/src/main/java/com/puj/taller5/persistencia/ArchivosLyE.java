package com.puj.taller5.persistencia;

import com.puj.taller5.model.Mascotas;
import java.io.*;
import java.util.ArrayList;

public class ArchivosLyE {
    public static void guardar(ArrayList<Mascotas> listaMascotas) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mascotas.dat"));
        oos.writeObject(listaMascotas);
        oos.close();

    }
    public static ArrayList<Mascotas> leer() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mascotas.dat"));
        ArrayList<Mascotas> listaMascotas = (ArrayList<Mascotas>) ois.readObject();
        ois.close();
        return listaMascotas;
    }
}
