package com.pacifico.telebusca.servicio;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacifico.telebusca.TeleBuscaTest;
import com.pacifico.telebusca.dominio.Empresa;

public class EmpresaServicioTest extends TeleBuscaTest {

	@Autowired
	private EmpresaServicio empresaServicio;

	@Test
	public void guardarEmpresaTest() {
		System.out.println("****** Test Guardar Empresa ******");
		Empresa empresa = new Empresa();
		try {
			empresa.setEstado('Y');
			empresa.setCarpetaAudio("/temp");
			empresa.setEmpresa("Atento");
			empresa.setFechaCreacion(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
			empresa.setFechaModificacion(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
			empresa.setUsuarioCreacion("lcastro");
			empresa.setUsuarioModificacion("lcastro");
			this.empresaServicio.guardarEmpresa(empresa);
			Assert.assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Guardar Empresa ******");
	}
	
	@Test
	public void actualizarEmpresaTest() {
		System.out.println("****** Test Actualizar Empresa ******");
		Empresa empresa = new Empresa();
		try {
			empresa.setEstado('N');
			empresa.setCarpetaAudio("/temp");
			empresa.setEmpresa("Atento");
			empresa.setFechaCreacion(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
			empresa.setFechaModificacion(new Timestamp(Calendar.getInstance()
					.getTimeInMillis()));
			empresa.setUsuarioCreacion("lcastro");
			empresa.setUsuarioModificacion("lcastro");
			this.empresaServicio.guardarEmpresa(empresa);
			Assert.assertTrue(Boolean.TRUE);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Actualizar Empresa ******");
	}
	@Test
	public void buscarEmpresaTest() {
		System.out.println("****** Test Buscar Empresa ******");
		Empresa empresa = new Empresa();
		try {			
			empresa = this.empresaServicio.buscarEmpresa(10);
			if (empresa == null) {
				Assert.fail("No existe Empresa Registrada");
			} else {
				System.out.println("nombre de empresa = " + empresa.getEmpresa());
				Assert.assertNotNull(empresa);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Actualizar Empresa ******");
	}

}
