package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dao.EmpresaDAO;
import com.pacifico.telebusca.dominio.Empresa;

@Service("empresaServicio")
public class EmpresaServicioImpl implements EmpresaServicio {

	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void guardarEmpresa(Empresa empresa){
		this.empresaDAO.guardarEmpresa(empresa);
	}

	public Empresa actualizarEmpresa(Empresa empresa) {
		return this.empresaDAO.actualizarEmpresa(empresa);
		
	}

	public Empresa buscarEmpresaPorId(Serializable pkEmpresa) {
		return this.empresaDAO.buscarEmpresaPorId(pkEmpresa);
	}

	public List buscarEmpresaPorNombre(Serializable nombre) {
		// TODO Auto-generated method stub
		return this.empresaDAO.buscarEmpresaPorNombre(nombre);
	}

	public void eliminarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		this.empresaDAO.eliminarEmpresa(empresa);
	}
}
