DROP TABLE IF EXISTS log_sistema;

CREATE TABLE log_sistema (
  pk_log_sistema INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  usuario VARCHAR(40),
  fecha TIMESTAMP,
  accion VARCHAR(200),
  usuario_creacion VARCHAR(40),
  usuario_modificacion VARCHAR(40),
  fecha_creacion TIMESTAMP,
  fecha_modificacion TIMESTAMP,
  detalle VARCHAR(200)
);