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

	public int getPkAudio() {
		return pkAudio;
	}

	public void setPkAudio(int pkAudio) {
		this.pkAudio = pkAudio;
	}

	public int getPkEmpresa() {
		return pkEmpresa;
	}

	public void setPkEmpresa(int pkEmpresa) {
		this.pkEmpresa = pkEmpresa;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombresCliente() {
		return nombresCliente;
	}

	public void setNombresCliente(String nombresCliente) {
		this.nombresCliente = nombresCliente;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getVdn() {
		return vdn;
	}

	public void setVdn(String vdn) {
		this.vdn = vdn;
	}

	public Timestamp getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Timestamp fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Timestamp getHoraVenta() {
		return horaVenta;
	}

	public void setHoraVenta(Timestamp horaVenta) {
		this.horaVenta = horaVenta;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getRutaAudio() {
		return rutaAudio;
	}

	public void setRutaAudio(String rutaAudio) {
		this.rutaAudio = rutaAudio;
	}

	public String getDniAsesor() {
		return dniAsesor;
	}

	public void setDniAsesor(String dniAsesor) {
		this.dniAsesor = dniAsesor;
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
	
	
}
