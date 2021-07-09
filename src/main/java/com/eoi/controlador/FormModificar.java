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

import com.eoi.modelo.UsuarioDAO;
import com.eoi.modelo.Usuarios;

@WebServlet("/FormModificar")
public class FormModificar extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		 //System.out.println(request.getAttribute("UserId"));
		 //System.out.println(session.getAttribute("UsuId"));
	       // Usuarios usu2 = (Usuarios)request.getAttribute("User");
	        //System.out.println(usu2.getUsuId());
	        
	        boolean resultado = false;
	        //Leer los parametros del formulario HTML
	       String id = request.getParameter("userid");
	        int idNum = Integer.parseInt(id);
	       System.out.println("El id es " +id);
	        String Nombre = request.getParameter("UsuNombre");
	        String Apellido = request.getParameter("UsuApellido");
	        String FechaNac = request.getParameter("UsuNacimiento");
	        
	        String Correo = request.getParameter("UsuMail");
	        String Pass = request.getParameter("UsuPass");
	        
	        String Ciudad = request.getParameter("UsuCiudad");
	        String Dni = request.getParameter("UsuDNI");
	        int Telf = Integer.parseInt(request.getParameter("UsuTelf"));
	        
	        //Creamos el objeto usuario con los datos recuperados del formulario
	        Usuarios usu = new Usuarios(Nombre, Apellido, FechaNac, Correo, Pass,  Ciudad, Dni, Telf);
	        usu.setUsuId(idNum);
	        UsuarioDAO usuario = new UsuarioDAO();
	        try {
				usuario.ModificaUsuario(usu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        RequestDispatcher rd=request.getRequestDispatcher("perfilUsu.jsp");
	        rd.forward(request, response);
	}

}
