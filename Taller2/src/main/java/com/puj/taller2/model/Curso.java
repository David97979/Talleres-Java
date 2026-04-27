package com.puj.taller2.model;

import java.util.ArrayList;

public class Curso {
    private String nombrecur;
    private String codigocurso;
    private ArrayList<Estudiante> listaEstudiantes;

    public Curso(String nombrecur, String codigocurso){
        this.nombrecur = nombrecur;
        this.codigocurso = codigocurso;
        this.listaEstudiantes = new ArrayList<>();
    }


    public void agregarEstudiante(Estudiante e){
        listaEstudiantes.add(e);

   }
    public void mostrarestudiante() {
      for (int i = 0; i < listaEstudiantes.size(); i++) {
        System.out.println(listaEstudiantes.get(i).toString());

      }
    }
    public int getCantidadEstudiantes () {

        return listaEstudiantes.size();
    }

     public String getNombre() {
        return nombrecur;
    }

     public String getCodigoCurso() {
        return codigocurso;
    }

}
