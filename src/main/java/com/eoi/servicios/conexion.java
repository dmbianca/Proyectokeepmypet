package com.eoi.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {

    private static conexion instancia;
    private Connection connection;
    //Local
    //String url = "jdbc:mysql://localhost:3306/keepmypet?serverTimezone=UTC";
    //String username = "root";
	//String password = "1234";
    
    
    //Base de datos db4free
    String url = "jdbc:mysql://db4free.net/keepmypet?serverTimezone=UTC";
    String username = "keepmypet";
	String password = "keepmypet";
    
    
 

    private conexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Conexion a BD incorrecta : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static conexion getInstance() throws SQLException {
        if (instancia == null) {
            instancia = new conexion();
        } else if (instancia.getConnection().isClosed()) {
            instancia = new conexion();
        }

        return instancia;
    }
}	

