
CREATE TABLE USTLV100.Aud_Sistema (
  CODAUDSIST INTEGER NOT NULL  PRIMARY KEY,
  USR VARCHAR(40),
  FEC TIMESTAMP,
  ACCION VARCHAR(200),
  DETALLE VARCHAR(500),
  FECCREA TIMESTAMP,
  FECMOD TIMESTAMP,
  USRCREA VARCHAR(40),
  USRMOD VARCHAR(40)
);
CREATE TABLE USTLV100.Audio (
  CODAUDIO INT NOT NULL PRIMARY KEY,
  DNICLI VARCHAR(15),
  NOMCLI VARCHAR(40),
  APEPATCLI VARCHAR(40),
  APEMATCLI VARCHAR(40),
  TLFNOCLI VARCHAR(9),
  SKILL VARCHAR(10),
  VDN VARCHAR(10),
  FECVENTA TIMESTAMP,  
  PROC VARCHAR(3),
  RUTAAUDIO VARCHAR(200),
  DNIASESOR VARCHAR(15),
  CODEMPRESA INT NOT NULL,
   FECCREA TIMESTAMP,
  FECMOD TIMESTAMP,
  USRCREA VARCHAR(40),
  USRMOD VARCHAR(40)
);

 CREATE TABLE USTLV100.Empresa (
  CODEMPRESA INT NOT NULL PRIMARY KEY,
  NOM VARCHAR(40),
  CARPETA VARCHAR(200),
  STS VARCHAR(1),
  FECCREA TIMESTAMP,
  FECMOD TIMESTAMP,
  USRCREA VARCHAR(40),
  USRMOD VARCHAR(40)
  
);
CREATE TABLE USTLV100.Usuario_Empresa (
  CODUSREMPRESA INT NOT NULL  PRIMARY KEY,
  USR VARCHAR(40),
  CODEMPRESA INT NOT NULL,
 FECCREA TIMESTAMP,
  FECMOD TIMESTAMP,
  USRCREA VARCHAR(40),
  USRMOD VARCHAR(40)
);
