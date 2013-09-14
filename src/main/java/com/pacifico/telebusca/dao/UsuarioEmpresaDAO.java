package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.UsuarioEmpresa;


public interface UsuarioEmpresaDAO {

	void guardarUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa);
	UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);
	UsuarioEmpresa buscarUsuarioEmpresaById(final Serializable pkUsuarioEmpresa);
	List buscarUsuarioEmpresaByNombre(final Serializable nombre);
	
	
}
