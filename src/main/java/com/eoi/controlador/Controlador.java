package com.eoi.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eoi.modelo.Usuarios;



import com.eoi.modelo.Animales;
import com.eoi.modelo.DAO;
import com.eoi.modelo.UsuarioDAO;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
        String opcion = request.getParameter("opcion");
        String UsuId = request.getParameter("UsuId");
        int UsuIdNum = Integer.parseInt(UsuId);
        DAO usudao = new DAO();
        UsuarioDAO udao = new UsuarioDAO();

        Usuarios usu = null;
        String destino = "index.jsp";


        switch (opcion) {
        case "e":
        	destino = "ModificarUsuario.jsp";
        	try {
				usu = udao.seleccionarUsuarios(UsuIdNum);
				usu.setUsuId(UsuIdNum);
				request.setAttribute("User",usu);
				System.out.println(usu.toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	session.setAttribute(UsuId, "UsuId");
        	
        	break;
        case "b":
        	System.out.println("entro a borrar");
        	destino = "perfilUsu.jsp";
        	try {
        		udao.BorraUsuario(UsuIdNum);
        	} catch (SQLException e) {
                e.printStackTrace();
            }

            break;
        
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");
        String AnimalNombre = request.getParameter("AnimalNombre");
        String AnimalEdad = request.getParameter("AnimalEdad");
        String AnimalTipo = request.getParameter("AnimalTipo");
        int AnimalId = Integer.parseInt(request.getParameter("AnimalId"));
        String AnimalRaza = request.getParameter("AnimalRaza");
        String AnimalSexo = request.getParameter("AnimalSexo");
        
        String AnimalAlta = request.getParameter("AnimalAlta");
        
        String AnimalPath = request.getParameter("AnimalPath");
        String AnimalCiudad = request.getParameter("AnimalCiudad");
        
        String AnimalEstado = request.getParameter("AnimalEstado");

        Animales ani = new Animales(AnimalNombre, AnimalEdad, AnimalTipo, AnimalId, AnimalRaza, AnimalSexo, AnimalAlta, AnimalPath, AnimalCiudad,  AnimalEstado);
        DAO UsuDao = new DAO();

        String destino = "index.jsp";

        try {
            if (opcion.equals("e")) {
            }
                UsuDao.ModificarAnimal(ani);
            if (opcion.equals("a")) {
                UsuDao.AltaAnimal(ani);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }

}