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
    clave VARCHAR(255) NOT NULL,usuario
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

CREATE TABLE Mesas (
    id_mesa BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_mesa BIGINT NOT NULL,
    capacidad DATE NOT NULL
);

CREATE TABLE Reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    cantidad_personas INT NOT NULL,
    id_mesa INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_mesa) REFERENCES Mesas(id_mesa)
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

INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Juan Pérez', 'juan.perez@exdample.com', 'clave123', 1, 'Calle Falsa 123', '5551-1234');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('María López', 'maria.lopez@exdample.com', 'clave123', 2, 'Avenida Siempre Viva 742', '555-51678');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Carlos García', 'carlos.garcia@exadmple.com', 'clave123', 3, 'Boulevard de los Sueños Rotos 456', '1555-8765');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Ana Martínez', 'ana.martinez@examplde.com', 'clave123', 1, 'Calle de la Amargura 789', '555-43251');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Luis Hernández', 'luis.hernandez@exadmple.com', 'clave123', 2, 'Avenida del Libertador 101', '5555-9101');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Sofía Fernández', 'sofia.fernandez@exadmple.com', 'clave123', 3, 'Calle del Pez 202', '555-11226');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Miguel Torres', 'miguel.torres@exampdle.com', 'clave123', 1, 'Calle del Sol 303', '555-33446');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Laura Ramírez', 'laura.ramirez@examdple.com', 'clave123', 2, 'Avenida del Mar 404', '555-556673');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('José Sánchez', 'jose.sanchez@examdple.com', 'clave123', 3, 'Boulevard de la Esperanza 505', '55551-7788');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Elena Díaz', 'elena.diaz@exampled.com', 'clave123', 1, 'Calle de las Flores 606', '555-995500');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Pedro Morales', 'pedro.morales@edxample.com', 'clave123', 2, 'Avenida del Sol 707', '5555-12355');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Lucía Ruiz', 'lucia.ruiz@exadmple.com', 'clave123', 3, 'Calle del Campo 808', '555-565579');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Diego Castillo', 'diego.castillo@exaddmple.com', 'clave123', 1, 'Boulevard de los Sauc5es 909', '55573-8766');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Gabriela Ortega', 'gabriela.ortega@exdample.com', 'clave123', 2, 'Calle del Río 010', '555-4383722');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Daniel Ramos', 'daniel.ramos@exdample.cdom', 'clave123', 3, 'Avenida de las Estrellas 121', '555-9157702');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Patricia Vargas', 'patricia.vargas@examdple.com', 'clave123', 1, 'Calle del Norte 232', '555-115423');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Alejandro Gómez', 'alejandro.gomez@examdple.com', 'clave123', 2, 'Avenida del Sur 343', '555-373345');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Isabel Castillo', 'isabel.castillo@examdple.com', 'clave123', 3, 'Calle de la Luna 454', '555-573567');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Francisco Mendoza', 'francisco.menddoza@example.com', 'clave123', 1, 'Boulevard del Sol 565', '55455-7789');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Raquel Soto', 'raquel.soto@exdample.com', 'clave123', 2, 'Calle de las Aves 676', '555-990731');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Javier Cruz', 'javier.cruz@exdample.com', 'clave123', 3, 'Avenida del Cielo 787', '555-1254336');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Natalia Ortiz', 'natalia.ortiz@edxample.com', 'clave123', 1, 'Calle del Amor 898', '555-567370');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Antonio Silva', 'antonio.silva@examdple.com', 'clave123', 2, 'Boulevard de los Poetas 909', '555-8573767');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Teresa Peña', 'teresa.pena@exampled.com', 'clave123', 3, 'Calle del Viento 010', '555-43753323');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Roberto Herrera', 'roberto.herrera@exadmple.com', 'clave123', 1, 'Avenida del Sol 121', '555-379103');

