package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dao.UsuarioEmpresaDAO;
import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;
import com.pacifico.telebusca.web.beans.UsuariosEmpresasBean;

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

	public List<Empresa> listarUsuariosyEmpresasByNombreUsuario(
			String nombreUsuario) {
		return this.usuarioempresaDAO
				.listarUsuariosyEmpresasByNombreUsuario(nombreUsuario);
	}

	public List<UsuariosEmpresasBean> listarUsuariosyEmpresas() {
		return this.usuarioempresaDAO.listarUsuariosyEmpresas();
	}

	public List<UsuariosEmpresasBean> listarEmpresasAsignadasNoAsignadas() {

		return this.usuarioempresaDAO.listarEmpresasAsignadasNoAsignadas();
	}

	public List<UsuariosEmpresasBean> listarUsuariosyEmpresasByNombreUsuarioAndCodEmpresa(
			String nombreUsuario, int codEmpresa) {
		return this.usuarioempresaDAO
				.listarUsuariosyEmpresasByNombreUsuarioAndCodEmpresa(
						nombreUsuario, codEmpresa);
	}

	public List<UsuariosEmpresasBean> listarUsuariosyEmpresas1() {
		return this.usuarioempresaDAO.listarUsuariosyEmpresas1();
	}

	public void eliminarUsuarioEmpresaByNombreUsuario(String nombreUsuario) {
		this.usuarioempresaDAO
				.eliminarUsuarioEmpresaByNombreUsuario(nombreUsuario);

	}

	
	public void eliminarUsuarioEmpresaByCodEmpresa(int codEmpresa) {
		this.usuarioempresaDAO.eliminarUsuarioEmpresaByCodEmpresa(codEmpresa);

	}
}
