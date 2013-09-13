package com.pacifico.telebusca.servicio.xml.dominio;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;



@Root(name = "Registros")
public class Registros {

	@ElementList(entry = "Llamada", inline = true)
	private ArrayList<Llamada> llamadas;

	public ArrayList<Llamada> getLlamadas() {
		return llamadas;
	}

	public void setLlamadas(final ArrayList<Llamada> llamadas) {
		this.llamadas = llamadas;
	}
	
	
}
