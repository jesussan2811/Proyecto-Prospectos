CREATE DATABASE PRUEBA

USE PRUEBA

CREATE TABLE PROSPECTOS(
ID int not null auto_increment,
Nombre varchar(25) not null,
ApellidoPat varchar(15) not null,
ApellidoMat varchar(15),
Calle varchar(25) not null,
NoCasa varchar(4) not null,
Colonia varchar(25) not null,
CP varchar(5) not null,
Telefono varchar(10) not null,
RFC varchar(13) not null,
Estatus varchar(10) not null,
Observaciones varchar(50),
primary key(ID)
)


Insert into PROSPECTOS(Nombre,ApellidoPat,ApellidoMat,Calle,NoCasa,Colonia,CP,Telefono,RFC,Estatus)
values("Jesus","Sanchez","Guzman","Guillermo Prieto","1210","El Vallado","80110", "6677475067","SAGJ981128GG1","ENVIADO")
Insert into PROSPECTOS(Nombre,ApellidoPat,ApellidoMat,Calle,NoCasa,Colonia,CP,Telefono,RFC,Estatus)
values("Carlos Antonio","Sanchez","Guzman","Guillermo Prieto","1210","El Vallado","80110", "6677475067","SAGJ981128GG1","ENVIADO")
INSERT INTO PROSPECTOS SET `Nombre` = 'A', `ApellidoPat` = 'B', `ApellidoMat` = 'C', `Calle` = 'Calle', `NoCasa` = '1111', `Colonia` = 'Colonia', `CP` = '80000', `Telefono` = '6666666666', `RFC` = 'RRRRRRRRRRRRR', `Estatus` = 'ENVIADO'

SELECT * FROM PROSPECTOS

drop table PROSPECTOS
