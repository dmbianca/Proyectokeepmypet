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

import com.eoi.modelo.Usuarios;
import com.eoi.servicios.UsuarioServicio;


/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/htmlcharset=UTF-8");
        PrintWriter out = response.getWriter();
        
        boolean resultado = false;
        //Leer los parametros del formulario HTML
       
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
        //Creamos un objeto alumnoService
        UsuarioServicio usus = new UsuarioServicio();
        //Invocamos al metodo create del objeto usus pasandole el usuario
        try {
            resultado = usus.create(usu);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(resultado == true) {
            out.print("El usuario se ha insertado correctamente en la base de datos");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }else {
            out.print("El alta del usuario ha fallado");
        }
        
        System.out.println("Nombre: " + Nombre);
        System.out.println("Apellidos: " + Apellido);
        System.out.println("Fecha de Nacimiento: " + FechaNac);
        System.out.println("Correo: " + Correo);
        System.out.println("Password: " + Pass);
        System.out.println("Ciudad: " + Ciudad);
        System.out.println("DNI: " + Dni);
        System.out.println("Telefono: " + Telf);
        
    }

}