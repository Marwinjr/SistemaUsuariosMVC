package com.mycompany.proyectointermedia.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    // Verifica que el nombre de la BD sea exactamente el que creaste en Workbench
    String url = "jdbc:mysql://localhost:3306/proyecto_progra4"; 
    String user = "root";
    // ⚠️ OJO: Si en tu MySQL no usas contraseña, deja las comillas vacías: ""
    String pass = ""; 

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e);
        }
        return con;
    }
}