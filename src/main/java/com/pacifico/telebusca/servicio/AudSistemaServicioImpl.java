package com.pacifico.telebusca.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dao.AudSistemaDAO;
import com.pacifico.telebusca.dominio.AudSistema;

@Service("audSistemaServicio")
@Transactional
public class AudSistemaServicioImpl implements AudSistemaServicio {

	@Autowired
	private AudSistemaDAO audSistemaDAO;

	public void guardaAudSistema(AudSistema audSistema) {
		this.audSistemaDAO.guardaAudSistema(audSistema);
	}

}
