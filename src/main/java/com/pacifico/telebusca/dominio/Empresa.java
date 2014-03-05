package com.pacifico.telebusca.dominio;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author lcastro
 * @version 1.0.0.0
 * 
 */

@Entity
@Table(name = "USTLV100.empresa")
public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "secEmpresa")
	@SequenceGenerator(name = "secEmpresa", sequenceName = "USTLV100.SEC_EMPRESA")
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

	@Transient
	private int[] empresas;

	@Transient
	private String usuario;
	@Transient
	private int codEmpresa1;

	public Empresa(int codEmpresa,String nombreEmpresa, String usuario, int codEmpresa1) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.usuario = usuario;
		this.codEmpresa = codEmpresa;
		this.codEmpresa1 = codEmpresa1;
	}

	public Empresa() {

	}

	public Empresa(String nombreEmpresa, String carpeta, String sts,
			Timestamp fechaCreacion, Timestamp fechaModificacion,
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

	public int[] getEmpresas() {
		return empresas;
	}

	public void setEmpresas(int[] empresas) {
		this.empresas = empresas;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCodEmpresa1() {
		return codEmpresa1;
	}

	public void setCodEmpresa1(int codEmpresa1) {
		this.codEmpresa1 = codEmpresa1;
	}

	
}
