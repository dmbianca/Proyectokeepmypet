<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.eoi.servicios.conexion" %>
<%@ page import=" java.sql.*" %>
<%@ page import="com.eoi.modelo.Usuarios" %>

<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tu perfil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="css/estilos.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<header class="h1" ><a href="ServletListaAnimales?tipo=todos" style='text-decoration:none;color:black;(otros)'>Keep My Pet <i class="fas fa-paw"></a></i></header> 
<%

	Connection con = conexion.getInstance().getConnection();
	String sql = "SELECT * FROM usuarios";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	Usuarios usu = (Usuarios)session.getAttribute("Usuario");
	
%>

<h2>Bienvenido Administrador <%=usu.getUsuNombre() %> - <%=usu.getUsuRol()%></h2>


<nav>
		<ul  style=display:inline;>
			
			
			<li  type="button" class="btn btn-warning" style=display:inline;><a  style="text-decoration:none" href="index.jsp"> Home</a></li>
			 
			
			<li  type="button" class="btn btn-warning" style=display:inline;><a  style="text-decoration:none" href="altaUsuario.jsp"> Nuevo Usuario </a></li>
			<li  type="button" class="btn btn-warning" style=display:inline;><a  style="text-decoration:none" href="Logout"> Logout</a></li>

		</ul>
	</nav>
 <div class="collapse" id="navbarToggleExternalContent">
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                        aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarText">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
              <a class="nav-link" href="index.jsp">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="websAmigas.html">Webs Amigas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Protectoras.html">Protectoras</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ServletListaAnimales?tipo=todos">Mascotas En Adopcion</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="colaboradores.jsp">Colaboradores</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="HazteColaborador.jsp">Hazte Colaborador</a>
            </li>
                            

                        </ul>
                    </div>
                </div>
            </nav>
        </div>
         <nav class="navbar navbar-dark bg-dark" style="height: 45px;">
            <div class="container-sm">

                <button class="btn btn-dark position-absolute top-50 start-50 translate-middle" type="button"
                    data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent"
                    aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-chevron-down"></i>

                </button>
            </div>
        </nav>
        <h5 class="h4" style="position:relative; top:50px;">Lista de Usuarios</h5>
	<table class="table table-dark" style="position:relative; top:50px;">
	
	<tr>
		<th scope="col">UsuId</th>
		<th scope="col">UsuNombre</th>
		<th scope="col">UsuCiudad</th>
		<th scope="col">UsuTelf</th>
		<th scope="col">UsuDNI</th>
		<th scope="col">UsuMail</th>
		
			
			<th> Acciones </th>
			
			</tr>
			
		<% while(rs.next()){ %>
        <tr>
            <td><%= rs.getString("UsuId") %></td>
            <td><%= rs.getString("UsuNombre") %></td>
            <td><%= rs.getString("UsuCiudad") %></td>
            <td><%= rs.getString("UsuTelf") %></td>
            <td><%= rs.getString("UsuDNI") %></td>
            <td><%= rs.getString("UsuMail") %></td>
            
            <td><a href="Controlador?opcion=e&UsuId=<%=rs.getString("UsuId") %>"><i class="fa fa-edit" aria-hidden="false"></i></a>  <a href="Controlador?opcion=b&UsuId=<%=rs.getString("UsuId") %>"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
            
            
       
        </tr>
        <%} %>
        
        </table>
        
        <%
        rs.close();
        st.close();
        con.close();
        %>
 <footer class="bg-dark padding-max bg-cercle-verd" id="inicio">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 mb-0">
                        <h5 class="text-decoration-underline">Sobre Nosotros</h5>
                        <p>Somos un grupo de estudiantes de programación que se nos encomendó el proyecto final de hacer
                            una pagina
                            web y decidimos ponerlo al servicio del publico haciendo una pagina de adopción de animales.
                        </p>
                    </div>
                    <div class="col-md-3 mb-0">
                        <h5 class="text-decoration-underline">Colaboradores del Proyecto</h5>
                        <p>Radwane Abdessamie</p>
                        <p>Dimodena Bianca Leonela</p>
                        <p>Cano Garcia Miguel</p>
                        <p>Adriana de Paz Rovira</p>
                    </div>
                    <div class="col-md-3 mb-0">
                        <h5 class="text-decoration-underline">Contactanos</h5>
                        <p><a href="https://www.instagram.com/keepmypet/" style='text-decoration:none;color:white'><i id="contact" class="fab fa-instagram"></i>&nbsp;keepMyPet</a></p>
                        <p><i id="contact" class="fab fa-twitter"></i> &nbsp;@keepMyPetEspaña</p>
                        <p><i id="contact" class="fab fa-facebook-f"></i> &nbsp;keepMyPet</p>
                    </div>
                </div>
            </div>

        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

</body>
</html>