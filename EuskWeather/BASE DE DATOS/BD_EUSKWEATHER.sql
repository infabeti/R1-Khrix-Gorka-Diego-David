create database EuskWeather collate utf8_spanish_ci;

use EuskWeather;

create table Provincias
	(idProv int primary key auto_increment, nombreProv varchar(40) not null);
    
create table Municipios
	(idMuni int primary key auto_increment, nombreMuni varchar(40) not null,
    alcalde varchar(40) not null, webMunicipio varchar(40),
    idProvincia int not null,
    constraint fk_idProvincia foreign key(idProvincia) references Provincias(idProv) on update cascade on delete cascade);
    
create table EstacionMeteorologica
	(idEstacion int primary key auto_increment, nombreEstacion varchar(40) not null,
    latitud double not null, longitud double not null,
    direccion varchar(80) not null,
    idMunicipio int not null,
    constraint fk_idMunicipio foreign key(idMunicipio) references Municipios(idMuni) on update cascade on delete cascade);

create table InformacionMeteorologica
	(idInfo int primary key auto_increment, fechaInfo Date not null,
    presionAtm double not null, temperatura double not null,
    saturacionO2 int not null, idEstacionMeteo int not null,
    constraint fk_idEstacionMeteo foreign key(idEstacionMeteo) references EstacionMeteorologica(idEstacion) on update cascade on delete cascade);

create table EspaciosNaturales
	(idEspNat int primary key auto_increment, nombreEspNat varchar(50) not null,
    descripcion varchar(150) not null, 
    tipoEspNat enum('Playas', 'Pantanos', 'Rios') not null);
    
create table ContieneEspNat
	(idMunicipio int, idEspacioNatural int,
    constraint fk_idMunicipio_ foreign key(idMunicipio) references Municipios(idMuni) on update cascade on delete cascade,
    constraint fk_idEspacioNatural foreign key(idEspacioNatural) references EspaciosNaturales(idEspNat) on update cascade on delete cascade,
	constraint pk_idMunicipio_idEspacioNatural primary key(idMunicipio, idEspacioNatural));
    
create table Usuarios
	(idUser int primary key, nombreApellido varchar(50) not null, direccion varchar(100) not null,
    mail varchar(50) not null, nickUsuario varchar(40) not null, contrasenia varchar(40) not null);
    
create table Fotos
	(idFoto int primary key, idMunicipio int not null, idUsuario int not null,
    constraint fk_idMunicipio_2 foreign key(idMunicipio) references Municipios(idMuni) on update cascade on delete cascade,
    constraint fk_idUsuario foreign key(idUsuario) references Usuarios(idUser) on update cascade on delete cascade);
    