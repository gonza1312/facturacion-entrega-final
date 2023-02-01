CREATE TABLE CLIENTE(
	cliente_id INT AUTO_INCREMENT,
	dni INT,
	nombre VARCHAR(255),
	apellido VARCHAR(255),
	PRIMARY KEY (cliente_id)
);

CREATE TABLE VENTA(
	venta_id INT AUTO_INCREMENT,
	PRIMARY KEY (venta_id)
);

CREATE TABLE PRODUCTO(
	producto_id INT AUTO_INCREMENT,
	codigo INT,
	descripcion VARCHAR(255),
    cantidad INT,
	precio FLOAT,
	PRIMARY KEY (producto_id)
);