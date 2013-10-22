package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dao.UsuarioEmpresaDAO;
import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;

@Service("usuarioEmpresaServicio")
@Transactional
public class UsuarioEmpresaServicioImpl implements UsuarioEmpresaServicio {

	@Autowired
	private UsuarioEmpresaDAO usuarioempresaDAO;

	public void guardarUsuarioEmpresa(UsuarioEmpresa usuarioempresa) {
		this.usuarioempresaDAO.guardarUsuarioEmpresa(usuarioempresa);

	}

	public UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa) {
		return this.usuarioempresaDAO.actualizarUsuarioEmpresa(usuarioempresa);

	}

	public UsuarioEmpresa buscarUsuarioEmpresaPorId(
			Serializable pkUsuarioEmpresa) {
		return this.usuarioempresaDAO
				.buscarUsuarioEmpresaPorId(pkUsuarioEmpresa);
	}

	public List<Empresa> listarUsuarioPorEmpresa(String nombreUsuario) {
		return this.listarUsuarioPorEmpresa(nombreUsuario);
	}

}
