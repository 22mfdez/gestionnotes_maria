package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.clases.*;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Recupera la instancia de la Escuela desde la sesión si ya existe.
        HttpSession session = request.getSession();
  
        Escuela e = (Escuela) session.getAttribute("escuela");
        if (e == null) {
            e = new Escuela();

            // Agrega los profesores y alumnos
            e.nuevoProfesor("Pepe", "1234", "Matematicas, Musica");
            e.nuevoProfesor("Juan", "1234", "Informatica");
                    
            e.nuevoAlumno("Alicia", "2345");
            e.nuevoAlumno("Miguel", "2345");

            // Guarda la instancia de la Escuela en la sesión
            session.setAttribute("escuela", e);
            
            // Obtén la lista de alumnos
            List<Alumno> alumnos = e.obtenerListaAlumnos(); // Asume que Escuela tiene un método obtenerListaAlumnos() que devuelve la lista de alumnos.

            // Guarda la lista de alumnos en el contexto de la aplicación
            getServletContext().setAttribute("alumnos", alumnos);
        }
	

        // Obtén los valores de login y password desde el formulario.
        String login = request.getParameter("usuario");
        String password = request.getParameter("password");

        // Aquí deberías autenticar al usuario y obtener su instancia de Alumno o Profesor.
        Usuario usuarioAutenticado = e.autenticarUsuario(login, password); // Implementa esta lógica en la clase Escuela

     // Redirige al usuario según su instancia (Alumno o Profesor).
        if (usuarioAutenticado instanceof Alumno) {
            Alumno alumno = (Alumno) usuarioAutenticado;
            // Obtén las calificaciones del alumno
            List<Calificacion> calificaciones = alumno.getCalificaciones();

            // Guarda las calificaciones en la sesión
            session.setAttribute("calificaciones", calificaciones);

            session.setAttribute("alumno", alumno); // Guarda al alumno en la sesión
            response.sendRedirect("alumno.jsp");
        } else if (usuarioAutenticado instanceof Profesor) {
            Profesor profesor = (Profesor) usuarioAutenticado;
            session.setAttribute("profesor", profesor); // Guarda al profesor en la sesión
            response.sendRedirect("profesor.jsp");
        } else {
            // Puedes manejar otros casos aquí, como redirigir a una página de error.
            response.sendRedirect("pagina_de_error.jsp");
        }
    }
}
