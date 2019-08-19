--insert into sqlite_sequence(name,seq) values ("employed",1);
--insert into sqlite_sequence(name,seq) values ("product",1);
insert into hs_sequence(name,seq) values ("car",1);
insert into hs_sequence(name,seq) values ("car-item",1);

INSERT INTO employed (username,password,activo,rol) VALUES ('freddy','123456',true,3);
INSERT INTO employed (username,password,activo,rol) VALUES ('freddy2','123456',true,2);
INSERT INTO employed (username,password,activo,rol) VALUES ('freddy3','123456',true,2);
INSERT INTO employed (username,password,activo,rol) VALUES ('freddy4','123456',true,1);


INSERT INTO product (nombre,codigo,tipo,cantidad,valorUnidad) 
VALUES ('Camiseta','CAM001','MARV',20,5);
INSERT INTO product (nombre,codigo,tipo,cantidad,valorUnidad) 
VALUES ('Vaso spiderman','CAM002','MARV',5,5.5);
INSERT INTO product (nombre,codigo,tipo,cantidad,valorUnidad) 
VALUES ('Comic Hulk','CAM003','MARV',10,2.4);
INSERT INTO product (nombre,codigo,tipo,cantidad,valorUnidad) 
VALUES ('Batman Icon','CAM004','DCCOM',30,2.5);
INSERT INTO product (nombre,codigo,tipo,cantidad,valorUnidad) 
VALUES ('Gafas Spiderman','CAM005','MARV',20,10);
INSERT INTO product (nombre,codigo,tipo,cantidad,valorUnidad) 
VALUES ('Camiseta Batman','CAM006','DCCOM',4,18.50);