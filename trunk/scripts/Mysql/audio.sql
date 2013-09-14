DROP TABLE IF EXISTS audio;

CREATE TABLE audio (
  pk_audio INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dni_cliente VARCHAR(10),
  nombres_cliente VARCHAR(40),
  apellido_paterno VARCHAR(40),
  apellido_materno VARCHAR(40),
  telefono VARCHAR(9),
  skill VARCHAR(10),
  vdn VARCHAR(10),
  fecha_venta TIMESTAMP,
  hora_venta TIMESTAMP,
  proceso CHAR(3),
  ruta_audio VARCHAR(200),
  dni_asesor VARCHAR(15),
  fk_empresa INT NOT NULL,
  usuario_creacion VARCHAR(40),
  usuario_modificacion VARCHAR(40),
  fecha_creacion TIMESTAMP,
  fecha_modificacion TIMESTAMP
);