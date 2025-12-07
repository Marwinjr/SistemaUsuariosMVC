package com.mycompany.proyectointermedia.dao;

import com.mycompany.proyectointermedia.config.Conexion;
import com.mycompany.proyectointermedia.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    // LISTAR
    public List listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    // AGREGAR
    public int agregar(Producto p) {
        int r = 0;
        String sql = "INSERT INTO productos(nombres, precio, stock, estado) VALUES(?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            r = ps.executeUpdate();
        } catch (Exception e) {
            // ¡ESTA LÍNEA ES VITAL! Nos dirá el error en la ventana "Output" de NetBeans
            System.err.println("ERROR AL AGREGAR: " + e.getMessage());
            e.printStackTrace();
        }
        return r;
    }
    
    // BUSCAR POR ID (Para editar)
    public Producto listarId(int id) {
        Producto p = new Producto();
        String sql = "SELECT * FROM productos WHERE id_producto=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    // ACTUALIZAR
    public int actualizar(Producto p) {
        int r = 0;
        String sql = "UPDATE productos SET nombres=?, precio=?, stock=?, estado=? WHERE id_producto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getId());
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    // ELIMINAR
    public void delete(int id) {
        String sql = "DELETE FROM productos WHERE id_producto=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}