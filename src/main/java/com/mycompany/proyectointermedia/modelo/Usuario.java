package com.mycompany.proyectointermedia.modelo;

public class Usuario {
    int id;
    String nombre;
    String apellido;
    String celular;
    int id_cargo; // Para relacionarlo con la tabla Cargo
    String nombre_cargo; // Auxiliar para mostrar el nombre del cargo en la tabla
    String correo;
    String password;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String celular, int id_cargo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.id_cargo = id_cargo;
    }

    // --- GETTERS Y SETTERS ---
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    // --- NUEVOS GETTERS Y SETTERS PARA CORREO Y PASSWORD ---
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}