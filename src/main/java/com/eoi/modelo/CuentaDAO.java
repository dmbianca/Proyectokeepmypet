package com.eoi.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eoi.servicios.conexion;
public class CuentaDAO {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public Usuarios login(String email, String pass) throws SQLException {
        Usuarios u = null;
        String sql = "SELECT * FROM usuarios where UsuMail = ? and UsuPass = ?";
        con = conexion.getInstance().getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, email);
        pst.setString(2, pass);

        rs = pst.executeQuery();

        if (rs.next()) {
            u = new Usuarios();
            u.setUsuMail(email);
            u.setUsuPass(pass);
            u.setUsuNombre(rs.getString("UsuNombre"));
            u.setUsuRol(rs.getString("Usurol"));
            u.setUsuApellido(rs.getString("UsuApellido"));
            u.setUsuMail(rs.getString("UsuMail"));
            u.setUsuTelf(rs.getInt("UsuTelf"));
            u.setUsuDNI(rs.getString("UsuDNI"));
            u.setUsuId(rs.getInt("UsuId"));

        }



        return u;
    }
}