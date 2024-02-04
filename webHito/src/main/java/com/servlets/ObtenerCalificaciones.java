package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.util.TreeMap;

import com.clases.Alumno;
import com.clases.Profesor;
import com.clases.Usuario;

@WebServlet("/ObtenerCalificaciones")
public class ObtenerCalificaciones extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ObtenerCalificaciones() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String alumno = request.getParameter("alumno");
        String asignatura = request.getParameter("asignatura");
        String notaString = request.getParameter("nota");

        int nota = 0;
        try {
            nota = Integer.parseInt(notaString);
        } catch (NumberFormatException e) {
        }

        ServletContext contextoAplicacion = this.getServletContext();
        TreeMap<String, Usuario> usuarios = (TreeMap<String, Usuario>) contextoAplicacion.getAttribute("usuarios");

        Profesor profesor = (Profesor) request.getSession().getAttribute("Login");

        if (profesor != null) {
            Usuario usuario = usuarios.get(alumno);
            if (usuario instanceof Alumno) {
                Alumno alumnoObj = (Alumno) usuario;
                alumnoObj.calificar(profesor, asignatura, nota);
            }
            response.sendRedirect("profesor.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}