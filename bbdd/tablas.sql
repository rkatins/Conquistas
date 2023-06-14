-- create database Conquista;     --| Descomentar solo el principio en caso de que no este creada la base de datos
-- use Conquista;                 --| Descomentar solo el principio en caso de que no este creada la base de datos

drop table tblPaises;

create table tblPaises(
  id INT AUTO_INCREMENT,
  nombre VARCHAR(255),
  soldados INT,
  PRIMARY KEY (id)
);