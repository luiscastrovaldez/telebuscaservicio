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
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Guardar Empresa ******");
	}
}
