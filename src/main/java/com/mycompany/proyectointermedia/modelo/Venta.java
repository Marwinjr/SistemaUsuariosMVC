package com.mycompany.proyectointermedia.modelo;

public class Venta {
    int id;
    int idcliente;
    int idempleado;
    int idproducto;
    String Numserie;
    String descripcionP;
    String fecha;
    double precio;
    int cantidad;
    double subtotal;
    double monto;
    String estado;

    public Venta() {
    }

    public Venta(int id, int idcliente, int idempleado, int idproducto, String Numserie, String descripcionP, String fecha, double precio, int cantidad, double subtotal, double monto, String estado) {
        this.id = id;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.idproducto = idproducto;
        this.Numserie = Numserie;
        this.descripcionP = descripcionP;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.monto = monto;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdcliente() { return idcliente; }
    public void setIdcliente(int idcliente) { this.idcliente = idcliente; }
    public int getIdempleado() { return idempleado; }
    public void setIdempleado(int idempleado) { this.idempleado = idempleado; }
    public int getIdproducto() { return idproducto; }
    public void setIdproducto(int idproducto) { this.idproducto = idproducto; }
    public String getNumserie() { return Numserie; }
    public void setNumserie(String Numserie) { this.Numserie = Numserie; }
    public String getDescripcionP() { return descripcionP; }
    public void setDescripcionP(String descripcionP) { this.descripcionP = descripcionP; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}