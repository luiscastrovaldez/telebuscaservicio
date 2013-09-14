package com.pacifico.telebusca.dominio;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "audio")
public class Audio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_audio")
	private int pkAudio;
	
	@Column(name = "fk_empresa")
	private int pkEmpresa;
	
	@Column (name = "dni")
	private String dni;
	
	@Column (name = "nombres_cliente")
	private String nombresCliente;
	
	@Column (name = "apellido_paterno")
	private String apellidoPaterno;
	
	@Column (name = "apellido_materno")
	private String apellidoMaterno;
	
	@Column (name = "telefono")
	private String telefono;
	
	@Column (name = "skill")
	private String skill;
	
	@Column (name = "vdn")
	private String vdn;
	
	@Column(name = "fecha_venta")
	private Timestamp fechaVenta;

	@Column(name = "hora_venta")
	private Timestamp horaVenta;
	
	@Column (name = "proceso")
	private String proceso;
	
	@Column (name = "ruta_audio")
	private String rutaAudio;
	
	@Column (name = "dni_asesor")
	private String dniAsesor;
	
	@Column(name = "usuario_creacion")
	private String usuarioCreacion;
	
	@Column(name = "usuario_modificacion")
	private String usuarioModificacion;
	
	@Column(name = "fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name = "fecha_modificacion")
	private Timestamp fechaModificacion;
	
}
