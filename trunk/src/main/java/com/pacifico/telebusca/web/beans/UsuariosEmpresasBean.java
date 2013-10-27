package com.pacifico.telebusca.web.beans;

import java.io.Serializable;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;

public class UsuariosEmpresasBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Empresa empresa;
	private UsuarioEmpresa usuarioEmpresa;

	public UsuariosEmpresasBean(){
		
	}
	
	public UsuariosEmpresasBean(Empresa empresa, UsuarioEmpresa usuarioEmpresa) {
		super();
		this.empresa = empresa;
		this.usuarioEmpresa = usuarioEmpresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public UsuarioEmpresa getUsuarioEmpresa() {
		return usuarioEmpresa;
	}

	public void setUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
		this.usuarioEmpresa = usuarioEmpresa;
	}

}
