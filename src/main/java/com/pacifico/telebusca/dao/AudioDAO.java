package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import com.pacifico.telebusca.dominio.Audio;

public interface AudioDAO {
	
	void guardarAudio (Audio audio);
	List buscarAudios(final Serializable nombre);

}
