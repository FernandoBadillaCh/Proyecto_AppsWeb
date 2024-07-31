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

INSERT INTO Roles (nombre) VALUES ('Administrador');
INSERT INTO Roles (nombre) VALUES ('Vendedor');
INSERT INTO Roles (nombre) VALUES ('Cliente');

INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Juan Pérez', 'juan.perez@example.com', 'clave123', 1, 'Calle Falsa 123', '555-1234');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('María López', 'maria.lopez@example.com', 'clave123', 2, 'Avenida Siempre Viva 742', '555-5678');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Carlos García', 'carlos.garcia@example.com', 'clave123', 3, 'Boulevard de los Sueños Rotos 456', '555-8765');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Ana Martínez', 'ana.martinez@example.com', 'clave123', 1, 'Calle de la Amargura 789', '555-4321');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Luis Hernández', 'luis.hernandez@example.com', 'clave123', 2, 'Avenida del Libertador 101', '555-9101');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Sofía Fernández', 'sofia.fernandez@example.com', 'clave123', 3, 'Calle del Pez 202', '555-1122');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Miguel Torres', 'miguel.torres@example.com', 'clave123', 1, 'Calle del Sol 303', '555-3344');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Laura Ramírez', 'laura.ramirez@example.com', 'clave123', 2, 'Avenida del Mar 404', '555-5566');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('José Sánchez', 'jose.sanchez@example.com', 'clave123', 3, 'Boulevard de la Esperanza 505', '555-7788');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Elena Díaz', 'elena.diaz@example.com', 'clave123', 1, 'Calle de las Flores 606', '555-9900');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Pedro Morales', 'pedro.morales@example.com', 'clave123', 2, 'Avenida del Sol 707', '555-1235');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Lucía Ruiz', 'lucia.ruiz@example.com', 'clave123', 3, 'Calle del Campo 808', '555-5679');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Diego Castillo', 'diego.castillo@example.com', 'clave123', 1, 'Boulevard de los Sauces 909', '555-8766');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Gabriela Ortega', 'gabriela.ortega@example.com', 'clave123', 2, 'Calle del Río 010', '555-4322');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Daniel Ramos', 'daniel.ramos@example.com', 'clave123', 3, 'Avenida de las Estrellas 121', '555-9102');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Patricia Vargas', 'patricia.vargas@example.com', 'clave123', 1, 'Calle del Norte 232', '555-1123');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Alejandro Gómez', 'alejandro.gomez@example.com', 'clave123', 2, 'Avenida del Sur 343', '555-3345');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Isabel Castillo', 'isabel.castillo@example.com', 'clave123', 3, 'Calle de la Luna 454', '555-5567');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Francisco Mendoza', 'francisco.mendoza@example.com', 'clave123', 1, 'Boulevard del Sol 565', '555-7789');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Raquel Soto', 'raquel.soto@example.com', 'clave123', 2, 'Calle de las Aves 676', '555-9901');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Javier Cruz', 'javier.cruz@example.com', 'clave123', 3, 'Avenida del Cielo 787', '555-1236');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Natalia Ortiz', 'natalia.ortiz@example.com', 'clave123', 1, 'Calle del Amor 898', '555-5670');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Antonio Silva', 'antonio.silva@example.com', 'clave123', 2, 'Boulevard de los Poetas 909', '555-8767');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Teresa Peña', 'teresa.pena@example.com', 'clave123', 3, 'Calle del Viento 010', '555-4323');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Roberto Herrera', 'roberto.herrera@example.com', 'clave123', 1, 'Avenida del Sol 121', '555-9103');

