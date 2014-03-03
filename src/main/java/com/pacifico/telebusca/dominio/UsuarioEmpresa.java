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
@Table(name = "Usuario_Empresa",schema="USTLV100")
public class UsuarioEmpresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "secUsuarioEmpresa")
	@SequenceGenerator(name = "secUsuarioEmpresa", sequenceName = "USTLV100.SEC_USUARIO_EMPRESA",schema="USTLV100")
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

	@Transient
	private int[] empresas;

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

	public int[] getEmpresas() {
		return empresas;
	}

	public void setEmpresas(int[] empresas) {
		this.empresas = empresas;
	}

}