package com.mycompany.proyectointermedia.dao;

import com.mycompany.proyectointermedia.config.Conexion;
import com.mycompany.proyectointermedia.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    // Obtener el número de serie (Id de venta) para mostrarlo
    public String GenerarSerie(){
        String numeroSerie="";
        String sql="select max(id_venta) from ventas";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                numeroSerie=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroSerie;
    }
    
    // Guardar la cabecera de la venta
    public int GuardarVenta(Venta v){
        String sql="INSERT INTO ventas(id_cliente, id_usuario, numero_serie, fecha_venta, monto, estado) VALUES (?,?,?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, v.getIdcliente());
            ps.setInt(2, v.getIdempleado());
            ps.setString(3, v.getNumserie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getPrecio());
            ps.setString(6, v.getEstado());
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    // Guardar el detalle (Productos de la venta)
    public int GuardarDetalleVentas(Venta v){
        String sql="INSERT INTO detalle_ventas(id_venta, id_producto, cantidad, precio_venta) VALUES (?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setInt(2, v.getIdproducto());
            ps.setInt(3, v.getCantidad());
            ps.setDouble(4, v.getPrecio());
            r=ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}