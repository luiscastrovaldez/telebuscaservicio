package com.pacifico.telebusca.servicio;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacifico.telebusca.TeleBuscaTest;
import com.pacifico.telebusca.dominio.AudSistema;

public class AudSistemaServicioTest extends TeleBuscaTest {

	@Autowired
	private AudSistemaServicio audSistemaServicio;
	
	@Test
	public void guardaAudSistemaTest(){
		System.out.println("****** Test Guardar Auditoria ******");
		AudSistema audSistema;
		try {
			audSistema = new AudSistema("lcastro", new Timestamp(
					Calendar.getInstance().getTimeInMillis()), "A", "Error Acceso", new Timestamp(
							Calendar.getInstance().getTimeInMillis()), new Timestamp(
									Calendar.getInstance().getTimeInMillis()), "cvillacriz", "cvillacriz");
			this.audSistemaServicio.guardaAudSistema(audSistema);
		} catch (Exception e) {			
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Guardar Auditoria ******");
	}
}
