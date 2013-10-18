package com.pacifico.telebusca.servicio.xml.dominio;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.convert.Convert;

import com.pacifico.telebusca.servicio.xml.LlamadaConverter;

public class Llamada {

	@ElementListUnion({
			@ElementList(entry = "Empresa", type = String.class, inline = true),
			@ElementList(entry = "DNICliente", type = String.class, inline = true),
			@ElementList(entry = "ApellidoPaternoCliente", type = String.class, inline = true),
			@ElementList(entry = "ApellidoMaternoCliente", type = String.class, inline = true),
			@ElementList(entry = "NombresCliente", type = String.class, inline = true),
			@ElementList(entry = "TelefonoCliente", type = String.class, inline = true),
			@ElementList(entry = "FechaVenta", type = String.class, inline = true),
			@ElementList(entry = "HoraVenta", type = String.class, inline = true),
			@ElementList(entry = "DNIAsesor", type = String.class, inline = true),
			@ElementList(entry = "Proceso", type = String.class, inline = true),
			@ElementList(entry = "VDN", type = String.class, inline = true),
			@ElementList(entry = "Skill", type = String.class, inline = true),
			@ElementList(entry = "RutaAudio", type = String.class, inline = true) })
			@Convert(LlamadaConverter.class)
	private List<Object> list;

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

}
