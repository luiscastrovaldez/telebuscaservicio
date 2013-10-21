package com.pacifico.telebusca.servicio.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.pacifico.telebusca.servicio.xml.dominio.Llamada;
import com.pacifico.telebusca.servicio.xml.dominio.Registros;

public class TestXml {

	@Test
	public void testXml(){
		String xml = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>" +
		"<Registros>" +
			"<Llamada>" +
				"<Empresa>DYNAMICALL</Empresa>" +
				"<DNICliente>07051199</DNICliente>" +
				"<ApellidoPaternoCliente>PEREZ</ApellidoPaternoCliente>"+
				"<ApellidoMaternoCliente>PEREZ</ApellidoMaternoCliente>" +
				"<NombresCliente>JUAN</NombresCliente>" +
				"<TelefonoCliente>01655550</TelefonoCliente>" +
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
				"<TelefonoCliente>01655550</TelefonoCliente>" +
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
			"<TelefonoCliente>01655550</TelefonoCliente>" +
			"<FechaVenta>13/08/2013</FechaVenta>"+
			"<HoraVenta>18:35:00</HoraVenta>" +
			"<DNIAsesor>09876543</DNIAsesor>" +
			"<Proceso>INs</Proceso>" +
			"<VDN>1234567890</VDN>" +
			"<Skill>A123456789</Skill>" +
			"<RutaAudio>/02072013/A1234567890B1234567890C1234567890.mp3</RutaAudio>"+
		"</Llamada>" +
		"</Registros>";
		Serializer serializer = new Persister();
		
		List<Llamada> servers;
		try {
			Registros example = serializer.read(Registros.class, xml);
			 servers = example.getLlamadas();
			for (Iterator iterator = servers.iterator(); iterator.hasNext();) {
				Llamada server = (Llamada) iterator.next();
				System.out.println(server.getApellidoMaternoCliente());
				System.out.println(server.getDniAsesor());
				System.out.println(server.getEmpresa());
				System.out.println(server.getErrores());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testXml1(){
		
		List<Llamada> llamadas = new ArrayList<Llamada>();
		Registros  registros = new Registros();
		Llamada llamada = new Llamada();
		llamada.setEmpresa("otroe");
		llamada.setErrores("luis");
		llamadas.add(llamada);
		
		llamada = new Llamada();
		llamada.setErrores("sss");
		
		llamadas.add(llamada);
		
		registros.setLlamadas(llamadas);
		
		Serializer serializer = new Persister();
		File source = new File("C:/example.xml");

		try {
			serializer.write(registros, source);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
