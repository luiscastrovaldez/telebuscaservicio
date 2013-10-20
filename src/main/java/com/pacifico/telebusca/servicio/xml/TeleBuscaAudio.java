package com.pacifico.telebusca.servicio.xml;

import java.io.File;

import com.pacifico.telebusca.web.beans.ValidacionErrores;

public interface TeleBuscaAudio {

	void escucharAudio() throws Exception;

	File descargarAudio() throws Exception;

	ValidacionErrores validarArchivoXml(File xml) throws Exception;

	File descargarArchivoResgistroNoValidos() throws Exception;

}
