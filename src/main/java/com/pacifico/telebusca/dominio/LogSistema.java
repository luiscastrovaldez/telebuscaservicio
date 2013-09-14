package com.pacifico.telebusca.dominio;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "log_sistema")
public class LogSistema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_log_sistema")
	private int pkLogSistema;

	@Column (name = "usuario")
	private String usuario;
	
	@Column (name = "fecha")
	private Timestamp fecha;
	
	@Column (name = "accion")
	private String accion;
	
	@Column(name = "usuario_creacion")
	private String usuarioCreacion;
	
	@Column(name = "usuario_modificacion")
	private String usuarioModificacion;
	
	@Column(name = "fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name = "fecha_modificacion")
	private Timestamp fechaModificacion;
	
	@Column (name = "detalle")
	private String detalle;

	public int getPkLogSistema() {
		return pkLogSistema;
	}

	public void setPkLogSistema(int pkLogSistema) {
		this.pkLogSistema = pkLogSistema;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
}