/*  Base de datos nueva!!!!*/
/*

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

CREATE TABLE Mesas (
    id_mesa INT AUTO_INCREMENT PRIMARY KEY,
    numero_mesa BIGINT NOT NULL,
    capacidad DATE NOT NULL
);

CREATE TABLE Reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    cantidad_personas INT NOT NULL,
    id_mesa INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_mesa) REFERENCES Mesas(id_mesa)
);



CREATE TABLE Factura(
	id_factura INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  fecha date,  
  total double,
  estado int,
  PRIMARY KEY (id_factura),
  foreign key fk_factura_usuario (id_usuario) references Usuarios(id_usuario) 

)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE Venta(
id_venta INT NOT NULL AUTO_INCREMENT,
  id_factura INT NOT NULL,
  id_producto INT NOT NULL,
  precio double, 
  cantidad int,
  PRIMARY KEY (id_venta),
  foreign key fk_ventas_factura (id_factura) references Factura(id_factura),
  foreign key fk_ventas_producto (id_producto) references Productos(id_producto) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Entrada', 'https://www.monumental.co.cr/wp-content/uploads/2024/03/CEVICHE-1-700x372.png');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Plato Fuerte', 'https://cdn7.kiwilimon.com/clasificacion/3675/3675.jpg');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Postres', 'https://www.la-cocina-mexicana.com/base/stock/Recipe/pastel-tres-leches/pastel-tres-leches_web.jpg.webp');
INSERT INTO Categorias (nombre, ruta_imagen) VALUES ('Bebidas', 'https://rejuvenatingspring.com/wp-content/uploads/2020/04/778d2c4e-5c40-436b-8962-0b8a4d531b48.png');


INSERT INTO Productos (nombre, descripcion, precio, id_categoria, ruta_imagen)
VALUES ('Ceviche de Pescado','Un delicioso ceviche de pescado, con ingredientes totalmente frescos y de origen nacional',3000,1,'https://www.monumental.co.cr/wp-content/uploads/2024/03/CEVICHE-1-700x372.png'),
('Yuca Frita','Palitos de Yuca Frita con una salsa BBQ',2500,1,'https://mojo.generalmills.com/api/public/content/dIC2MOZgzUy11gV3XUty4g_gmi_hi_res_jpeg.jpeg?v=1b8cbe0c&t=16e3ce250f244648bef28c5949fb99ff'),
('Platano Maduro','Platano maduro con queso para compartir en familia',2500,1,'https://www.tiosimonfoods.com/wp-content/uploads/2020/03/platano-2.jpg'),
('Dados de Queso','Dados de queso fritos con una salsa BBQ',2500,1,'https://ik.imagekit.io/autoenlinea/merrecetas/Dados%20de%20queso/2.jpg'),
('Hamburguesa EL CHE','Hamburguesa de la casa, con costilla, aros de cebolla, BBQ, bacon y una salsa especial',6000,2,'https://mcdonalds.com.sv/imagen/menu-products/1640815892_3.smoke%20tocino.jpg'),
('Lomo de Aguja','500g de lomo de aguja para compartir en familia',20000,2,'https://kitchenfair.com.mx/wp-content/uploads/2017/06/receta-lomo-aguja-grille1280x854.jpg'),
('Costillas BBQ','Una orden de 5 costillas BBQ',10000,2,'https://assets.unileversolutions.com/recipes-v2/247290.jpg'),
('Churrasco','Un bistec de churrasco con pure de papa y verduras',15000,2,'https://assets.unileversolutions.com/recipes-v2/252547.png'),
('Cheesecake de Limon','Un pedazo de cheesecake de limon, refrescante y delicioso',2500,3,'https://www.haceloconhuevos.com/wp-content/uploads/2022/02/Cheesecake-de-limón.jpg'),
('Cheesecake de Fresa','Un pedazo de cheesecake de fresa, refrescante y delicioso',2500,3,'https://www.splenda.com/wp-content/themes/bistrotheme/assets/recipe-images/strawberry-topped-cheesecake.jpg'),
('Pastel de Chocolate','Un pedazo de pastel de chocolate',3000,3,'https://www.recetasnestlecam.com/sites/default/files/srh_recipes/d8d96b13dcfa1e7432a6e3b033c5a3dc.jpg'),
('Tres Leches','Un pedazo de tres leches',3000,3,'https://www.la-cocina-mexicana.com/base/stock/Recipe/pastel-tres-leches/pastel-tres-leches_web.jpg.webp'),
('Fresco de Fresa Natural','Fresco natural de fresa, frio y refrescante',2100,4,'https://www.mamalatinatips.com/wp-content/uploads/2023/05/agua-fresa-7.jpg'),
('Coca Cola','Bebida gaseosa Coca Cola',2100,4,'https://img.freepik.com/foto-gratis/bebida-cola-fresca-vidrio_144627-16201.jpg'),
('Cerveza','Una cerveza de la marca que mas te guste',2000,4,'https://d100mj7v0l85u5.cloudfront.net/s3fs-public/glass-beer-1.jpg'),
('Limonada con Hierbabuena','Una Limonada con Hierbabuena, totalmente recomendada',4000,4,'https://rejuvenatingspring.com/wp-content/uploads/2020/04/778d2c4e-5c40-436b-8962-0b8a4d531b48.png');

INSERT INTO Roles (nombre) VALUES ('Administrador');
INSERT INTO Roles (nombre) VALUES ('Vendedor');
INSERT INTO Roles (nombre) VALUES ('Cliente');

INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Juan Pérez', 'juan.perez@exdample.com', 'clave123', 1, 'Calle Falsa 123', '5551-1234');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('María López', 'maria.lopez@exdample.com', 'clave123', 2, 'Avenida Siempre Viva 742', '555-51678');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Carlos García', 'carlos.garcia@exadmple.com', 'clave123', 3, 'Boulevard de los Sueños Rotos 456', '1555-8765');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Ana Martínez', 'ana.martinez@examplde.com', 'clave123', 1, 'Calle de la Amargura 789', '555-43251');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Luis Hernández', 'luis.hernandez@exadmple.com', 'clave123', 2, 'Avenida del Libertador 101', '5555-9101');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Sofía Fernández', 'sofia.fernandez@exadmple.com', 'clave123', 3, 'Calle del Pez 202', '555-11226');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Miguel Torres', 'miguel.torres@exampdle.com', 'clave123', 1, 'Calle del Sol 303', '555-33446');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Laura Ramírez', 'laura.ramirez@examdple.com', 'clave123', 2, 'Avenida del Mar 404', '555-556673');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('José Sánchez', 'jose.sanchez@examdple.com', 'clave123', 3, 'Boulevard de la Esperanza 505', '55551-7788');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Elena Díaz', 'elena.diaz@exampled.com', 'clave123', 1, 'Calle de las Flores 606', '555-995500');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Pedro Morales', 'pedro.morales@edxample.com', 'clave123', 2, 'Avenida del Sol 707', '5555-12355');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Lucía Ruiz', 'lucia.ruiz@exadmple.com', 'clave123', 3, 'Calle del Campo 808', '555-565579');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Diego Castillo', 'diego.castillo@exaddmple.com', 'clave123', 1, 'Boulevard de los Sauc5es 909', '55573-8766');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Gabriela Ortega', 'gabriela.ortega@exdample.com', 'clave123', 2, 'Calle del Río 010', '555-4383722');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Daniel Ramos', 'daniel.ramos@exdample.cdom', 'clave123', 3, 'Avenida de las Estrellas 121', '555-9157702');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Patricia Vargas', 'patricia.vargas@examdple.com', 'clave123', 1, 'Calle del Norte 232', '555-115423');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Alejandro Gómez', 'alejandro.gomez@examdple.com', 'clave123', 2, 'Avenida del Sur 343', '555-373345');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Isabel Castillo', 'isabel.castillo@examdple.com', 'clave123', 3, 'Calle de la Luna 454', '555-573567');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Francisco Mendoza', 'francisco.menddoza@example.com', 'clave123', 1, 'Boulevard del Sol 565', '55455-7789');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Raquel Soto', 'raquel.soto@exdample.com', 'clave123', 2, 'Calle de las Aves 676', '555-990731');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Javier Cruz', 'javier.cruz@exdample.com', 'clave123', 3, 'Avenida del Cielo 787', '555-1254336');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Natalia Ortiz', 'natalia.ortiz@edxample.com', 'clave123', 1, 'Calle del Amor 898', '555-567370');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Antonio Silva', 'antonio.silva@examdple.com', 'clave123', 2, 'Boulevard de los Poetas 909', '555-8573767');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Teresa Peña', 'teresa.pena@exampled.com', 'clave123', 3, 'Calle del Viento 010', '555-43753323');
INSERT INTO Usuarios (nombre, correo, clave, id_rol, direccion, telefono) VALUES ('Roberto Herrera', 'roberto.herrera@exadmple.com', 'clave123', 1, 'Avenida del Sol 121', '555-379103');
INSERT INTO Factura (id_factura,id_usuario,fecha,total,estado) VALUES
(1,1,'2022-01-05',211560,2),
(2,2,'2022-01-07',554340,2),
(3,3,'2022-01-07',871000,2),
(4,1,'2022-01-15',244140,1),
(5,2,'2022-01-17',414800,1),
(6,3,'2022-01-21',420000,1);

INSERT INTO Venta (id_venta,id_factura,id_producto,precio,cantidad) values
(1,1,5,45000,3),
(2,1,9,15780,2),
(3,1,10,15000,3),
(4,2,5,45000,1),
(5,2,14,154000,3),
(6,2,9,15780,3),
(7,3,14,154000,1),
(8,3,6,57000,1),
(9,3,15,330000,2),
(10,1,6,57000,2),
(11,1,8,27600,3),
(12,1,9,15780,3),
(13,2,8,27600,3),
(14,2,14,154000,2),
(15,2,3,24000,1),
(16,3,15,330000,1),
(17,3,12,45000,1),
(18,3,10,15000,3);



*/
