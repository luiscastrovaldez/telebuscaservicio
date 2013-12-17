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

	public List<Empresa> listarUsuariosyEmpresasByNombreUsuario(
			String nombreUsuario) {
		return this.usuarioempresaDAO
				.listarUsuariosyEmpresasByNombreUsuario(nombreUsuario);
	}

	public List<UsuarioEmpresa> listarUsuariosyEmpresasAsignadas(){
		 return this.usuarioempresaDAO.listarUsuariosyEmpresasAsignadas();
	}
	/*
	public List<UsuariosEmpresasBean> listarUsuariosyEmpresasByNombreUsuarioAndCodEmpresa(
			String nombreUsuario, int codEmpresa) {
		return this.usuarioempresaDAO
				.listarUsuariosyEmpresasByNombreUsuarioAndCodEmpresa(
						nombreUsuario, codEmpresa);
	}*/

	/*public List<UsuariosEmpresasBean> listarUsuariosyEmpresas() {
		
		List<UsuariosEmpresasBean> listaUsuariosEmpresasAux = new ArrayList<UsuariosEmpresasBean>();
		List<Integer> ids = new ArrayList<Integer>();
		List<UsuariosEmpresasBean> listaUsuariosEmpresas = this.usuarioempresaDAO.listarUsuariosyEmpresasAsignadas();
		List<UsuariosEmpresasBean> empresas = this.usuarioempresaDAO.listarEmpresas();
		
		if (listaUsuariosEmpresas !=null && !listaUsuariosEmpresas.isEmpty()){
			
			for (Iterator<UsuariosEmpresasBean> iterator2 = listaUsuariosEmpresas.iterator(); iterator2
					.hasNext();) {
				UsuariosEmpresasBean usuariosEmpresasBean = (UsuariosEmpresasBean) iterator2
						.next();
				if (!ids.contains(usuariosEmpresasBean.getEmpresa().getCodEmpresa())){
					ids.add(usuariosEmpresasBean.getEmpresa().getCodEmpresa());	
				}
														
			}
			
			if(empresas != null && !empresas.isEmpty()){
				
				for (Iterator<UsuariosEmpresasBean> iterator = empresas.iterator(); iterator
						.hasNext();) {
					UsuariosEmpresasBean empresa = (UsuariosEmpresasBean) iterator
							.next();					
					if (!ids.contains(empresa.getEmpresa().getCodEmpresa())){
						listaUsuariosEmpresasAux.add(empresa);
					}					
				}
			}
			
			if (listaUsuariosEmpresasAux.size() > 0){
				listaUsuariosEmpresas.addAll(listaUsuariosEmpresasAux);				
			}	
			return listaUsuariosEmpresas;
		} else {
			return empresas;
		}
		
		
		
	}*/

	public void eliminarUsuarioEmpresaByNombreUsuario(String nombreUsuario) {
		this.usuarioempresaDAO
				.eliminarUsuarioEmpresaByNombreUsuario(nombreUsuario);

	}

	
	public void eliminarUsuarioEmpresaByCodEmpresa(int codEmpresa) {
		this.usuarioempresaDAO.eliminarUsuarioEmpresaByCodEmpresa(codEmpresa);

	}

	public List<UsuarioEmpresa> buscarUsuarioEmpresaByNombreUsuario(
			String nombreUsuario) {
		// TODO Auto-generated method stub
		return this.usuarioempresaDAO.buscarUsuarioEmpresaByNombreUsuario(nombreUsuario);
	}

	public int buscarContarUsuarioEmpresas() {
		// TODO Auto-generated method stub
		return this.usuarioempresaDAO.buscarContarUsuarioEmpresas();
	}

	public List<UsuarioEmpresa> buscarUsuarioEmpresas(Integer firstIndex,
			Integer maxNumber) {
		// TODO Auto-generated method stub
		return this.usuarioempresaDAO.buscarUsuarioEmpresas(firstIndex, maxNumber);
	}

	public List<Empresa> listarUsuariosyEmpresasAsignadasyPorAsignar(String nombreUsuario) {
		return this.usuarioempresaDAO.listarUsuariosyEmpresasAsignadasyPorAsignar(nombreUsuario);
	}

	public List<Empresa> listarUsuariosyEmpresasAsignadasyPorAsignar() {
		// TODO Auto-generated method stub
		return this.usuarioempresaDAO.listarUsuariosyEmpresasAsignadasyPorAsignar();
	}
}
