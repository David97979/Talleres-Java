package com.puj.taller2.app;
import com.puj.taller2.model.Estudiante;
import com.puj.taller2.model.Curso;


public class App
{
    public static void main (String[] args){
        Estudiante e1 = new Estudiante("Juan Pérez", "202501", 20);
        Estudiante e2 = new Estudiante("María Gómez", "202502", 19);
        Estudiante e3 = new Estudiante("Carlos Rodríguez", "202503", 21);
        Estudiante e4 = new Estudiante("Ana Martínez", "202504", 22);

        Curso curso = new Curso("Programación Orientada a Objetos", "POO101");
        curso.agregarEstudiante(e1);
        curso.agregarEstudiante(e2);
        curso.agregarEstudiante(e3);
        curso.agregarEstudiante(e4);
        System.out.println("--- Sistema de Cursos ---");
        System.out.println("Curso: " + curso.getNombre() + " (" + curso.getCodigoCurso() + ")");
        System.out.println("Estudiantes inscritos: ");

        curso.mostrarestudiante();

        System.out.println("Total de estudiantes: " + curso.getCantidadEstudiantes());

    }

}