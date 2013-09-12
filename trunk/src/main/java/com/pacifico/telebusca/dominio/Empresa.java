package com.pacifico.telebusca.dominio;

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
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pk_empresa")
	private int pk_empresa;

	@Column(name = "empresa")
	private String empresa;

	@Column(name = "carperta_audio")
	private String carperta_audio;

	@Column(name = "fecha_creacion")
	private Timestamp fecha_creacion;

	@Column(name = "fecha_modificacion")
	private Timestamp fecha_modificacion;

	@Column(name = "usuario_creacion")
	private String usuario_creacion;

	@Column(name = "usuario_modificacion")
	private String usuario_modificacion;

	@Column(name = "estado")
	private char estado;

	public int getPk_empresa() {
		return pk_empresa;
	}

	public void setPk_empresa(int pk_empresa) {
		this.pk_empresa = pk_empresa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCarperta_audio() {
		return carperta_audio;
	}

	public void setCarperta_audio(String carperta_audio) {
		this.carperta_audio = carperta_audio;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Timestamp getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Timestamp fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public String getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public String getUsuario_modificacion() {
		return usuario_modificacion;
	}

	public void setUsuario_modificacion(String usuario_modificacion) {
		this.usuario_modificacion = usuario_modificacion;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

}
