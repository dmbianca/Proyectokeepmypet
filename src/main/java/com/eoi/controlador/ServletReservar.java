package com.eoi.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eoi.modelo.DAO;
import com.eoi.modelo.Usuarios;

/**
 * Servlet implementation class AdoptarServlet
 */
@WebServlet("/ServletReservar")
public class ServletReservar extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  response.setContentType("text/htmlcharset=UTF-8");
        PrintWriter out = response.getWriter();

        boolean resultado = false;
        //Leer los parametros del formulario HTML


        int id = Integer.parseInt(request.getParameter("UsuId"));
        String Nombre = request.getParameter("UsuNombre");
        String Apellido = request.getParameter("UsuApellido");
        String FechaNac = request.getParameter("UsuNacimiento");
        String Ciudad = request.getParameter("UsuCiudad");
        String Dni = request.getParameter("UsuDNI");
        String Correo = request.getParameter("UsuMail");
        int Telf = Integer.parseInt(request.getParameter("Usutelf"));

      //Creamos el objeto usuario con los datos recuperados del formulario
        Usuarios usu = new Usuarios(id, Nombre, Apellido, FechaNac,  Ciudad, Dni, Correo,Telf);
        */
    	DAO animaldao = new DAO();
        HttpSession session = request.getSession(); 
        int animalid = Integer.parseInt(request.getParameter("AnimalId"));
        
        Usuarios usu = (Usuarios)session.getAttribute("Usuario");
        System.out.println(usu.getUsuId());
        try {
			animaldao.ReservaAnimal(usu.getUsuId(), animalid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        RequestDispatcher rd=request.getRequestDispatcher("perfilUsuNormie.jsp");

        rd.forward(request, response);
        
}
}

