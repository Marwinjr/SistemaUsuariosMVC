package com.mycompany.proyectointermedia.dao;

import com.mycompany.proyectointermedia.config.Conexion;
import com.mycompany.proyectointermedia.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u = new Usuario();

    // METODO PARA LISTAR (Mostrar en tabla)
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        // Hacemos un JOIN para traer también el nombre del cargo
        String sql = "SELECT u.id_usuario, u.nombre, u.apellido, u.celular, u.id_cargo, c.nombre_cargo " +
                     "FROM usuarios u INNER JOIN cargos c ON u.id_cargo = c.id_cargo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId(rs.getInt("id_usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setCelular(rs.getString("celular"));
                us.setId_cargo(rs.getInt("id_cargo"));
                us.setNombre_cargo(rs.getString("nombre_cargo")); // Para mostrar el nombre del cargo
                list.add(us);
            }
        } catch (Exception e) {
            System.err.println("Error al listar: " + e);
        }
        return list;
    }

    // METODO PARA OBTENER UN SOLO USUARIO (Para Editar)
    public Usuario list(int id) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setCelular(rs.getString("celular"));
                u.setId_cargo(rs.getInt("id_cargo"));
            }
        } catch (Exception e) {
            System.err.println("Error al buscar usuario: " + e);
        }
        return u;
    }

    // METODO AGREGAR
    public boolean add(Usuario us) {
        String sql = "INSERT INTO usuarios(nombre, apellido, celular, id_cargo) VALUES(?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getApellido());
            ps.setString(3, us.getCelular());
            ps.setInt(4, us.getId_cargo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al agregar: " + e);
            return false;
        }
    }

    // METODO EDITAR
    public boolean edit(Usuario us) {
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, celular=?, id_cargo=? WHERE id_usuario=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getApellido());
            ps.setString(3, us.getCelular());
            ps.setInt(4, us.getId_cargo());
            ps.setInt(5, us.getId()); // El ID va al final en el WHERE
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al editar: " + e);
            return false;
        }
    }

    // METODO ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id_usuario=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar: " + e);
            return false;
        }
    }
}