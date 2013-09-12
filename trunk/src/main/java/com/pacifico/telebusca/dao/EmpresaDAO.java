package com.pacifico.telebusca.dao;

import java.io.Serializable;

import com.pacifico.telebusca.dominio.Empresa;


public interface EmpresaDAO {

	void guardarEmpresa(Empresa empresa);
	Empresa actualizarEmpresa(Empresa empresa);
	Empresa buscarEmpresa(final Serializable pkEmpresa);
}
