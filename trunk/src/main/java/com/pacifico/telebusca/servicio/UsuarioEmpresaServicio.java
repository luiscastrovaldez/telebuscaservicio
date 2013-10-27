package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;
import com.pacifico.telebusca.web.beans.UsuariosEmpresasBean;

public interface UsuarioEmpresaServicio {

	void guardarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);
	
	void eliminarUsuarioEmpresaByNombreUsuario(String nombreUsuario);
	
	void eliminarUsuarioEmpresaByCodEmpresa(int codEmpresa);

	UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);

	UsuarioEmpresa buscarUsuarioEmpresaPorId(final Serializable pkUsuarioEmpresa);

	 List<Empresa> listarUsuariosyEmpresasByNombreUsuario(String nombreUsuario);
	 
	 List<UsuariosEmpresasBean> listarUsuariosyEmpresas();
	 
	 List<UsuariosEmpresasBean> listarUsuariosyEmpresas1();
	 
	 List<UsuariosEmpresasBean> listarEmpresasAsignadasNoAsignadas();
	 
	 List<UsuariosEmpresasBean> listarUsuariosyEmpresasByNombreUsuarioAndCodEmpresa(String nombreUsuario, int codEmpresa);
}
