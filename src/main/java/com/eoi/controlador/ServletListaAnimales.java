package com.eoi.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.eoi.modelo.DAO;
import com.eoi.modelo.Animales;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletListaAnimales")
public class ServletListaAnimales extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletListaAnimales() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO anim=new DAO();
        List<Animales> ListaAnimales = new ArrayList<Animales>();
        String tipo=request.getParameter("tipo");
        ListaAnimales=anim.SeleccionarAnimales(tipo);
        for(Animales ani:ListaAnimales)  {
        	System.out.println(ani.getAnimalPath());
        	System.out.println(ani.getAnimalNombre());
        
        }
        request.setAttribute("ListaAnimales",ListaAnimales);
        RequestDispatcher rd=request.getRequestDispatcher("MascotasEnAdopcion.jsp");
        rd.forward(request, response);

    }



}