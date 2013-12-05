package com.pacifico.telebusca.dao;

import java.util.List;

import com.pacifico.telebusca.dominio.Audio;

/**
 * 
 * @author lcastro
 * 
 */
public interface AudioDAO {

	void guardarAudio(Audio audio);

	List<Audio> buscarAudios(Audio audio,Integer firstIndex , Integer maxNumber);
	
	int buscarContarAudios(Audio audio);
	int buscarTest(String fech, String fech1);
}
