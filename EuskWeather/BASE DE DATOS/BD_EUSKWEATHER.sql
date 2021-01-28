create database EuskWeather collate utf8_spanish_ci;

use EuskWeather;

create table Provincias
	(idProv int primary key auto_increment, nombreProv varchar(40) not null);
insert into Provincias
values(1, "Araba/Álava");
insert into Provincias
values(20, "Gipuzkoa");
insert into Provincias
values(48, "Bizkaia");
    
create table Municipios
	(idMuni int, nombreMuni varchar(40) primary key,
    alcalde varchar(120), webMunicipio varchar(40),
    idProvincia int not null,
    constraint fk_idProvincia foreign key(idProvincia) references Provincias(idProv) on update cascade on delete cascade);

create table indexLinks
	(idIndex int primary key auto_increment, nombreMuni varchar(40) not null, enlace varchar(100) not null,
    constraint fk_nombreMuni_2_ foreign key(nombreMuni) references municipios(nombreMuni) on update cascade on delete cascade);
    
create table EstacionMeteorologica
	(idEstacion int, nombreEstacion varchar(40) primary key,
    latitud double not null, longitud double not null,
    direccion varchar(80) not null,
    nomMunicipio varchar(40) not null,
    constraint fk_nomMunicipio foreign key(nomMunicipio) references Municipios(nombreMuni) on update cascade on delete cascade);

create table InformacionMeteorologica
	(idInfo int primary key, fechaInfo varchar(40), hora varchar(40), presionAtm varchar(40), temperatura varchar(40),
    saturacionO2 int, calidadAire varchar(50), nomEstMet varchar(40) not null,
    constraint fk_nomEstMet foreign key(nomEstMet) references EstacionMeteorologica(nombreEstacion) on update cascade on delete cascade);

create table EspaciosNaturales
	(idEspNat int, nombreEspNat varchar(50) primary key,
    descripcion varchar(150) not null, 
    tipoEspNat enum('Playas', 'Pantanos', 'Rios') not null);
    
create table ContieneEspNat
	(nombreMunicipio varchar(40), nomEspNat varchar(50),
    constraint fk_nombreMunicipio_ foreign key(nombreMunicipio) references Municipios(nombreMuni) on update cascade on delete cascade,
    constraint fk_nomEspNat foreign key(nomEspNat) references EspaciosNaturales(nombreEspNat) on update cascade on delete cascade,
	constraint pk_idMunicipio_idEspacioNatural primary key(nombreMunicipio, nomEspNat));
    
create table Usuarios
	(idUser int primary key auto_increment, nombreApellido varchar(50) not null, direccion varchar(100) not null,
    mail varchar(50) not null, nickUsuario varchar(40) not null, contrasenia varchar(40) not null);
    
create table Fotos
	(idFoto int primary key auto_increment, fotoString text not null, nombreMunicipio varchar(40) not null, nombreUsuario varchar(40) not null,
    constraint fk_nombreMunicipio_2 foreign key(nombreMunicipio) references Municipios(nombreMuni) on update cascade on delete cascade);

create table favoritos
	(idFav int primary key auto_increment, nomMuni varchar(40),
    constraint fk_nomMuni_ foreign key(nomMuni) references municipios(nombreMuni) on update cascade on delete cascade);
    