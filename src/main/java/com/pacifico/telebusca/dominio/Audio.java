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
@Table(name = "Audio")
public class Audio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODAUDIO")
	private int codAudio;

	@Column(name = "CODEMPRESA")
	private int codEmpresa;

	@Column(name = "DNICLI")
	private String dniCliente;

	@Column(name = "APEPATCLI")
	private String apellidoPaterno;

	@Column(name = "APEMATCLI")
	private String apellidoMaterno;

	@Column(name = "NOMCLI")
	private String nombresCliente;

	@Column(name = "TLFNOCLI")
	private String telefonoNumeroCliente;

	@Column(name = "FECVENTA")
	private Timestamp fechaVenta;

	@Column(name = "DNIASESOR")
	private String dniAsesor;

	@Column(name = "PROC")
	private String proceso;

	@Column(name = "VDN")
	private String vdn;

	@Column(name = "SKILL")
	private String skill;

	@Column(name = "RUTAAUDIO")
	private String rutaAudio;

	@Column(name = "FECCREA")
	private Timestamp fechaCreacion;

	@Column(name = "FECMOD")
	private Timestamp fechaModificacion;

	@Column(name = "USRCREA")
	private String usuarioCreacion;

	@Column(name = "USRMOD")
	private String usuarioModificacion;

	public Audio() {

	}

	public Audio(int codEmpresa, String dniCliente,
			String apellidoPaterno, String apellidoMaterno,
			String nombresCliente, String telefonoNumeroCliente,
			Timestamp fechaVenta, String dniAsesor, String proceso, String vdn,
			String skill, String rutaAudio, Timestamp fechaCreacion,
			Timestamp fechaModificacion, String usuarioCreacion,
			String usuarioModificacion) {
		super();		
		this.codEmpresa = codEmpresa;
		this.dniCliente = dniCliente;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombresCliente = nombresCliente;
		this.telefonoNumeroCliente = telefonoNumeroCliente;
		this.fechaVenta = fechaVenta;
		this.dniAsesor = dniAsesor;
		this.proceso = proceso;
		this.vdn = vdn;
		this.skill = skill;
		this.rutaAudio = rutaAudio;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioCreacion = usuarioCreacion;
		this.usuarioModificacion = usuarioModificacion;
	}



	public int getCodAudio() {
		return codAudio;
	}

	public void setCodAudio(int codAudio) {
		this.codAudio = codAudio;
	}

	public int getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombresCliente() {
		return nombresCliente;
	}

	public void setNombresCliente(String nombresCliente) {
		this.nombresCliente = nombresCliente;
	}

	public String getTelefonoNumeroCliente() {
		return telefonoNumeroCliente;
	}

	public void setTelefonoNumeroCliente(String telefonoNumeroCliente) {
		this.telefonoNumeroCliente = telefonoNumeroCliente;
	}

	public Timestamp getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Timestamp fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getDniAsesor() {
		return dniAsesor;
	}

	public void setDniAsesor(String dniAsesor) {
		this.dniAsesor = dniAsesor;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getVdn() {
		return vdn;
	}

	public void setVdn(String vdn) {
		this.vdn = vdn;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getRutaAudio() {
		return rutaAudio;
	}

	public void setRutaAudio(String rutaAudio) {
		this.rutaAudio = rutaAudio;
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
