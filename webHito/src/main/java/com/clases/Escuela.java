package com.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Escuela {
    private TreeMap<String, Usuario> usuarios;

    public Escuela() {
        super();
        this.usuarios = new TreeMap<>();
    }

    public void nuevoProfesor(String login, String password, String especialidad) {
        usuarios.put(login, new Profesor(login, password, especialidad));
    }

    public void nuevoAlumno(String login, String password) {
        usuarios.put(login, new Alumno(login, password));
    }

    public Usuario autenticarUsuario(String login, String password) {
        Usuario usuario = usuarios.get(login);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null; // Si la autenticación falla, devuelve null
    }

    public Alumno obtenerAlumnoPorLogin(String login) {
        Usuario usuario = usuarios.get(login);
        if (usuario instanceof Alumno) {
            return (Alumno) usuario;
        }
        return null; // Si el usuario no es un alumno o no se encuentra, devuelve null
    }
    public List<Alumno> obtenerListaAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();

        for (Usuario usuario : usuarios.values()) {
            if (usuario instanceof Alumno) {
                listaAlumnos.add((Alumno) usuario);
            }
        }

        return listaAlumnos;
    }

    // Otro método para obtener la lista de profesores si es necesario
    public List<Profesor> obtenerListaProfesores() {
        List<Profesor> listaProfesores = new ArrayList<>();

        for (Usuario usuario : usuarios.values()) {
            if (usuario instanceof Profesor) {
                listaProfesores.add((Profesor) usuario);
            }
        }

        return listaProfesores;
    }
}
