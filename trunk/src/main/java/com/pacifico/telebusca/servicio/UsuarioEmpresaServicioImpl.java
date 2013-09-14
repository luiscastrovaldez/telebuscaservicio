package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacifico.telebusca.dao.UsuarioEmpresaDAO;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;

@Service("usuarioempresaServicio")
public class UsuarioEmpresaServicioImpl implements UsuarioEmpresaServicio {

	@Autowired
	private UsuarioEmpresaDAO usuarioempresaDAO;
	
	public void guardarEmpresa(UsuarioEmpresa usuarioempresa){
		this.usuarioempresaDAO.guardarEmpresa(usuarioempresa);
	}

	public UsuarioEmpresa actualizarEmpresa(UsuarioEmpresa usuarioempresa) {
		return this.usuarioempresaDAO.actualizarUsuarioEmpresa(usuarioempresa);
		
	}

	public UsuarioEmpresa buscarEmpresaById(Serializable pkUsuarioEmpresa) {
		return this.usuarioempresaDAO.buscarUsuarioEmpresaById(pkUsuarioEmpresa);
	}

	public List buscarEmpresaByNombre(Serializable nombre) {
		// TODO Auto-generated method stub
		return this.usuarioempresaDAO.buscarUsuarioEmpresaByNombre(nombre);
	}
}
