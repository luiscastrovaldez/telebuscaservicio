package com.pacifico.telebusca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.stereotype.Repository;

import com.pacifico.telebusca.dominio.Audio;

/**
 * 
 * @author lcastro
 * 
 */
@Repository
public class AudioDAOImpl extends HibernateJpaDialect implements AudioDAO {

	private static Logger logger = Logger.getLogger(AudioDAOImpl.class);
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(name = "teleBuscaPersistence")
	private EntityManager em;

	public void guardarAudio(Audio audio) {
		this.em.persist(audio);
		this.em.flush();

	}

	public List<Audio> buscarAudios(Audio audio,Integer firstIndex , Integer maxNumber ) {
		StringBuffer sql = new StringBuffer(
				"select a from Audio a  where fecVenta between :start_date and :end_date");

		if (audio.getDniCliente() != null && !"".equals(audio.getDniCliente())) {
			sql.append(" and dniCliente = :dniCliente");					
		}

		if (audio.getApellidoMaterno() != null
				&& !"".equals(audio.getApellidoMaterno())) {
			sql.append(" and apellidoMaterno = :apellidoMaterno");			
		}
		if (audio.getApellidoPaterno() != null
				&& !"".equals(audio.getApellidoPaterno())) {
			sql.append(" and apellidoPaterno = :apellidoPaterno");			
		}
		if (audio.getTelefonoNumeroCliente() != null
				&& !"".equals(audio.getTelefonoNumeroCliente())) {
			sql.append(" and telefonoNumeroCliente = :telefonoNumeroCliente");
		}
		if (audio.getNombresCliente() != null
				&& !"".equals(audio.getNombresCliente())) {
			sql.append(" and nombrescliente = :nombrescliente");
		}
		if (audio.getProceso() != null && !"".equals(audio.getProceso())) {
			sql.append(" and proceso = :proceso");
		}
		if (audio.getDniAsesor() != null && !"".equals(audio.getDniAsesor())) {
			sql.append(" and dniasesor = :dniasesor");
		}
		if (audio.getVdn() != null && !"".equals(audio.getVdn())) {
			sql.append(" and vdn = :vdn");
		}
		if (audio.getSkill() != null && !"".equals(audio.getSkill())) {
			sql.append(" and skill = :skill");
		}
		if (audio.getCodEmpresa() != 0
				&& !"".equals(Integer.toString(audio.getCodEmpresa()))) {
			sql.append(" and codempresa = :codempresa");
		}

		Query query = em.createQuery(sql.toString());
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxNumber);
		
		query.setParameter("start_date", audio.getFechaInicial() + " "
				+ audio.getHoraInicial());
		query.setParameter("end_date", audio.getFechaFinal() + " "
				+ audio.getHoraFinal());

		if (audio.getDniCliente() != null && !"".equals(audio.getDniCliente())) {
			query.setParameter("dniCliente", audio.getDniCliente());
		}

		if (audio.getApellidoMaterno() != null
				&& !"".equals(audio.getApellidoMaterno())) {
			query.setParameter("apellidoMaterno", audio.getApellidoMaterno());			
		}
		if (audio.getApellidoPaterno() != null
				&& !"".equals(audio.getApellidoPaterno())) {
			query.setParameter("apellidoPaterno", audio.getApellidoPaterno());			
		}
		if (audio.getTelefonoNumeroCliente() != null
				&& !"".equals(audio.getTelefonoNumeroCliente())) {
			query.setParameter("telefonoNumeroCliente", audio
					.getTelefonoNumeroCliente());
		}
		if (audio.getNombresCliente() != null
				&& !"".equals(audio.getNombresCliente())) {
			query.setParameter("nombrescliente", audio.getNombresCliente());
		}
		if (audio.getProceso() != null && !"".equals(audio.getProceso())) {
			query.setParameter("proceso", audio.getProceso());
		}
		if (audio.getDniAsesor() != null && !"".equals(audio.getDniAsesor())) {
			query.setParameter("dniasesor", audio.getDniAsesor());
		}
		if (audio.getVdn() != null && !"".equals(audio.getVdn())) {
			query.setParameter("vdn", audio.getVdn());
		}
		if (audio.getSkill() != null && !"".equals(audio.getSkill())) {
			query.setParameter("skill", audio.getSkill());
		}
		if (audio.getCodEmpresa() != 0
				&& !"".equals(Integer.toString(audio.getCodEmpresa()))) {
			query.setParameter("codempresa", audio.getCodEmpresa());
		}

