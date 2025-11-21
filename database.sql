CREATE DATABASE proyecto_progra4;

USE proyecto_progra4;

CREATE TABLE cargos (
    id_cargo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cargo VARCHAR(50) NOT NULL
);

INSERT INTO cargos (nombre_cargo) VALUES ('Administrador'), ('Vendedor'), ('Cajero');

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    celular VARCHAR(15),
    id_cargo INT,
    FOREIGN KEY (id_cargo) REFERENCES cargos(id_cargo)
);