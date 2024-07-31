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
    correo VARCHAR(100) NOT NULL unique,
    clave VARCHAR(255) NOT NULL,
    id_rol INT,
	direccion VARCHAR(255) DEFAULT 'Dirección no especificada',
    telefono VARCHAR(20) NOT NULL unique,
    FOREIGN KEY (id_rol) REFERENCES Roles(id_rol)
);


CREATE TABLE Categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    ruta_imagen VARCHAR(1024)
);


CREATE TABLE Productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(180),
    precio DECIMAL(10,2) NOT NULL,
    id_categoria INT,
    ruta_imagen VARCHAR(1024),
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

INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Prueba 1', 'https://hips.hearstapps.com/hmg-prod/images/salmon-con-trigueros-y-judias-1562929760.jpg?crop=1.00xw:0.335xh;0,0.377xh&resize=1200:*');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Prueba 2', 'https://cdn7.kiwilimon.com/clasificacion/3675/3675.jpg');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Prueba 3', 'https://hips.hearstapps.com/hmg-prod/images/salmon-con-trigueros-y-judias-1562929760.jpg?crop=1.00xw:0.335xh;0,0.377xh&resize=1200:*');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Prueba 4', 'https://cdn7.kiwilimon.com/clasificacion/3675/3675.jpg');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Prueba 5', 'https://hips.hearstapps.com/hmg-prod/images/salmon-con-trigueros-y-judias-1562929760.jpg?crop=1.00xw:0.335xh;0,0.377xh&resize=1200:*');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Prueba 6', 'https://cdn7.kiwilimon.com/clasificacion/3675/3675.jpg');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Prueba 7', 'https://cdn7.kiwilimon.com/clasificacion/3675/3675.jpg');

INSERT INTO Productos (nombre, descripcion, precio, id_categoria, ruta_imagen)
VALUES ('Producto 1', 'Descripción del Producto 1', 19.99, 1, 'https://cdn7.kiwilimon.com/clasificacion/3675/3675.jpg'),
       ('Producto 2', 'Descripción del Producto 2', 24.99, 2, 'https://resizer.glanacion.com/resizer/v2/parrillada-completa-BCMNCK4U35CBNHAHVLKS3S2R5Y.jpg?auth=9a156e897b2f058181cf11dcf105762dc445b59640712d42824718870f2f897f&width=768&height=512&quality=70&smart=true'),
       ('Producto 3', 'Descripción del Producto 3', 15.50, 1, 'https://cdn7.kiwilimon.com/clasificacion/3675/3675.jpg'),
       ('Producto 4', 'Descripción del Producto 4', 29.99, 3, 'https://hips.hearstapps.com/hmg-prod/images/salmon-con-trigueros-y-judias-1562929760.jpg?crop=1.00xw:0.335xh;0,0.377xh&resize=1200:*'),
       ('Producto 5', 'Descripción del Producto 5', 12.75, 2, 'https://resizer.glanacion.com/resizer/v2/parrillada-completa-BCMNCK4U35CBNHAHVLKS3S2R5Y.jpg?auth=9a156e897b2f058181cf11dcf105762dc445b59640712d42824718870f2f897f&width=768&height=512&quality=70&smart=true'),
       ('Producto 6', 'Descripción del Producto 6', 18.00, 3, 'https://hips.hearstapps.com/hmg-prod/images/salmon-con-trigueros-y-judias-1562929760.jpg?crop=1.00xw:0.335xh;0,0.377xh&resize=1200:*'),
       ('Producto 7', 'Descripción del Producto 7', 22.50, 1, 'https://hips.hearstapps.com/hmg-prod/images/salmon-con-trigueros-y-judias-1562929760.jpg?crop=1.00xw:0.335xh;0,0.377xh&resize=1200:*');

