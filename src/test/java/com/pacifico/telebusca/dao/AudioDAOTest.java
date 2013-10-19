
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


public class AudioDAOTest extends TeleBuscaTest {
	
	@Test
	public void testBuscarAudio() {
		System.out.println("****** Test Buscar by Audio ******");
		
		List<Audio> audio;
		try {		
			start_date = this.audioDAO.buscarAudios("");
			end_date = this.audioDAO.buscarAudios("");
			audio = new Audio ("DNI", "Pedro","Santa Cruz","Tapia","4552252","Skill","VDN",new Timestamp(
					Calendar.getInstance().getTimeInMillis()),new Timestamp(
							Calendar.getInstance().getTimeInMillis()),"PROCESO","/temp","42578717","lcastro",
							"lcastro",new Timestamp(
									Calendar.getInstance().getTimeInMillis()),new Timestamp(
											Calendar.getInstance().getTimeInMillis()));
			
			if (star_date == null && end_date == null) {
				Assert.fail("Fechas Invalidas");
			} else {
				for (Iterator<Audio> iterator = audio.iterator(); iterator
						.hasNext();) {
					Audio audio = (Audio) iterator.next();
					System.out.println("Audios = " + audios.getDni());	
				}
				
				Assert.assertNotNull(audio);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		System.out.println("****** Test Buscar Audios ******");
	}
	
	@Test public void myTest() {}
	}
	


