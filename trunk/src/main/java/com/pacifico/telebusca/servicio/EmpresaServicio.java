package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Empresa;

public interface EmpresaServicio {

	void guardarEmpresa(Empresa empresa);
	Empresa actualizarEmpresa(Empresa empresa);
	Empresa buscarEmpresaPorId(final Serializable pkEmpresa);
	List buscarEmpresaPorNombre(final Serializable nombre);
	void eliminarEmpresa(Empresa empresa);
}
