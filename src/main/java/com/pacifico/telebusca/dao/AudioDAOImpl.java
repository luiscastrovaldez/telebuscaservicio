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
		StringBuffer sql = new StringBuffer("select a,c from Audio a,  where fechaVenta between :start_date and :end_date");
		Query query = em.createQuery(sql.toString());
		query.setParameter("start_date", start_date);
		query.setParameter("end_date", end_date);
		
		if (audio.getDniCliente() != null && !"".equals(audio.getDniCliente())){			
			sql.append(" and dniCliente = :dniCliente");
			query = em.createQuery(sql.toString());
			query.setParameter("dniCliente", audio.getDniCliente());	
		}
		
		if (audio.getApellidoMaterno() != null && !"".equals(audio.getApellidoMaterno())){			
			sql.append(" and apellidoMaterno = :apellidoMaterno");
			query = em.createQuery(sql.toString());
			query.setParameter("apellidoPaterno", audio.getApellidoMaterno());	
		}
		if(audio.getApellidoPaterno() != null && !"".equals(audio.getApellidoPaterno())){
			sql.append(" and apellidoPaterno = :apellidoPaterno");
			query = em.createQuery(sql.toString());
			query.setParameter("apellidoMaterno", audio.getApellidoPaterno());
		}
		if(audio.getTelefonoNumeroCliente() != null && !"".equals(audio.getTelefonoNumeroCliente())){
			sql.append(" and telefonoNumeroCliente = :telefonoNumeroCliente");
			query = em.createQuery(sql.toString());
			query.setParameter("telefonoNumeroCliente", audio.getTelefonoNumeroCliente());
		}
		if(audio.getNombresCliente() != null && !"".equals(audio.getNombresCliente())){
			sql.append(" and nombrescliente = :nombrescliente");
			query = em.createQuery(sql.toString());
			query.setParameter("nombrescliente", audio.getNombresCliente());
		}
		if(audio.getProceso() != null && !"".equals(audio.getProceso())){
			sql.append(" and proceso = :proceso");
			query = em.createQuery(sql.toString());
			query.setParameter("proceso", audio.getProceso());
		}
		if(audio.getDniAsesor() != null && !"".equals(audio.getDniAsesor())){
			sql.append(" and dniasesor = :dniasesor");
			query = em.createQuery(sql.toString());
			query.setParameter("dniasesor", audio.getDniAsesor());
		}
		if(audio.getVdn() != null && !"".equals(audio.getVdn())){
			sql.append(" and vdn = :vdn");
			query = em.createQuery(sql.toString());
			query.setParameter("vdn", audio.getVdn());
		}
		if(audio.getSkill() != null && !"".equals(audio.getSkill())){
			sql.append(" and skill = :skill");
			query = em.createQuery(sql.toString());
			query.setParameter("skill", audio.getSkill());
		}
		
		
		return (List<Audio>)query.getResultList();
	}
	

}
