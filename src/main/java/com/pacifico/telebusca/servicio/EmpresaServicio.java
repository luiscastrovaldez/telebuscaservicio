package com.pacifico.telebusca.servicio;

import java.io.Serializable;

import com.pacifico.telebusca.dominio.Empresa;

public interface EmpresaServicio {

	void guardarEmpresa(Empresa empresa);
	Empresa actualizarEmpresa(Empresa empresa);
	Empresa buscarEmpresa(final Serializable pkEmpresa);
}
