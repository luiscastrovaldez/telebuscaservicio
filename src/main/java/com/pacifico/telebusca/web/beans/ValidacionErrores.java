package com.pacifico.telebusca.web.beans;

import java.io.Serializable;

public class ValidacionErrores implements Serializable {

	private static final long serialVersionUID = 1L;

	public int totalRegistros;
	public int registrosValidos;
	public int registrosNoValidos;
	private int codEmpresa;
	private int dniCliente;
	private int apellidoPaterno;
	private int apellidoMaterno;
	private int nombresCliente;
	private int telefonoNumeroCliente;
	private int fechaVenta;
	private int horaVenta;
	private int dniAsesor;
	private int proceso;
	private int vdn;
	private int skill;
	private int rutaAudio;

	public int getTotalRegistros() {
		return totalRegistros;
	}

	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	public int getRegistrosValidos() {
		return registrosValidos;
	}

	public void setRegistrosValidos(int registrosValidos) {
		this.registrosValidos = registrosValidos;
	}

	public int getRegistrosNoValidos() {
		return registrosNoValidos;
	}

	public void setRegistrosNoValidos(int registrosNoValidos) {
		this.registrosNoValidos = registrosNoValidos;
	}

	public int getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public int getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}

	public int getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(int apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public int getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(int apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public int getNombresCliente() {
		return nombresCliente;
	}

	public void setNombresCliente(int nombresCliente) {
		this.nombresCliente = nombresCliente;
	}

	public int getTelefonoNumeroCliente() {
		return telefonoNumeroCliente;
	}

	public void setTelefonoNumeroCliente(int telefonoNumeroCliente) {
		this.telefonoNumeroCliente = telefonoNumeroCliente;
	}

	public int getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(int fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getHoraVenta() {
		return horaVenta;
	}

	public void setHoraVenta(int horaVenta) {
		this.horaVenta = horaVenta;
	}

	public int getDniAsesor() {
		return dniAsesor;
	}

	public void setDniAsesor(int dniAsesor) {
		this.dniAsesor = dniAsesor;
	}

	public int getProceso() {
		return proceso;
	}

	public void setProceso(int proceso) {
		this.proceso = proceso;
	}

	public int getVdn() {
		return vdn;
	}

	public void setVdn(int vdn) {
		this.vdn = vdn;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

	public int getRutaAudio() {
		return rutaAudio;
	}

	public void setRutaAudio(int rutaAudio) {
		this.rutaAudio = rutaAudio;
	}

}
