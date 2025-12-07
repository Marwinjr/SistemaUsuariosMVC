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

USE proyecto_progra4;

-- Agregamos columnas para el Login
ALTER TABLE usuarios ADD correo VARCHAR(100) NOT NULL UNIQUE;
ALTER TABLE usuarios ADD password VARCHAR(50) NOT NULL;

ALTER TABLE usuarios ADD correo VARCHAR(100) NOT NULL UNIQUE;

-- ¡IMPORTANTE! Asignamos un usuario y clave a los registros que ya existen
-- para que no se queden en null y puedas entrar.
UPDATE usuarios SET correo = 'Marwingutierrezzz@gmail.com', password = '1234' WHERE id_usuario = 1;
-- Si tienes más usuarios, puedes actualizarlos o borrarlos y crearlos de nuevo.



USE proyecto_progra4;

-- 1. TABLA CLIENTES
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20) NOT NULL,
    nombres VARCHAR(100),
    direccion VARCHAR(100),
    estado VARCHAR(1) -- Para saber si está activo (1) o inactivo (0)
);

-- 2. TABLA PRODUCTOS
CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(100),
    precio DOUBLE,
    stock INT, -- Cantidad disponible
    estado VARCHAR(1)
);

-- 3. TABLA VENTAS (El Maestro / Encabezado)
CREATE TABLE ventas (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_usuario INT, -- El vendedor que hizo la venta
    numero_serie VARCHAR(20),
    fecha_venta DATE,
    monto DOUBLE,
    estado VARCHAR(1),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- 4. TABLA DETALLE DE VENTAS (El Detalle)
CREATE TABLE detalle_ventas (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT,
    id_producto INT,
    cantidad INT,
    precio_venta DOUBLE, -- Precio al momento de la venta
    FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);
