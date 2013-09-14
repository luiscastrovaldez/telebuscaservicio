DROP TABLE IF EXISTS usuario_empresa;

CREATE TABLE usuario_empresa (
  pk_usuario_empresa INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  usuario VARCHAR(40),
  fk_empresa INT NOT NULL,
  usuario_creacion VARCHAR(40),
  usuario_modificacion VARCHAR(40),
  fecha_creacion TIMESTAMP,
  fecha_modificacion TIMESTAMP
);