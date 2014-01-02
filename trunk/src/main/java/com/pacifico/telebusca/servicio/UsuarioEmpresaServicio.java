package com.pacifico.telebusca.servicio;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;

public interface UsuarioEmpresaServicio {

	void guardarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);

	void eliminarUsuarioEmpresaByNombreUsuario(String nombreUsuario);

	void eliminarUsuarioEmpresaByCodEmpresa(int codEmpresa);

	UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa);

	UsuarioEmpresa buscarUsuarioEmpresaPorId(final Serializable pkUsuarioEmpresa);

	List<Empresa> listarUsuariosyEmpresasByNombreUsuario(String nombreUsuario);

	List<UsuarioEmpresa> listarUsuariosyEmpresasAsignadas();


	List<UsuarioEmpresa> buscarUsuarioEmpresaByNombreUsuario(
			String nombreUsuario);
	
	int buscarContarUsuarioEmpresas();

	List<UsuarioEmpresa> buscarUsuarioEmpresas(Integer firstIndex, Integer maxNumber);
	
	List<Empresa> listarUsuariosyEmpresasAsignadasyPorAsignar(String nombreUsuario);
	
	
}
