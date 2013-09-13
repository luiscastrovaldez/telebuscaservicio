package com.pacifico.telebusca.servicio.xml;

import java.util.Iterator;
import java.util.List;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.stereotype.Service;

import com.pacifico.telebusca.servicio.xml.dominio.Llamada;
import com.pacifico.telebusca.servicio.xml.dominio.Registros;

@Service("teleBuscaAudio")
public class TeleBuscaAudioImpl implements TeleBuscaAudio {

	private Serializer serializer = new Persister();

	public List<Object> parseaFileXml(String xml) {
		try {
			Registros registros = this.serializer.read(Registros.class, xml);
			List<Llamada> llamadas = registros.getLlamadas();

			for (Iterator iterator = llamadas.iterator(); iterator.hasNext();) {
				Llamada llamada = (Llamada) iterator.next();
				List<Object> elementos = llamada.getList();

				for (Iterator iterator1 = elementos.iterator(); iterator1
						.hasNext();) {
					String elemento = (String) iterator1.next();
					System.out.println("elementos = " + elemento);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
