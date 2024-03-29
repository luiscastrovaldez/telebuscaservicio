package com.pacifico.telebusca.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacifico.telebusca.TeleBuscaTest;
import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.web.beans.UsuarioEmpresaBean;

public class UsuarioEmpresaDAOTest extends TeleBuscaTest {

	@Autowired
	private UsuarioEmpresaDAO usuarioEmpresaDAO;
	
	@Test
	public void listaEmpresaPorNombreUsuario(){
		List<Empresa> empresas = new ArrayList<Empresa>();
		empresas = usuarioEmpresaDAO.listarUsuariosyEmpresasByNombreUsuario("lcastro");
		for (Iterator<Empresa> iterator = empresas.iterator(); iterator.hasNext();) {
			Empresa empresa = (Empresa) iterator.next();
			System.out.println("empresa " + empresa.getCodEmpresa());
			System.out.println("empresa " + empresa.getNombreEmpresa());			
		}
	}
	
	/*@Test
	public void listarUsuariosyEmpresasTest(){
		List<UsuariosEmpresasBean> usuariosEmpresasBeans = new ArrayList<UsuariosEmpresasBean>();
		usuariosEmpresasBeans = usuarioEmpresaDAO.listarUsuariosyEmpresasAsignadas();
		for (Iterator<UsuariosEmpresasBean> iterator = usuariosEmpresasBeans.iterator(); iterator.hasNext();) {
			UsuariosEmpresasBean usuariosEmpresasBean = (UsuariosEmpresasBean) iterator.next();
			System.out.println("empresa " + usuariosEmpresasBean.getEmpresa().getNombreEmpresa());
			System.out.println("empresa " + usuariosEmpresasBean.getUsuarioEmpresa().getUsuario());
			
		}
	}*/
	
	@Test
	public void listaEmpresaPorNombreUsuario1(){
		List<Empresa> empresas = new ArrayList<Empresa>();
		empresas = usuarioEmpresaDAO.listarUsuariosyEmpresasAsignadasyPorAsignar("lcastro");
		for (Iterator<Empresa> iterator = empresas.iterator(); iterator.hasNext();) {
			Empresa empresa = (Empresa) iterator.next();
			System.out.println(empresa.getCodEmpresa());
			System.out.println(empresa.getUsuario());
			System.out.println(empresa.getNombreEmpresa());
			
		}
	}	
	
}
