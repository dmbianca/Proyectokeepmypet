package com.eoi.modelo;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
import java.sql.Statement;

import com.eoi.servicios.conexion;


    public class UsuarioDAO {
        
        Connection con;
        PreparedStatement pst;
        
        
        //seleccionamos todos los usuarios
        public Usuarios seleccionarUsuarios(int UsuId) throws SQLException {
            Connection con = conexion.getInstance().getConnection();
            String sql="SELECT * FROM usuarios WHERE UsuId=?";
            Usuarios usu = null;
            
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setInt(1, UsuId);
            ResultSet rs= pst.executeQuery();
            
            while(rs.next()) {
            	usu = new Usuarios(rs.getString("UsuNombre"),rs.getString("UsuApellido"),rs.getString("UsuNacimiento"),rs.getString("UsuMail"),rs.getString("UsuPass"),rs.getString("UsuCiudad"),rs.getString("UsuDNI"),rs.getInt("UsuTelf"));
            	
            }
            rs.close();
            pst.close();
            con.close();
            
            return usu;
        }
        //borramos un usuario
        public void BorraUsuario(int UsuId) throws SQLException {
        	
        	String sql = "DELETE FROM usuarios WHERE UsuId=?";
        	System.out.println(sql);
            con= conexion.getInstance().getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1, UsuId);
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        //vamos a modificar un usuario
        public void ModificaUsuario (Usuarios u) throws SQLException {
            String sql = "UPDATE usuarios SET UsuNombre=?,UsuApellido=?,UsuNacimiento=?,UsuAlta=?,UsuMail=?,UsuPass=?,UsuRol=?,UsuCiudad=?,UsuDNI=? WHERE UsuId=?";
            con= conexion.getInstance().getConnection();
            pst=con.prepareStatement(sql);
            pst.setString(1,u.getUsuNombre());
            pst.setString(2,u.getUsuApellido());
            pst.setString(3,u.getUsuNacimiento());
            pst.setInt(4,u.getUsuAlta());
            pst.setString(5,u.getUsuMail());
            pst.setString(6,u.getUsuPass());
            pst.setString(7,u.getUsuRol());
            pst.setString(8,u.getUsuCiudad());
            pst.setString(9,u.getUsuDNI());
            pst.setInt(10,u.getUsuId());
            
            pst.executeUpdate();
            pst.close();
            con.close();
        }
        
        public boolean create(Usuarios u) throws SQLException {
            String insertQuery = "INSERT INTO usuarios(UsuNombre, UsuApellido, UsuNacimiento,UsuMail, UsuPass,  UsuCiudad,  UsuDNI, UsuTelf) VALUES(?,?,?,?,?,?,?,?)";
            Connection con = conexion.getInstance().getConnection();
            //con = conexion.getInstance().getConnection();
           // Connection con = null;
            PreparedStatement pst = null;
            int rows = 0;

            // Creamos la conexion
            try {
                
                pst = con.prepareStatement(insertQuery);
                pst.setString(1, u.getUsuNombre());
                pst.setString(2, u.getUsuApellido());
                pst.setString(3, u.getUsuNacimiento());
                pst.setString(4, u.getUsuMail());
                pst.setString(5, u.getUsuPass());
                pst.setString(6, u.getUsuCiudad());
                pst.setString(7, u.getUsuDNI());
                pst.setInt(8, u.getUsuTelf());
               
                
                

                System.out.println("ejecutando la query +" + insertQuery);
                rows = pst.executeUpdate();
                System.out.println("Registros insertados: " + rows);
                pst.close();
                con.close();
                return true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
        }

