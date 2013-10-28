package com.pacifico.telebusca.servicio;

import java.util.List;

import com.pacifico.telebusca.dominio.Audio;

public interface AudioServicio {

	void guardarAudios(List<Object> llamadas, String nombreUsuario);

	List<Audio> buscarAudios(Audio audio);

}
