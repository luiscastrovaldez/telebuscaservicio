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

	List<Audio> buscarAudios(Audio audio);

}
