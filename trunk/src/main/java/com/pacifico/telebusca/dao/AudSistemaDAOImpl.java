package com.pacifico.telebusca.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.pacifico.telebusca.dominio.AudSistema;

public class AudSistemaDAOImpl implements AudSistemaDAO {

	
	@PersistenceContext(name="teleBuscaPersistence")
	private EntityManager em;
	
	public void guardaAudSistema(AudSistema audSistema) {		
		em.persist(audSistema);
		em.flush();
	}

}
