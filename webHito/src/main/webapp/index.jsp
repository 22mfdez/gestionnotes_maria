
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio - Escuela</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="icon" type="image/x-icon" href="login.svg">
   <style>
        .boton1 {
            text-decoration: none; /* Elimina el subrayado */
            display: flex;
            justify-content: center; /* Centra horizontalmente */
            align-items: center;
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
    <header class="container2">
      <div class="container px-5">
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <div class="text-center my-5">
                      <h1 class="display-5 fw-bolder text-white mb-2">Tu nota es más importante que todo.</h1>
                      <p class="lead text-white-50 mb-4">Recuerda que iniciando sesión en nuestra plataforma puedes ver tus notas desde cualquier lugar del mundo!</p>
                      <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
                          <a class="boton1" href="index.html">Inicia tu sesión</a>
                          <a class="boton1" href="#!">Lee más</a>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </header>
    <div class="container1">
    <h1>Inicia tu sesión</h1>
    <form action="LoginServlet" method="post">
    <div>
        <label for="usuario">Usuario</label>
        <input type="text" name="usuario" id="usuario" required>
    </div>
    <div>
        <label for="password">Contraseña</label>
        <input type="password" name="password" id="password" required>
    </div>
    <div style="text-align: center;">
        <button class="boton1" type="submit" >Iniciar Sesión</button>
    </div>
    </form>
</div>
    
    

  </body>
</html>