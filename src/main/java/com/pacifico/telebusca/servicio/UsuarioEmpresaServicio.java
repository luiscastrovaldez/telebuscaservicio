package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.UsuarioEmpresa;

public interface UsuarioEmpresaServicio {

	void guardarEmpresa(UsuarioEmpresa empresa);
	UsuarioEmpresa actualizarEmpresa(UsuarioEmpresa empresa);
	UsuarioEmpresa buscarEmpresaById(final Serializable pkEmpresa);
	List buscarEmpresaByNombre(final Serializable nombre);
}
