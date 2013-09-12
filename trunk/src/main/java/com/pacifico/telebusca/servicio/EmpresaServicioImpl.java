package com.pacifico.telebusca.servicio;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacifico.telebusca.dao.EmpresaDAO;
import com.pacifico.telebusca.dominio.Empresa;

@Service("empresaServicio")
public class EmpresaServicioImpl implements EmpresaServicio {

	@Autowired
	private EmpresaDAO empresaDAO;
	
	public void guardarEmpresa(Empresa empresa){
		this.empresaDAO.guardarEmpresa(empresa);
	}

	public Empresa actualizarEmpresa(Empresa empresa) {
		return this.empresaDAO.actualizarEmpresa(empresa);
		
	}

	public Empresa buscarEmpresa(Serializable pkEmpresa) {
		return this.empresaDAO.buscarEmpresa(pkEmpresa);
	}
}
