package com.pacifico.telebusca.servicio.xml;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pacifico.telebusca.TeleBuscaTest;
import com.pacifico.telebusca.servicio.xml.TeleBuscaAudio;
import com.pacifico.telebusca.web.beans.ValidacionErrores;

public class TeleBuscaAudioTest extends TeleBuscaTest{

	@Autowired
	private TeleBuscaAudio teleBuscaAudio;
	
	@Test
	public void validarArchivoXml(){
		String xml = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>" +
		"<Registros>" +
			"<Llamada>" +
				"<Empresa>DYNAMICALL</Empresa>" +
				"<DNICliente>07051199</DNICliente>" +
				"<ApellidoPaternoCliente>PEREZ</ApellidoPaternoCliente>"+
				"<ApellidoMaternoCliente>PEREZ</ApellidoMaternoCliente>" +
				"<NombresCliente>JUAN</NombresCliente>" +
				"<TelefonoCliente>016555550</TelefonoCliente>" +
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
				"<TelefonoCliente>016555550</TelefonoCliente>" +
				"<FechaVenta>13/08/2013</FechaVenta>"+
				"<HoraVenta>18:35:00</HoraVenta>" +
				"<DNIAsesor>09876543</DNIAsesor>" +
				"<Proceso>IN</Proceso>" +
				"<VDN>1234567890</VDN>" +
				"<Skill>A123456789</Skill>" +
				"<RutaAudio>/02072013/A1234567890B1234567890C1234567890.mp3</RutaAudio>"+
			"</Llamada>" +
		"</Registros>";
		try {
			ValidacionErrores validacionErrores = new ValidacionErrores();
			// = teleBuscaAudio.validarArchivoXml(xml);
			System.out.println("total registros = "
					+ validacionErrores.getTotalRegistros());
			System.out.println("total registros validos = "
					+ validacionErrores.getRegistrosValidos());
			System.out.println("total registros no validos = "
					+ validacionErrores.getRegistrosNoValidos());
			System.out.println("total registros no validos empresa = "
					+ validacionErrores.getCodEmpresa());
			System.out.println("total registros no validos proceso = "
					+ validacionErrores.getProceso());
			for (Iterator iterator = validacionErrores.getIndicesValidos()
					.iterator(); iterator.hasNext();) {
				String valor = (String) iterator.next();
				System.out.println(valor);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
