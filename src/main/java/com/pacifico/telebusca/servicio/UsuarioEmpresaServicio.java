package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.UsuarioEmpresa;

public interface UsuarioEmpresaServicio {

	void guardarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);
	UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);
	UsuarioEmpresa buscarUsuarioEmpresaPorId(final Serializable pkUsuarioEmpresa);
	List buscarUsuarioEmpresaPorNombre(final Serializable nombre);
	List listarUsuarioPorEmpresa();
}
