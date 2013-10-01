package com.pacifico.telebusca.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacifico.telebusca.TeleBuscaTest;
import com.pacifico.telebusca.dominio.Empresa;

public class EmpresaDAOTest extends TeleBuscaTest {

	@Autowired
	private EmpresaDAO empresaDAO;

	@Test
	public void guardarEmpresaTest() {
		System.out.println("****** Test Guardar Empresa ******");
		Empresa empresa;
		try {
			empresa = new Empresa("Atento", "/temp", "A", new Timestamp(
					Calendar.getInstance().getTimeInMillis()), new Timestamp(
					Calendar.getInstance().getTimeInMillis()), "lcastro",
					"lcastro");
			this.empresaDAO.guardarEmpresa(empresa);
			Assert.assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Guardar Empresa ******");
	}
	
	@Test
	public void actualizarEmpresaTest() {
		System.out.println("****** Test Actualizar Empresa ******");
		List<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa;
		try {			
			empresas = empresaDAO.buscarEmpresaPorNombre("Atento");	
			if (empresas != null && !empresas.isEmpty()) {
				empresa = empresas.get(0);
				empresa.setSts("N");
				this.empresaDAO.actualizarEmpresa(empresa);
			}					
			Assert.assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Actualizar Empresa ******");
	}
	
	@Test
	public void buscarEmpresaByIdTest() {
		System.out.println("****** Test Buscar by Id Empresa ******");
		Empresa empresa = new Empresa();
		try {			
			empresa = this.empresaDAO.buscarEmpresaPorCodigo(4);
			if (empresa == null) {
				Assert.fail("No existe Empresa Registrada");
			} else {
				System.out.println("nombre de empresa = " + empresa.getNombreEmpresa());
				Assert.assertNotNull(empresa);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Buscar by Id Empresa ******");
	}
	
	@Test
	public void buscarEmpresaPorNombreTest() {
		System.out.println("****** Test Buscar by Nombre Empresa ******");
		
		List<Empresa> empresas;
		try {			
			empresas = this.empresaDAO.buscarEmpresaPorNombre("Atento");
			if (empresas == null) {
				Assert.fail("No existe Empresa Registrada");
			} else {
				for (Iterator<Empresa> iterator = empresas.iterator(); iterator
						.hasNext();) {
					Empresa empresa = (Empresa) iterator.next();
					System.out.println("nombre de empresa = " + empresa.getNombreEmpresa());	
				}
				
				Assert.assertNotNull(empresas);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Buscar by Nombre Empresa ******");
	}
}
