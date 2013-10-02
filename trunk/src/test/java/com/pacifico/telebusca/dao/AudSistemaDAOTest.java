package com.pacifico.telebusca.dao;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacifico.telebusca.TeleBuscaTest;
import com.pacifico.telebusca.dominio.AudSistema;

public class AudSistemaDAOTest extends TeleBuscaTest{

	@Autowired
	private AudSistemaDAO audSistemaDAO;
	
	@Test
	public void testGuardaAudSistema(){
		System.out.println("****** Test Guardar Auditoria ******");
		AudSistema audSistema;
		try {
			audSistema = new AudSistema("lcastro", new Timestamp(
					Calendar.getInstance().getTimeInMillis()), "A", "Error Acceso", new Timestamp(
							Calendar.getInstance().getTimeInMillis()), new Timestamp(
									Calendar.getInstance().getTimeInMillis()), "cvillacriz", "cvillacriz");
			this.audSistemaDAO.guardaAudSistema(audSistema);
		} catch (Exception e) {			
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Guardar Auditoria ******");
	}
}
