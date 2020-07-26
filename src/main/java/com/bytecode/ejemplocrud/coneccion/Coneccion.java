/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.ejemplocrud.coneccion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rsaldana
 */
public class Coneccion {
    // Creamo un objeto llamado conexion quien me instancia la clase.
    public static Coneccion conexion = new Coneccion();
    
    static String db = "usuers";
    static String usuario = "postgres";
    static String pass = "rsaldanar";
    static String host = "localhost:5434/";
    static String url = "jdbc:postgresql://"+ host + db;
    
    private static Coneccion instacia = null;
    
    
    public static Coneccion getInstancia(){
        if(instacia==null){
            instacia = new Coneccion();
        }
        return instacia;
    }
    
    public Coneccion(){
        
    }
    
    public static Connection getConeccion(){
        try {
            Connection con = DriverManager.getConnection(url,usuario,pass);
            return con;
        } catch (Exception e) {
            
        }
        return null;
    }
    
    
}
