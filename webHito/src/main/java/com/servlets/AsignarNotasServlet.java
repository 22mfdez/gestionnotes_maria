package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.clases.Alumno;
import com.clases.Escuela;
import com.clases.Profesor;
import com.clases.Usuario;

@WebServlet("/AsignarNotasServlet")
public class AsignarNotasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AsignarNotasServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();

        // Obtiene el profesor de la sesión
        Profesor profesor = (Profesor) session.getAttribute("profesor");

        if (profesor != null) {
            Escuela escuela = (Escuela) session.getAttribute("escuela");
            List<Alumno> alumnos = escuela.obtenerListaAlumnos();

            // Itera sobre los alumnos para asignar notas por el profesor
            for (Alumno alumno : alumnos) {
                String asignatura = request.getParameter("asignatura_" + alumno.getLogin());
                String notaParam = request.getParameter("nota_" + alumno.getLogin());

                // Si la nota es válida
                if (notaParam != null && !notaParam.isEmpty()) {
                    int nota = Integer.parseInt(notaParam);

                    // Asigna la nota al alumno
                    alumno.calificar(profesor, asignatura, nota);
                }
            }

            // Actualiza la lista de alumnos en la sesión con las nuevas calificaciones
            session.setAttribute("alumnos", alumnos);

            // Redirige a la página del profesor o a otra página
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
