package com.mycompany.proyectointermedia.dao;

import com.mycompany.proyectointermedia.config.Conexion;
import com.mycompany.proyectointermedia.modelo.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        ArrayList<Cargo> list = new ArrayList<>();
        String sql = "SELECT * FROM cargos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cargo c = new Cargo();
                c.setId(rs.getInt("id_cargo"));
                c.setNombre(rs.getString("nombre_cargo"));
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
}