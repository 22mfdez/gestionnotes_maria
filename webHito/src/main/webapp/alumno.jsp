<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.clases.Alumno" %>
<%@ page import="com.clases.Calificacion" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel-alumno</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="alumno.svg">
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Quicksand&display=swap');
        body {
            font-family: 'Quicksand', sans-serif;
            margin: 20px;
        }
        .container {
            margin-top: 20px;
        }
        .calificaciones-title {
            margin-top: 40px;
            padding: 20px 0;
            text-align: center;
        }
        .no-calificaciones {
            margin-top: 20px;
            text-align: center;
        }
        table.table.table-striped {
            font-size: 25px;
            border-radius: 30px; /* Agrega bordes redondeados a la tabla */
        }
    </style>
</head>
<body>
<nav class="navbar bg-body-tertiary my-navbar">
      <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
          <img src="home.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
          <span class="align-middle">Inicio</span>
        </a>
      </div>
    </nav>
    <div class="container">
        <div class="calificaciones-title">
            <h1>Calificaciones del Alumno</h1>
        </div>
        <% 
            List<Calificacion> calificaciones = (List<Calificacion>) session.getAttribute("calificaciones");
            if (calificaciones != null && !calificaciones.isEmpty()) {
        %>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Profesor</th>
                    <th>Asignatura</th>
                    <th>Nota</th>
                </tr>
            </thead>
            <tbody>
                <% for (Calificacion calificacion : calificaciones) { %>
                    <tr>
                        <td><%= calificacion.getProfesor().getLogin() %></td>
                        <td><%= calificacion.getAsignatura() %></td>
                        <td><%= calificacion.getNota() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <% 
            } else { 
        %>
            <p class="no-calificaciones">No hay calificaciones registradas para este alumno.</p>
        <% } %>
    </div>
</body>
</html>
