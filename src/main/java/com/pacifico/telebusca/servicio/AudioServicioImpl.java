package com.pacifico.telebusca.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dominio.Audio;
import com.pacifico.telebusca.dao.AudioDAO;


@Service("audioServicio")
public class AudioServicioImpl implements AudioServicio {

	private AudioDAO AudioDAO;
	
	public void guardarAudio(Audio audio) {
		// TODO Auto-generated method stub

	}
	@Transactional(readOnly = true)
	public List buscarAudios( Audio audio,String start_date, String end_date ) {
		// TODO Auto-generated method stub
		return this.AudioDAO.buscarAudios(audio, start_date, end_date);
	}

}
