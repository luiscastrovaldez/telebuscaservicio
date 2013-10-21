package com.pacifico.telebusca.servicio.xml.dominio;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Llamada")
public class Llamada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Element(required = false, name = "Empresa")
	private String empresa;
	@Element(required = false, name = "DNICliente")
	private String dniCliente;
	@Element(required = false, name = "ApellidoPaternoCliente")
	private String apellidoPaternoCliente;
	@Element(required = false, name = "ApellidoMaternoCliente")
	private String apellidoMaternoCliente;
	@Element(required = false, name = "NombresCliente")
	private String nombresCliente;
	@Element(required = false, name = "TelefonoCliente")
	private String telefonoCliente;
	@Element(required = false, name = "FechaVenta")
	private String fechaVenta;
	@Element(required = false, name = "HoraVenta")
	private String horaVenta;
	@Element(required = false, name = "DNIAsesor")
	private String dniAsesor;
	@Element(required = false, name = "Proceso")
	private String proceso;
	@Element(required = false, name = "VDN")
	private String vnd;
	@Element(required = false, name = "Skill")
	private String skill;
	@Element(required = false, name = "RutaAudio")
	private String rutaAudio;
	@Element(required = false, name = "errores")
	private String errores;

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getApellidoPaternoCliente() {
		return apellidoPaternoCliente;
	}

	public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
		this.apellidoPaternoCliente = apellidoPaternoCliente;
	}

	public String getApellidoMaternoCliente() {
		return apellidoMaternoCliente;
	}

	public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
		this.apellidoMaternoCliente = apellidoMaternoCliente;
	}

	public String getNombresCliente() {
		return nombresCliente;
	}

	public void setNombresCliente(String nombresCliente) {
		this.nombresCliente = nombresCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getHoraVenta() {
		return horaVenta;
	}

	public void setHoraVenta(String horaVenta) {
		this.horaVenta = horaVenta;
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

	public String getVnd() {
		return vnd;
	}

	public void setVnd(String vnd) {
		this.vnd = vnd;
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

	public String getErrores() {
		return errores;
	}

	public void setErrores(String errores) {
		this.errores = errores;
	}

}