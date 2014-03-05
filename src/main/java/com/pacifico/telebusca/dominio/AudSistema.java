package com.pacifico.telebusca.dominio;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author lcastro
 * @version 1.0.0.0
 * 
 */

@Entity
@Table(name = "USTLV100.aud_sistema")
public class AudSistema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="secAudSistema") 
    @SequenceGenerator(name="secAudSistema",sequenceName="USTLV100.SEC_AUD_SISTEMA")
	@Column(name = "CODAUDSIST")
	private int codAudoSist;

	@Column(name = "USR")
	private String usuario;

	@Column(name = "FEC")
	private Timestamp fecha;

	@Column(name = "ACCION")
	private String accion;

	@Column(name = "DETALLE")
	private String detalle;

	@Column(name = "FECCREA")
	private Timestamp fechaCreacion;

	@Column(name = "FECMOD")
	private Timestamp fechaModificacion;

	@Column(name = "USRCREA")
	private String usuarioCreacion;

	@Column(name = "USRMOD")
	private String usuarioModificacion;

	public AudSistema() {

	}

	public AudSistema(String usuario, Timestamp fecha,
			String accion, String detalle, Timestamp fechaCreacion,
			Timestamp fechaModificacion, String usuarioCreacion,
			String usuarioModificacion) {
		super();		
		this.usuario = usuario;
		this.fecha = fecha;
		this.accion = accion;
		this.detalle = detalle;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public int getCodAudoSist() {
		return codAudoSist;
	}

	public void setCodAudoSist(int codAudoSist) {
		this.codAudoSist = codAudoSist;
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
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