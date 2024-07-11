DROP SCHEMA IF EXISTS proyecto_appsweb;
DROP USER IF EXISTS usuario_proyecto;

CREATE SCHEMA proyecto_appsweb;
CREATE USER 'usuario_proyecto'@'%' IDENTIFIED BY 'Clave_Usuario1.';
GRANT ALL PRIVILEGES ON proyecto_appsweb.* TO 'usuario_proyecto'@'%';
FLUSH PRIVILEGES;

USE proyecto_appsweb;

CREATE TABLE Roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    clave VARCHAR(255) NOT NULL,
    id_rol INT,
    FOREIGN KEY (id_rol) REFERENCES Roles(id_rol)
);


CREATE TABLE Categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE Productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(180),
    precio DECIMAL(10,2) NOT NULL,
    id_categoria INT,
    ruta_imagen VARCHAR(255),
    FOREIGN KEY (id_categoria) REFERENCES Categorias(id_categoria)
);


CREATE TABLE Reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    cantidad_personas INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
);


DROP TABLE IF EXISTS Reservas;
DROP TABLE IF EXISTS Productos;
DROP TABLE IF EXISTS Categorias;
DROP TABLE IF EXISTS Usuarios;
DROP TABLE IF EXISTS Roles;
