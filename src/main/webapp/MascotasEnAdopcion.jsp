<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="com.eoi.modelo.Animales" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mascotas En Adopcion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="css/estilos.css">
    
    <script src="script/jquery-3.6.0.js"></script>
    <script src="script/script.js"></script>
</head>

<body>
   <%
   List<Animales> ListaAnimales= new ArrayList<Animales>();
   ListaAnimales=(List<Animales>) request.getAttribute("ListaAnimales");
   //HttpSession session = request.getSession();
   
   session.setAttribute("ListaAnim",ListaAnimales);
   %>
 
    <header class="h1" ><a href="index.jsp" style='text-decoration:none;color:black'>Keep My Pet <i class="fas fa-paw"></a></i></header>



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
              <a class="nav-link active" aria-current="page" href="ServletListaAnimales?tipo=todos">Mascotas En Adopcion</a>
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

    <div class="wrap">
        <h1>Filtra Aqui</h1>
        <div class="store-wrapper">
            <div class="category_list">
                <a href="ServletListaAnimales?tipo=todos" class="category_item btn btn-secondary" category="todos">Todos</a>
                <a href="ServletListaAnimales?tipo=perros" class="category_item btn btn-secondary" category="perros">Perros</a>
                <a href="ServletListaAnimales?tipo=gatos" class="category_item btn btn-secondary" category="gatos">Gatos</a>
                <a href="ServletListaAnimales?tipo=otros" class="category_item btn btn-secondary" category="otros">Otros</a>
            </div>
        </div>
    </div>

    <div class="container cardpad">
        <div class="row product-list">
<%for (Animales ani:ListaAnimales){ %>
            <div class="col-sm-3 mb-0 product-item" category="perros" style="margin: 10px;">
                <div class="card fondoanim " style="width: 18rem;">
                    <img src=<%=ani.getAnimalPath() %> class="card-img-top" alt="..." style="padding: 11px;">
                    <div class="card-body">
                        <h5 class="h5"><%= ani.getAnimalNombre() %></h5>

                        <a href="descAnimal.jsp?AnimalId=<%=ani.getAnimalId() %>" class="btn btn-primary">Mas Info</a>
                    </div>

                </div>
            </div>
             <%} %>   
		</div>
	</div>
       



    <footer class="bg-dark padding-max bg-cercle-verd" id="otros">
        <div class="container">
            <div class="row">
                <div class="col-md-3 mb-0">
                    <h5 class="text-decoration-underline">Sobre Nosotros</h5>
                    <p>Somos un grupo de estudiantes de programación que se nos encomendó el proyecto final de hacer una
                        pagina web y decidimos ponerlo al servicio del publico haciendo una pagina de adopción de
                        animales.</p>
                </div>
                <div class="col-md-3 mb-0">
                    <h5 class="text-decoration-underline">Colaboradores del Proyecto</h5>
                    <p>Radwane Abdessamie</p>
                    <p>Dimodena Bianca Leonela</p>
                    <p>Cano Garcia Miguel</p>
                </div>
                <div class="col-md-3 mb-0">
                    <h5 class="text-decoration-underline">Contactanos</h5>
                    <p><a href="https://www.instagram.com/keepmypet/" style='text-decoration:none;color:white'><i id="contact" class="fab fa-instagram"></i>&nbsp;keepMyPetSocial</a></p>
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