
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
import com.pacifico.telebusca.dominio.Audio;
import com.pacifico.telebusca.dominio.Empresa;


public class AudioDAOTest extends TeleBuscaTest {
	
	@Autowired
	private AudioDAO audioDAO;
	
	@Test
	public void testBuscarAudio() {
		System.out.println("****** Test Buscar by Audio ******");
		
		
		List<Audio> audio;
		String start_date = null;
		String end_date =null;
		try {
			start_date="2013-10-24 8:00";
			end_date="2013-10-24 18:00";
			Audio audiobject = new Audio();
			/*audiobject =  new Audio (1,2,"42739567", "Santa Cruz","Tapia","Pedro","4552252",new Timestamp(
			Calendar.getInstance().getTimeInMillis()),"11111111","PROCESO","VDN","skill","/temp",new Timestamp(
						Calendar.getInstance().getTimeInMillis()),new Timestamp(
									Calendar.getInstance().getTimeInMillis()),"psantacruz","psantacruz");*/
			
			audiobject = new Audio();
			audiobject.setCodEmpresa(1);
			audio = this.audioDAO.buscarAudios(audiobject,start_date, end_date);
			if (start_date.equals(null) && end_date.equals(null)) {
				 Assert.fail("Fechas Invalidas");
			} else {
				for (Iterator<Audio> iterator = audio.iterator(); iterator
						.hasNext();) {
					Audio audioresult = (Audio) iterator.next();
					System.out.println("Audios = " + audioresult.getCodAudio());	
				}
				
				Assert.assertNotNull(audio);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Buscar Audios ******");
	}
	
	@Test public void myTest() {}
	}
	


