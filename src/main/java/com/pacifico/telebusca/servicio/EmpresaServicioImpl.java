package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dao.EmpresaDAO;
import com.pacifico.telebusca.dominio.Empresa;

@Service("empresaServicio")
@Transactional
public class EmpresaServicioImpl implements EmpresaServicio {

	@Autowired
	private EmpresaDAO empresaDAO;

	public void guardarEmpresa(Empresa empresa) {		
		this.empresaDAO.guardarEmpresa(empresa);
	}

	public Empresa actualizarEmpresa(Empresa empresa) {
		return this.empresaDAO.actualizarEmpresa(empresa);

	}

	public Empresa buscarEmpresaPorCodigo(Serializable codEmpresa) {
		return this.empresaDAO.buscarEmpresaPorCodigo(codEmpresa);
	}

	public List<Empresa> buscarEmpresaPorNombre(Serializable nombreEmpresa) {
		return this.empresaDAO.buscarEmpresaPorNombre(nombreEmpresa);
	}

	public void eliminarEmpresa(int codEmpresa) {
		this.empresaDAO.eliminarEmpresa(codEmpresa);
	}

	
	public List<Empresa> listarEmpresas() {
		return this.empresaDAO.listarEmpresas();
	}

	
	public void eliminarUsuarioEmpresaByCodEmpresa(int codEmpresa) {
		this.empresaDAO.eliminarEmpresa(codEmpresa);
		
	}

	public int buscarContarEmpresas() { 
		return this.empresaDAO.buscarContarEmpresas();
	}

	public List<Empresa> buscarEmpresas(Integer firstIndex, Integer maxNumber) {
		// TODO Auto-generated method stub
		return this.empresaDAO.buscarEmpresas(firstIndex, maxNumber);
	}
}
