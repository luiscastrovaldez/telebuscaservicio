package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.UsuarioEmpresa;


public interface UsuarioEmpresaDAO {

	void guardarEmpresa(UsuarioEmpresa usuarioEmpresa);
	UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa empresa);
	UsuarioEmpresa buscarUsuarioEmpresaById(final Serializable pkEmpresa);
	List buscarUsuarioEmpresaByNombre(final Serializable nombre);
}
