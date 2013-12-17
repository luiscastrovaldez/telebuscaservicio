package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;

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

	List<UsuarioEmpresa> listarUsuariosyEmpresasAsignadas();
	
	List<UsuarioEmpresa> buscarUsuarioEmpresaByNombreUsuario(
			String nombreUsuario);

	int buscarContarUsuarioEmpresas();

	List<UsuarioEmpresa> buscarUsuarioEmpresas(Integer firstIndex, Integer maxNumber);
	
	List<Empresa> listarUsuariosyEmpresasAsignadasyPorAsignar(String nombreUsuario);
	
	List<Empresa> listarUsuariosyEmpresasAsignadasyPorAsignar();
}
