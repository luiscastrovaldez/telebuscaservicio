package com.pacifico.telebusca.servicio.xml;

import java.io.File;
import java.util.List;

import com.pacifico.telebusca.web.beans.ValidacionErrores;

public interface TeleBuscaAudio {

	void escucharAudio() throws Exception;

	File descargarAudio(int codEmpresa, String path) throws Exception;
	File descargarAudio(String path) throws Exception;

	ValidacionErrores validarArchivoXml(File xml) throws Exception;

	File descargarArchivoResgistroNoValidos(List<Object> llamadas)
			throws Exception;

}
