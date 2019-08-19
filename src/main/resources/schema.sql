DROP table hs_sequence;
DROP table employed;
DROP table product;
DROP table car;
DROP table car_item;
create table hs_sequence (name  VARCHAR(128),seq INTEGER NOT NULL, PRIMARY KEY (name));

CREATE TABLE employed (
    id   INTEGER      NOT NULL,
    username VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    activo BOOLEAN NOT NULL,
    rol INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product (
    id   INTEGER      NOT NULL,
    nombre VARCHAR(128) NOT NULL,
    codigo VARCHAR(128) NOT NULL,
    tipo VARCHAR(128) NOT NULL,
    cantidad INTEGER NOT NULL,
    valorUnidad DECIMAL NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE car (
    id   INTEGER      NOT NULL,
    numero VARCHAR(128),
    fechaIngreso DATE NOT NULL,
    fechaPago DATE,
    estado VARCHAR(128) NOT NULL,
    id_employed INTEGER,
    totalCompra DECIMAL,
    FOREIGN KEY(id_employed) REFERENCES employed(id)
);


CREATE TABLE car_item (
    id   INTEGER      NOT NULL,
    cantidad INTEGER NOT NULL,
    valorUnidad DECIMAL NOT NULL,
    id_car INTEGER,
    id_product INTEGER,
    PRIMARY KEY (id)
);