		return (List<Audio>) query.getResultList();
	}
	
	public int buscarContarAudios(Audio audio) {
		StringBuffer sql = new StringBuffer(
				"select a from Audio a  where fecVenta between :start_date and :end_date");

		if (audio.getDniCliente() != null && !"".equals(audio.getDniCliente())) {
			sql.append(" and dniCliente = :dniCliente");					
		}

		if (audio.getApellidoMaterno() != null
				&& !"".equals(audio.getApellidoMaterno())) {
			sql.append(" and apellidoMaterno = :apellidoMaterno");			
		}
		if (audio.getApellidoPaterno() != null
				&& !"".equals(audio.getApellidoPaterno())) {
			sql.append(" and apellidoPaterno = :apellidoPaterno");			
		}
		if (audio.getTelefonoNumeroCliente() != null
				&& !"".equals(audio.getTelefonoNumeroCliente())) {
			sql.append(" and telefonoNumeroCliente = :telefonoNumeroCliente");
		}
		if (audio.getNombresCliente() != null
				&& !"".equals(audio.getNombresCliente())) {
			sql.append(" and nombrescliente = :nombrescliente");
		}
		if (audio.getProceso() != null && !"".equals(audio.getProceso())) {
			sql.append(" and proceso = :proceso");
		}
		if (audio.getDniAsesor() != null && !"".equals(audio.getDniAsesor())) {
			sql.append(" and dniasesor = :dniasesor");
		}
		if (audio.getVdn() != null && !"".equals(audio.getVdn())) {
			sql.append(" and vdn = :vdn");
		}
		if (audio.getSkill() != null && !"".equals(audio.getSkill())) {
			sql.append(" and skill = :skill");
		}
		if (audio.getCodEmpresa() != 0
				&& !"".equals(Integer.toString(audio.getCodEmpresa()))) {
			sql.append(" and codempresa = :codempresa");
		}
		//sql.append(" group by codAudio ");
		Query query = em.createQuery(sql.toString());		
		
		query.setParameter("start_date", audio.getFechaInicial() + " "
				+ audio.getHoraInicial());
		query.setParameter("end_date", audio.getFechaFinal() + " "
				+ audio.getHoraFinal());

		if (audio.getDniCliente() != null && !"".equals(audio.getDniCliente())) {
			query.setParameter("dniCliente", audio.getDniCliente());
		}

		if (audio.getApellidoMaterno() != null
				&& !"".equals(audio.getApellidoMaterno())) {
			query.setParameter("apellidoMaterno", audio.getApellidoMaterno());			
		}
		if (audio.getApellidoPaterno() != null
				&& !"".equals(audio.getApellidoPaterno())) {
			query.setParameter("apellidoPaterno", audio.getApellidoPaterno());			
		}
		if (audio.getTelefonoNumeroCliente() != null
				&& !"".equals(audio.getTelefonoNumeroCliente())) {
			query.setParameter("telefonoNumeroCliente", audio
					.getTelefonoNumeroCliente());
		}
		if (audio.getNombresCliente() != null
				&& !"".equals(audio.getNombresCliente())) {
			query.setParameter("nombrescliente", audio.getNombresCliente());
		}
		if (audio.getProceso() != null && !"".equals(audio.getProceso())) {
			query.setParameter("proceso", audio.getProceso());
		}
		if (audio.getDniAsesor() != null && !"".equals(audio.getDniAsesor())) {
			query.setParameter("dniasesor", audio.getDniAsesor());
		}
		if (audio.getVdn() != null && !"".equals(audio.getVdn())) {
			query.setParameter("vdn", audio.getVdn());
		}
		if (audio.getSkill() != null && !"".equals(audio.getSkill())) {
			query.setParameter("skill", audio.getSkill());
		}
		if (audio.getCodEmpresa() != 0
				&& !"".equals(Integer.toString(audio.getCodEmpresa()))) {
			query.setParameter("codempresa", audio.getCodEmpresa());
		}
		List lista = (List)query.getResultList();
		int total = 0;
		if (lista != null && lista.size() > 0){
			total = lista.size();
		}
		
		return total;
	}


}
