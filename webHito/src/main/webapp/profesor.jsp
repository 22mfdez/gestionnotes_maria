<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clases.Alumno" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.clases.Calificacion" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Panel-profesor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="icon" type="image/x-icon" href="profesor.svg">
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Quicksand&display=swap');
        .container {
           font-family: 'Quicksand', sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        .boton1{
		    font-family: 'Quicksand', sans-serif;
		    display: inline-block;
		    margin-top: 20px;
		    outline: 0;
		    width: 170px;
		    text-align: center;
		    border: none;
		    box-shadow: none;
		    cursor: pointer;
		    padding: 9px 22px;
		    font-size: 18px;
		    height: 50px;
		    font-weight: 400;
		    color: #fff;
		    line-height: normal;
		    background: linear-gradient(90deg,#5522fa 0,#0074e4 100%);
		    border-radius: 50px;
		    transition: color .2s ease,background-color .2s ease,box-shadow .2s ease;
		    /* transition: transform 0.5s; */
		    .navbar-brand {
		    display: flex;
		    align-items: center;
  			}

		  .navbar-brand {
		    display: flex;
		    align-items: center;
		  }
			
		  .navbar-brand img {
			    margin-right: 5px; /* Ajusta el espacio entre la imagen y el texto según sea necesario */
  			}
    </style>
</head>
<body>
<nav class="navbar bg-body-tertiary my-navbar">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">
          <img src="home.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
          <span class="align-middle">Inicio</span>
        </a>
      </div>
    </nav>
    <div class="container">
        <h1 class="mb-4">Notas de Alumnos</h1>
        <form action="AsignarNotasServlet" method="post">
            <%
                List<Alumno> alumnos = (List<Alumno>) getServletContext().getAttribute("alumnos");

                if (alumnos != null && !alumnos.isEmpty()) {
                    for (Alumno alumno : alumnos) {
            %>
            <div class="border p-3 mb-3">
                <h3>Alumno: <%= alumno.getLogin() %></h3>
                <input type="hidden" name="alumno" value="<%= alumno.getLogin() %>">
                <div class="mb-3">
                    <label for="asignatura_<%= alumno.getLogin() %>" class="form-label">Asignatura</label>
                    <input type="text" class="form-control" id="asignatura_<%= alumno.getLogin() %>" name="asignatura_<%= alumno.getLogin() %>">
                </div>
                <div class="mb-3">
                    <label for="nota_<%= alumno.getLogin() %>" class="form-label">Nota</label>
                    <input type="text" class="form-control" id="nota_<%= alumno.getLogin() %>" name="nota_<%= alumno.getLogin() %>">
                </div>
            </div>
            <%
                    }
            %>
            <button type="submit" class="boton1">Guardar Notas</button>
            <%
                } else {
            %>
            <p>No hay alumnos registrados.</p>
            <%
                }
            %>
        </form>
    </div>
</body>
</html>
