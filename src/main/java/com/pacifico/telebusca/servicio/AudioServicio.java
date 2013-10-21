package com.pacifico.telebusca.servicio;

import java.util.List;

import com.pacifico.telebusca.dominio.Audio;

public interface AudioServicio {

	void guardarAudio(Audio audio);

	List<Audio> buscarAudios(Audio audio, String start_date, String end_date);

}
