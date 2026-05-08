package com.puj.taller5.main;
import com.puj.taller5.control.GestorMascotas;

import com.puj.taller5.excepciones.*;

public class App 
{
    public static void main( String[] args )
    {
        GestorMascotas gestor = new GestorMascotas();
        gestor.menu();
    }
}
