package com.pacifico.telebusca.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dao.AudioDAO;
import com.pacifico.telebusca.dominio.Audio;


@Service("audioServicio")
@Transactional
public class AudioServicioImpl implements AudioServicio {

	@Autowired
	private AudioDAO audioDAO;
	
	public void guardarAudio(Audio audio) {
		// TODO Auto-generated method stub

	}
	
	public List<Audio> buscarAudios( Audio audio,String start_date, String end_date ) {
		// TODO Auto-generated method stub
		return this.audioDAO.buscarAudios(audio, start_date, end_date);
	}

}
