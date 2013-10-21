package com.pacifico.telebusca.servicio.xml.dominio;

import java.io.Serializable;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "Registros")
public class Registros implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ElementList(inline = true, name = "Llamadas")
	private List<Llamada> llamadas;

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(List<Llamada> llamadas) {
		this.llamadas = llamadas;
	}

}
