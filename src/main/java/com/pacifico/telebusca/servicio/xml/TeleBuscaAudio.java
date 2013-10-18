package com.pacifico.telebusca.servicio.xml;

import java.io.File;
import java.util.List;

import com.pacifico.telebusca.web.beans.ValidacionErrores;

public interface TeleBuscaAudio {

	ValidacionErrores parseaFileXml(File xml);
	List<Object> parseaFileXml(String xml);
	void escucharAudio();
	void descargarAudio();
	ValidacionErrores validarArchivoXml(File xml);
	void descargarArchivoResgistroNoValidos();
	ValidacionErrores validarArchivoXml(String xml);
}
