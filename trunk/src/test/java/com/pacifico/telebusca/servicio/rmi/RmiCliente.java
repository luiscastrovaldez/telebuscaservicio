package com.pacifico.telebusca.servicio.rmi;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.servicio.AudioServicio;
import com.pacifico.telebusca.servicio.EmpresaServicio;
import com.pacifico.telebusca.servicio.xml.TeleBuscaAudio;

public class RmiCliente {
	
	private static Logger logger = Logger.getLogger(RmiCliente.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:com/pacifico/telebusca/config/applicationContext-rmi.xml");
			/*System.out.println("empresaServicioRmi");
			EmpresaServicio empresaServicio = (EmpresaServicio) context
					.getBean("empresaServicioCliente");
			Empresa empresa = empresaServicio.buscarEmpresaPorCodigo(4);
			
			System.out.println("codigo " + empresa.getCodEmpresa());
			*/
			
			TeleBuscaAudio teleBuscaAudio = (TeleBuscaAudio)context
			.getBean("teleBuscaAudioRmi");
			String xml = "<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>" +
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
			
			teleBuscaAudio.parseaFileXml(xml);
			logger.info("rmi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
