package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Empresa;


public interface EmpresaDAO {

	void guardarEmpresa(Empresa empresa);
	Empresa actualizarEmpresa(Empresa empresa);
	Empresa buscarEmpresaPorId(final Serializable pkEmpresa);
	List buscarEmpresaPorNombre(final Serializable nombre);
	void eliminarEmpresa(Empresa empresa);
}
