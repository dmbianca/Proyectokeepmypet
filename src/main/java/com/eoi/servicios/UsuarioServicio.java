package com.eoi.servicios;


import java.sql.SQLException;

import com.eoi.modelo.UsuarioDAO;
import com.eoi.modelo.Usuarios;

public class UsuarioServicio {
    UsuarioDAO repository;

    public UsuarioServicio() {
        this.repository = new UsuarioDAO();
    }
    public boolean create(Usuarios u) throws SQLException {
        return repository.create(u);
    }
}