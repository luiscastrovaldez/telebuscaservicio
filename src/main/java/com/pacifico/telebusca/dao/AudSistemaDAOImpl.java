package com.pacifico.telebusca.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

import com.pacifico.telebusca.dominio.AudSistema;

public class AudSistemaDAOImpl extends HibernateJpaDialect implements AudSistemaDAO {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="teleBuscaPersistence")
	private EntityManager em;
	
	public void guardaAudSistema(AudSistema audSistema) {		
		em.persist(audSistema);
		em.flush();
	}

}
