package com.pacifico.telebusca.servicio.xml;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacifico.telebusca.TeleBuscaTest;

public class TeleBuscaAudioTest extends TeleBuscaTest{

	@Autowired
	private TeleBuscaAudio teleBuscaAudio;
	
	private String xml = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>" +
			"<Registros>" +
				"<Llamada>" +
					"<Empresa>DYNAMICALL</Empresa>" +
					"<DNICliente>07051199</DNICliente>" +
					"<ApellidoPaternoCliente>PEREZ</ApellidoPaternoCliente>"+
					"<ApellidoMaternoCliente>PEREZ</ApellidoMaternoCliente>" +
					"<NombresCliente>JUAN</NombresCliente>" +
					"<TelefonoCliente>655-5550</TelefonoCliente>" +
					"<FechaVenta>13/08/2013</FechaVenta>"+
					"<HoraVenta>18:35:00</HoraVenta>" +
					"<DNIAsesor>09876543</DNIAsesor>" +
					"<Proceso>IN</Proceso>" +
					"<VDN>1234567890</VDN>" +
					"<Skill>A123456789</Skill>" +
					"<RutaAudio>/02072013/A1234567890B1234567890C1234567890.mp3</RutaAudio>"+
				"</Llamada>" +
				"<Llamada>" +
					"<Empresa>DYNAMICALL</Empresa>" +
					"<DNICliente>07051199</DNICliente>" +
					"<ApellidoPaternoCliente>PEREZ</ApellidoPaternoCliente>"+
					"<ApellidoMaternoCliente>PEREZ</ApellidoMaternoCliente>" +
					"<NombresCliente>JUAN</NombresCliente>" +
					"<TelefonoCliente>655-5550</TelefonoCliente>" +
					"<FechaVenta>13/08/2013</FechaVenta>"+
					"<HoraVenta>18:35:00</HoraVenta>" +
					"<DNIAsesor>09876543</DNIAsesor>" +
					"<Proceso>IN</Proceso>" +
					"<VDN>1234567890</VDN>" +
					"<Skill>A123456789</Skill>" +
					"<RutaAudio>/02072013/A1234567890B1234567890C1234567890.mp3</RutaAudio>"+
				"</Llamada>" +
			"</Registros>";
		
			
	
	
	@Test
	public void parseaFileXml(){
		teleBuscaAudio.parseaFileXml(xml);
	}
}
