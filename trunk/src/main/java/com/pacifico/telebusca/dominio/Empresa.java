package com.pacifico.telebusca.dominio;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lcastro
 * @version 1.0.0.0
 * 
 */

@Entity
@Table(name = "Empresa")
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CODEMPRESA")
	private int codEmpresa;

	@Column(name = "NOM")
	private String nombreEmpresa;

	@Column(name = "CARPETA")
	private String carpeta;

	@Column(name = "STS")
	private String sts;

	@Column(name = "FECCREA")
	private Timestamp fechaCreacion;

	@Column(name = "FECMOD")
	private Timestamp fechaModificacion;

	@Column(name = "USRCREA")
	private String usuarioCreacion;

	@Column(name = "USRMOD")
	private String usuarioModificacion;

	public Empresa() {

	}

	public Empresa(String nombreEmpresa, String carpeta,
			String sts, Timestamp fechaCreacion, Timestamp fechaModificacion,
			String usuarioCreacion, String usuarioModificacion) {
		super();		
		this.nombreEmpresa = nombreEmpresa;
		this.carpeta = carpeta;
		this.sts = sts;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public int getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
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

}
