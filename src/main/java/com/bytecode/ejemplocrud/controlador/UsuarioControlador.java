/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.ejemplocrud.controlador;

import com.bytecode.ejemplocrud.modelo.Usuario;
import com.bytecode.ejemplocrud.coneccion.Coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rsaldana
 */
public class UsuarioControlador {

    private static final UsuarioControlador INSTANCIA = new UsuarioControlador();
    private static UsuarioControlador INSTANCIA_UNICA = null;

    public UsuarioControlador() {

    }

    public static UsuarioControlador getInstancia() {
        return INSTANCIA;
    }

    public static UsuarioControlador getInstanciaControlador() {
        if (INSTANCIA_UNICA == null) {
            INSTANCIA_UNICA = new UsuarioControlador();
        }
        return INSTANCIA_UNICA;
    }

    // Crear Metodo para Salvar en la BD por medio a MVC
    public boolean Salvar(Usuario usuario) throws SQLException {
        String sqlInsert = "INSERT INTO usuario(nombre, apellido, estado)VALUES ( ?, ?, true)";
        boolean datoSalvado = true;
        try (Connection con = Coneccion.getInstancia().getConeccion()){
            try(PreparedStatement stmt = con.prepareStatement(sqlInsert)){
                stmt.setString(1, usuario.getNombre());
                stmt.setString(2, usuario.getApellido());
                
                stmt.executeUpdate();
            }
            
        } catch (Exception e) {
            datoSalvado = false;
            Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE,e.getMessage());
        }
        return datoSalvado;
    }
}
