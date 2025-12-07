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

    // --- NUEVO METODO PARA EL LOGIN ---
    public Usuario validar(String correo, String password) {
        Usuario us = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE correo=? AND password=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                us.setId(rs.getInt("id_usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setApellido(rs.getString("apellido"));
                us.setCorreo(rs.getString("correo"));
                us.setCelular(rs.getString("celular"));
                us.setId_cargo(rs.getInt("id_cargo"));
            }
        } catch (Exception e) {
            System.err.println("Error al validar: " + e);
        }
        return us;
    }

    // METODO PARA LISTAR (Actualizado con correo)
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        // Agregamos u.correo a la consulta
        String sql = "SELECT u.id_usuario, u.nombre, u.apellido, u.celular, u.correo, u.id_cargo, c.nombre_cargo " +
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
                us.setCorreo(rs.getString("correo")); // Traemos el correo
                us.setId_cargo(rs.getInt("id_cargo"));
                us.setNombre_cargo(rs.getString("nombre_cargo")); 
                list.add(us);
            }
        } catch (Exception e) {
            System.err.println("Error al listar: " + e);
        }
        return list;
    }

    // METODO PARA OBTENER UN SOLO USUARIO (Actualizado para editar)
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
                u.setCorreo(rs.getString("correo")); // Nuevo
                u.setPassword(rs.getString("password")); // Nuevo
                u.setId_cargo(rs.getInt("id_cargo"));
            }
        } catch (Exception e) {
            System.err.println("Error al buscar usuario: " + e);
        }
        return u;
    }

    // METODO AGREGAR (Actualizado: Ahora guarda correo y password)
    public boolean add(Usuario us) {
        String sql = "INSERT INTO usuarios(nombre, apellido, celular, correo, password, id_cargo) VALUES(?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getApellido());
            ps.setString(3, us.getCelular());
            ps.setString(4, us.getCorreo());    // Nuevo campo
            ps.setString(5, us.getPassword());  // Nuevo campo
            ps.setInt(6, us.getId_cargo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al agregar: " + e);
            return false;
        }
    }

    // METODO EDITAR (Actualizado: Ahora edita correo y password)
    public boolean edit(Usuario us) {
        String sql = "UPDATE usuarios SET nombre=?, apellido=?, celular=?, correo=?, password=?, id_cargo=? WHERE id_usuario=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getApellido());
            ps.setString(3, us.getCelular());
            ps.setString(4, us.getCorreo());    // Nuevo campo
            ps.setString(5, us.getPassword());  // Nuevo campo
            ps.setInt(6, us.getId_cargo());
            ps.setInt(7, us.getId()); // El ID va al final
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Error al editar: " + e);
            return false;
        }
    }

    // METODO ELIMINAR (No cambia)
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