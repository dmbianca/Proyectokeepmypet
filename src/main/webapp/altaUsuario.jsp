<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.eoi.servicios.conexion" %>
<%@ page import=" java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Keep My Pet</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/estilos.css"type="text/css">


</head>

<body>

	<header class="h1" ><a href="ServletListaAnimales?tipo=todos" style='text-decoration:none;color:black'>Keep My Pet <i class="fas fa-paw"></a></i></header> 



	<div class="collapse" id="navbarToggleExternalContent">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarText"
					aria-controls="navbarText" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarText">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="index.jsp">Login</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="websAmigas.html">Webs Amigas</a></li>
						<li class="nav-item"><a class="nav-link"
							href="Protectoras.html">Protectoras</a></li>
						<li class="nav-item"><a class="nav-link"
							href="ServletListaAnimales?tipo=todos">Mascotas En Adopcion</a></li>
						<li class="nav-item"><a class="nav-link"
							href="colaboradores.jsp">Colaboradores</a></li>

					</ul>
				</div>
			</div>
		</nav>
	</div>
	<nav class="navbar navbar-dark bg-dark" style="height: 45px;">
		<div class="container-sm">

			<button
				class="btn btn-dark position-absolute top-50 start-50 translate-middle"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarToggleExternalContent"
				aria-controls="navbarToggleExternalContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-chevron-down"></i>

			</button>
		</div>
	</nav>


	<div style="position: relative; left: 100px; width: 300px; padding:10px;">
		<h1 class="h1">Crea Tu Cuenta</h1>
        <form action="FormServlet" method="POST"  class="card bg-dark" style="width: 19rem;" >
        <font color="white" size="3" face="Arial">
        <div class="mb-3">
            <label>Nombre</label><input type="text" name="UsuNombre" id="altaUsu" placeholder="Introduzca su nombre" required>
            <br/>
        </div>
        <div class="mb-3">
        <label class="col-form-label">Apellidos</label><input type="text" name="UsuApellido" placeholder="Introduzca sus apellidos" required>
        <br/>
        </div>    
        <div class="mb-3">
        <label class="col-form-label">Fecha de Nacimiento</label><input type="date" required name="UsuNacimiento">
         <br/>
        </div>
        <div class="mb-3">
        <label class="col-form-label">Correo</label><input type="email" name="UsuMail" placeholder="ejemplo@ejemplo.com" required>
            <br/>
        </div>    
        <div class="mb-3">
        <label class="col-form-label">Ciudad</label><select name="UsuCiudad"required>
                <option value="Alicante">Alicante</option>
                <option value="Elda">Elda</option>
                <option value="Petrer">Petrer</option>
                <option value="Alcoy">Alcoy</option>
            </select><br/>
        </div>    
        <div class="mb-3">
        <label class="col-form-label ">DNI</label><input type="text" name="UsuDNI" required>
        <br/>
        </div>    
        <div class="mb-3">
        <label class="col-form-label">Telefono</label><input type="text" name="UsuTelf" required> 
            <br/>
        </div>
        <div class="mb-3">
        <label class="col-form-label">Contraseña</label><input  type="password" name="UsuPass" required> 
            <br/>
        </div>    
        <div class="mb-3">
        <input type="submit" value="Enviar">
        </div>    
         </font>   
            
            
            
        </form>
        
    </div>

	<footer class="bg-dark padding-max bg-cercle-verd" id="inicio">
		<div class="container">
			<div class="row">
				<div class="col-md-3 mb-0">
					<h5 class="text-decoration-underline">Sobre Nosotros</h5>
					<p>Somos un grupo de estudiantes de programación que se nos
						encomendó el proyecto final de hacer una pagina web y decidimos
						ponerlo al servicio del publico haciendo una pagina de adopción de
						animales.</p>
				</div>
				<div class="col-md-3 mb-0">
					<h5 class="text-decoration-underline">Colaboradores del
						Proyecto</h5>
					<p>Radwane Abdessamie</p>
					<p>Dimodena Bianca Leonela</p>
					<p>Cano Garcia Miguel</p>
				</div>
				<div class="col-md-3 mb-0">
					<h5 class="text-decoration-underline">Contactanos</h5>
					 <p><a href="https://www.instagram.com/keepmypet" style='text-decoration:none;color:white'><i id="contact" class="fab fa-instagram"></i>&nbsp;keepMyPetSocial</a></p>
					<p>
						<i id="contact" class="fab fa-twitter"></i> &nbsp;@keepMyPetEspaña
					</p>
					<p>
						<i id="contact" class="fab fa-facebook-f"></i> &nbsp;keepMyPet
					</p>
				</div>
			</div>
		</div>

	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>

</html>