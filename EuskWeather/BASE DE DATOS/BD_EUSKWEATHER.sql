create database EuskWeather collate utf8_spanish_ci;

use EuskWeather;

create table Provincias
	(idProv int primary key auto_increment, nombreProv varchar(40) not null);
    
create table Municipios
	(idMuni int, nombreMuni varchar(40) primary key,
    alcalde varchar(120), webMunicipio varchar(40),
    idProvincia int not null,
    constraint fk_idProvincia foreign key(idProvincia) references Provincias(idProv) on update cascade on delete cascade);
    
create table EstacionMeteorologica
	(idEstacion int, nombreEstacion varchar(40) primary key,
    latitud double not null, longitud double not null,
    direccion varchar(80) not null,
    nomMunicipio varchar(40) not null,
    constraint fk_nomMunicipio foreign key(nomMunicipio) references Municipios(nombreMuni) on update cascade on delete cascade);

create table InformacionMeteorologica
	(idInfo int, fechaInfo Date primary key,
    presionAtm double not null, temperatura double not null,
    saturacionO2 int not null, nomEstMet varchar(40) not null,
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
	(idUser int primary key, nombreApellido varchar(50) not null, direccion varchar(100) not null,
    mail varchar(50) not null, nickUsuario varchar(40) not null, contrasenia varchar(40) not null);
    
create table Fotos
	(idFoto int primary key, nombreMunicipio varchar(40) not null, idUsuario int not null,
    constraint fk_nombreMunicipio_2 foreign key(nombreMunicipio) references Municipios(nombreMuni) on update cascade on delete cascade,
    constraint fk_idUsuario foreign key(idUsuario) references Usuarios(idUser) on update cascade on delete cascade);
    