package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.UsuarioEmpresa;


public interface UsuarioEmpresaDAO {

	void guardarUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa);
	UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);
	UsuarioEmpresa buscarUsuarioEmpresaPorId(final Serializable pkUsuarioEmpresa);
	List buscarUsuarioEmpresaPorNombre(final Serializable nombre);
	
	
}
