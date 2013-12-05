package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;
import com.pacifico.telebusca.web.beans.UsuariosEmpresasBean;

/**
 * 
 * @author lcastro
 * 
 */
public interface UsuarioEmpresaDAO {

	void guardarUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa);

	UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);

	void eliminarUsuarioEmpresaByNombreUsuario(String nombreUsuario);

	void eliminarUsuarioEmpresaByCodEmpresa(int codEmpresa);

	UsuarioEmpresa buscarUsuarioEmpresaPorId(final Serializable pkUsuarioEmpresa);

	List<Empresa> listarUsuariosyEmpresasByNombreUsuario(String nombreUsuario);

	List<UsuariosEmpresasBean> listarUsuariosyEmpresasAsignadas();

	List<UsuariosEmpresasBean> listarEmpresas();
	List<UsuariosEmpresasBean> listarUsuariosyEmpresasByNombreUsuarioAndCodEmpresa(
			String nombreUsuario, int codEmpresa);
	
	List<UsuarioEmpresa> buscarUsuarioEmpresaByNombreUsuario(String nombreUsuario);

}
