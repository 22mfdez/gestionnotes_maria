package com.clases;

import java.util.ArrayList;
import java.util.TreeMap;

public class Alumno extends Usuario {
    private ArrayList<Calificacion> calificaciones;

    public Alumno(String login, String password) {
        super(login, password);
        calificaciones = new ArrayList<Calificacion>();
    }

    public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }
    public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    // Método para obtener las calificaciones asignadas por un profesor específico
    public ArrayList<Calificacion> getCalificaciones(Profesor profesor) {
        ArrayList<Calificacion> calificacionesProfesor = new ArrayList<>();
        for (Calificacion calificacion : calificaciones) {
            if (calificacion.getProfesor().equals(profesor)) {
                calificacionesProfesor.add(calificacion);
            }
        }
        return calificacionesProfesor;
    }

    public void calificar(Profesor profesor, String asignatura, int nota) {
        Calificacion nuevaCalificacion = new Calificacion(profesor, asignatura, nota);
        calificaciones.add(nuevaCalificacion);
    }

    @Override
    public String toString() {
        String calificaciones = "";
        for (Calificacion c : this.getCalificaciones()) {
            calificaciones += c.toString() + "\n";
        }
        return "Alumno: " + this.getLogin() + "\n" + calificaciones;
    }

    public String getLogin() {
        if (super.getLogin() != null) {
            return super.getLogin();
        } else {
            return ""; // O alguna otra lógica para manejar el caso en que no haya un nombre de usuario definido
        }
    }
}
