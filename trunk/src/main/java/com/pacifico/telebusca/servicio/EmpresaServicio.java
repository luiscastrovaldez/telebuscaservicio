package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Empresa;

public interface EmpresaServicio {

	void guardarEmpresa(Empresa empresa);

	Empresa actualizarEmpresa(Empresa empresa);

	Empresa buscarEmpresaPorCodigo(final Serializable codEmpresa);

	List<Empresa> buscarEmpresaPorNombre(final Serializable nombreEmpresa);

	void eliminarEmpresa(Empresa empresa);
}
