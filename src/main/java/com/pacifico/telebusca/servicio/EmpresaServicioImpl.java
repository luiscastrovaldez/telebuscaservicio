package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dao.EmpresaDAO;
import com.pacifico.telebusca.dominio.Empresa;

@Service("empresaServicio")
public class EmpresaServicioImpl implements EmpresaServicio {

	@Autowired
	private EmpresaDAO empresaDAO;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void guardarEmpresa(Empresa empresa) {
		this.empresaDAO.guardarEmpresa(empresa);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Empresa actualizarEmpresa(Empresa empresa) {
		return this.empresaDAO.actualizarEmpresa(empresa);

	}

	@Transactional(readOnly = true)
	public Empresa buscarEmpresaPorCodigo(Serializable codEmpresa) {
		return this.empresaDAO.buscarEmpresaPorCodigo(codEmpresa);
	}

	@Transactional(readOnly = true)
	public List<Empresa> buscarEmpresaPorNombre(Serializable nombreEmpresa) {
		return this.empresaDAO.buscarEmpresaPorNombre(nombreEmpresa);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void eliminarEmpresa(Empresa empresa) {
		this.empresaDAO.eliminarEmpresa(empresa);
	}
}
