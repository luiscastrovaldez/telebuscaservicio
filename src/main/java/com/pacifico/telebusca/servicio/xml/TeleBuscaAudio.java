package com.pacifico.telebusca.servicio.xml;

import java.util.List;

public interface TeleBuscaAudio {

	List<Object> parseaFileXml(String xml);
	void escucharAudio();
	void descargarAudio();
	void validarArchivoXml();
	void descargarArchivoResgistroNoValidos();
}
