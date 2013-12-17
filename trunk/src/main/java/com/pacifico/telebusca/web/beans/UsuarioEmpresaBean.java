package com.pacifico.telebusca.web.beans;

import java.io.Serializable;

public class UsuarioEmpresaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String usuario;
	private int codEmpresa;
	private int[] empresas;

	public UsuarioEmpresaBean() {

	}

	public UsuarioEmpresaBean(String nombre, String usuario, int codEmpresa) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.codEmpresa = codEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int[] getEmpresas() {
		return empresas;
	}

	public void setEmpresas(int[] empresas) {
		this.empresas = empresas;
	}

	
}
