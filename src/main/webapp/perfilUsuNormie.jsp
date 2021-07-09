<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.eoi.servicios.conexion" %>
<%@ page import=" java.sql.*" %>
<%@ page import="com.eoi.modelo.Usuarios"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="css/estilos.css">
</head>

<body>

    <body>

        <header class="h1">Keep My Pet <i class="fas fa-paw"></i></header>
		<%
	Usuarios usu = (Usuarios)session.getAttribute("Usuario");

%>


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


        <img src="https://www.crushpixel.com/big-static18/preview4/avatar-profile-pink-neon-icon-2920285.jpg" class="img-thumbnail imgPerfil">

        <div class="card carta" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Sobre Mi</h5>
                <p>Nombre y Apellidos: <%=usu.getUsuNombre()%> - <%=usu.getUsuApellido()%> </p>
                <p>Email: <%=usu.getUsuMail()%></p>
                <p>Nº Telefono: <%=usu.getUsuTelf()%></p>
                <p>DNI: <%=usu.getUsuDNI()%></p>
            </div>
        </div>




		<%
		
		Connection con = conexion.getInstance().getConnection();
		String query = "SELECT * FROM animales where IdUsuario=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, usu.getUsuId());
		ResultSet rs=pst.executeQuery();
		
		%>
        <div class="card solicitudes" style="width: 26rem;">
            <div class="card-header">
              Solicitudes De Adopcion
            </div>
            <ul class="list-group list-group-flush">
              <%while(rs.next()) { %> 
              		<li class="list-group-item">Solicitud <%=rs.getString("AnimalNombre") %></li>
              <%} 
              rs.close();
              pst.close();
              con.close(); %>
            </ul>
          </div>

          <div class="card ofertas" style="width: 26rem;">
            <div class="card-header">
              Ofertas De Adopcion
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Oferta 1</li>
            </ul>
          </div>

          <div class="card quierenTuAnim" style="width: 26rem;">
            <div class="card-header">
              Gente Que Quiere Tu Animal
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Persona 1</li>
            </ul>
          </div>



        <footer class="bg-dark padding-max bg-cercle-verd" id="otros">
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
                    </div>
                    <div class="col-md-3 mb-0">
                        <h5 class="text-decoration-underline">Contactanos</h5>
                        <p><i id="contact" class="fab fa-instagram"></i>&nbsp;keepMyPetSocial</p>
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