package com.pacifico.telebusca.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.pacifico.telebusca.TeleBuscaTest;
import com.pacifico.telebusca.dominio.Empresa;

public class UsuarioEmpresaDAOTest extends TeleBuscaTest {

	@Autowired
	private UsuarioEmpresaDAO usuarioEmpresaDAO;
	
	@Test
	public void listaEmpresaPorNombreUsuario(){
		List<Empresa> empresas = new ArrayList<Empresa>();
		empresas = usuarioEmpresaDAO.listarUsuarioPorEmpresa("lcastro");
		for (Iterator<Empresa> iterator = empresas.iterator(); iterator.hasNext();) {
			Empresa empresa = (Empresa) iterator.next();
			System.out.println("empresa " + empresa.getCodEmpresa());
			System.out.println("empresa " + empresa.getNombreEmpresa());
			
		}
	}
}
