package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;
import com.pacifico.telebusca.web.beans.UsuariosEmpresasBean;

public interface UsuarioEmpresaServicio {

	void guardarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);

	UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);

	UsuarioEmpresa buscarUsuarioEmpresaPorId(final Serializable pkUsuarioEmpresa);

	 List<Empresa> listarUsuarioPorEmpresa(String nombreUsuario);
	 
	 List<UsuariosEmpresasBean> listarUsuariosyEmpresas();
	 
	 List<UsuariosEmpresasBean> listarEmpresasAsignadasNoAsignadas();
}
