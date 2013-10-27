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
@Table(name = "Usuario_Empresa")
public class UsuarioEmpresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODUSREMPRESA")
	private int codUsuarioEmpresa;

	@Column(name = "USR")
	private String usuario;

	@Column(name = "CODEMPRESA")
	private int codEmpresa;

	@Column(name = "FECCREA")
	private Timestamp fechaCreacion;

	@Column(name = "FECMOD")
	private Timestamp fechaModificacion;

	@Column(name = "USRCREA")
	private String usuarioCreacion;

	@Column(name = "USRMOD")
	private String usuarioModificacion;

	
	
	public UsuarioEmpresa() {

	}

	public UsuarioEmpresa(int codUsuarioEmpresa, String usuario,
			int codEmpresa, Timestamp fechaCreacion,
			Timestamp fechaModificacion, String usuarioCreacion,
			String usuarioModificacion) {
		super();
		this.codUsuarioEmpresa = codUsuarioEmpresa;
		this.usuario = usuario;
		this.codEmpresa = codEmpresa;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public int getCodUsuarioEmpresa() {
		return codUsuarioEmpresa;
	}

	public void setCodUsuarioEmpresa(int codUsuarioEmpresa) {
		this.codUsuarioEmpresa = codUsuarioEmpresa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
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