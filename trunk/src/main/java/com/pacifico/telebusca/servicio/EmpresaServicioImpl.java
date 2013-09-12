package com.pacifico.telebusca.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacifico.telebusca.dao.EmpresaDAO;
import com.pacifico.telebusca.dominio.Empresa;

@Service("empresaServicio")
public class EmpresaServicioImpl implements EmpresaServicio {

	@Autowired(required=true)
	private EmpresaDAO empresaDAO;
	
	public void guardarEmpresa(Empresa empresa){
		this.empresaDAO.guardarEmpresa(empresa);
	}
}
