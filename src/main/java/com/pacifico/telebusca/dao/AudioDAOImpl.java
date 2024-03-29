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
				"select A.* from USTLV100.Audio A "				
				+ " where to_char(A.fecVenta,'YYYY-MM-DD HH24:MI:SS') "
				+ " between to_char(to_date(:start_date,'YYYY-MM-DD HH24:MI'),'YYYY-MM-DD HH24:MI') and to_char(to_date(:end_date,'YYYY-MM-DD HH24:MI'),'YYYY-MM-DD HH24:MI')");
		
		if (audio.getDniCliente() != null && !"".equals(audio.getDniCliente())) {
			sql.append(" and DNICLI = :dniCliente");					
		}

		if (audio.getApellidoMaterno() != null
				&& !"".equals(audio.getApellidoMaterno())) {
			sql.append(" and LOWER(APEMATCLI) = LOWER(:apellidoMaterno)");			
		}
		if (audio.getApellidoPaterno() != null
				&& !"".equals(audio.getApellidoPaterno())) {
			sql.append(" and LOWER(APEPATCLI) = LOWER(:apellidoPaterno)");			
		}
		if (audio.getTelefonoNumeroCliente() != null
				&& !"".equals(audio.getTelefonoNumeroCliente())) {
			sql.append(" and TLFNOCLI = :telefonoNumeroCliente");
		}
		if (audio.getNombresCliente() != null
				&& !"".equals(audio.getNombresCliente())) {
			sql.append(" and LOWER(NOMCLI) = LOWER(:nombrescliente)");
		}
		if (audio.getProceso() != null && !"".equals(audio.getProceso())) {
			sql.append(" and PROC = :proceso");
		}
		if (audio.getDniAsesor() != null && !"".equals(audio.getDniAsesor())) {
			sql.append(" and DNIASESOR = :dniasesor");
		}
		if (audio.getVdn() != null && !"".equals(audio.getVdn())) {
			sql.append(" and VDN = :vdn");
		}
		if (audio.getSkill() != null && !"".equals(audio.getSkill())) {
			sql.append(" and SKILL = :skill");
		}
		if (audio.getCodEmpresa() != 0
				&& !"".equals(Integer.toString(audio.getCodEmpresa()))) {
			sql.append(" and A.CODEMPRESA = :codempresa ");
		} else {
			sql.append(" and A.CODEMPRESA in (:codempresa) ");
		}
		
		sql.append(" order by to_char(fecVenta,'YYYY-MM-DD HH24:MI:SS') desc");
		

		Query query = em.createNativeQuery(sql.toString(),Audio.class);
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
		} else {
			query.setParameter("codempresa", audio.getCadena());
		}

		return (List<Audio>) query.getResultList();
	}
	
	public int buscarTest(String fech, String fech1){
		StringBuffer sql = new StringBuffer(
				"select * from USTLV100.Audio where to_char(fecVenta,'YYYY-MM-DD HH24:MI:SS') between :start_date and :end_date");
		Query query = em.createNativeQuery(sql.toString(),Audio.class);
		query.setParameter("start_date", fech);
		query.setParameter("end_date", fech1 );
		List lista = (List)query.getResultList();
		return 1;
	}
	
	public int buscarContarAudios(Audio audio) {
		StringBuffer sql = new StringBuffer(
				"select A.* from USTLV100.Audio A "				
				+ " where to_char(A.fecVenta,'YYYY-MM-DD HH24:MI:SS') "
				+ " between to_char(to_date(:start_date,'YYYY-MM-DD HH24:MI'),'YYYY-MM-DD HH24:MI') and to_char(to_date(:end_date,'YYYY-MM-DD HH24:MI'),'YYYY-MM-DD HH24:MI')");


		if (audio.getDniCliente() != null && !"".equals(audio.getDniCliente())) {
			sql.append(" and A.DNICLI = :dniCliente ");					
		}

		if (audio.getApellidoMaterno() != null
				&& !"".equals(audio.getApellidoMaterno())) {
			sql.append(" and LOWER(A.APEMATCLI) = LOWER(:apellidoMaterno) ");			
		}
		if (audio.getApellidoPaterno() != null
				&& !"".equals(audio.getApellidoPaterno())) {
			sql.append(" and LOWER(A.APEPATCLI) = LOWER(:apellidoPaterno) ");			
		}
		if (audio.getTelefonoNumeroCliente() != null
				&& !"".equals(audio.getTelefonoNumeroCliente())) {
			sql.append(" and A.TLFNOCLI = :telefonoNumeroCliente ");
		}
		if (audio.getNombresCliente() != null
				&& !"".equals(audio.getNombresCliente())) {
			sql.append(" and LOWER(A.NOMCLI) = LOWER(:nombrescliente) ");
		}
		if (audio.getProceso() != null && !"".equals(audio.getProceso())) {
			sql.append(" and A.PROC = :proceso ");
		}
		if (audio.getDniAsesor() != null && !"".equals(audio.getDniAsesor())) {
			sql.append(" and A.DNIASESOR = :dniasesor ");
		}
		if (audio.getVdn() != null && !"".equals(audio.getVdn())) {
			sql.append(" and A.VDN = :vdn ");
		}
		if (audio.getSkill() != null && !"".equals(audio.getSkill())) {
			sql.append(" and A.SKILL = :skill ");
		}
		if (audio.getCodEmpresa() != 0
				&& !"".equals(Integer.toString(audio.getCodEmpresa()))) {
			sql.append(" and A.CODEMPRESA = :codempresa ");
		} else {
			sql.append(" and A.CODEMPRESA in (:codempresa) ");
		}

		Query query = em.createNativeQuery(sql.toString(),Audio.class);		
		
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
		} else {
			query.setParameter("codempresa", audio.getCadena());
		}
		List lista = (List)query.getResultList();
		int total = 0;
		if (lista != null && lista.size() > 0){
			total = lista.size();
		}
		
		return total;
	}


}
