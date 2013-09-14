DROP TABLE IF EXISTS empresa;

 CREATE TABLE empresa (
  pk_empresa INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  empresa VARCHAR(40),
  carpeta_audio VARCHAR(40),
  usuario_creacion VARCHAR(40),
  usuario_modificacion VARCHAR(40),
  fecha_creacion TIMESTAMP,
  fecha_modificacion TIMESTAMP,
  estado CHAR(1)
);