package com.pacifico.telebusca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

import com.pacifico.telebusca.dominio.Audio;
import com.pacifico.telebusca.dominio.Empresa;

public class AudioDAOImpl extends HibernateJpaDialect implements AudioDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(name="teleBuscaPersistence")
	private EntityManager em;
	

	public void guardarAudio(Audio audio) {
		// TODO Auto-generated method stub
		
	}

	public List<Audio> buscarAudios(Audio audio, String start_date, String end_date) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("select a from Audio a where fechaVenta between :start_date and :end_date");
		Query query = em.createQuery(sql.toString());
		query.setParameter("start_date", start_date);
		query.setParameter("end_date", end_date);
		
		if (audio.getDniCliente() != null && !"".equals(audio.getDniCliente())){			
			sql.append(" and dniCliente = :dniCliente");
			query = em.createQuery(sql.toString());
			query.setParameter("dniCliente", audio.getDniCliente());	
		}
		
		if (audio.getApellidoMaterno() != null && !"".equals(audio.getApellidoMaterno())){			
			sql.append(" and apellidoPaterno = :apellidoPaterno");
			query = em.createQuery(sql.toString());
			query.setParameter("apellidoPaterno", audio.getApellidoMaterno());	
		}
		
		
		return (List<Audio>)query.getResultList();
	}
	

}
