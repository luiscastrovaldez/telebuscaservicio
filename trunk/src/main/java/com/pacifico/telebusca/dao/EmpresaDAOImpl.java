package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.stereotype.Repository;

import com.pacifico.telebusca.dominio.Empresa;

/**
 * 
 * @author lcastro
 * 
 */
@Repository
public class EmpresaDAOImpl extends HibernateJpaDialect implements EmpresaDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(name = "teleBuscaPersistence")
	private EntityManager em;

	public void guardarEmpresa(Empresa empresa) {
		this.em.persist(empresa);
		this.em.flush();
	}

	public Empresa actualizarEmpresa(Empresa empresa) {
		return (Empresa) em.merge(empresa);
	}

	public Empresa buscarEmpresaPorCodigo(Serializable codEmpresa) {
		return em.find(Empresa.class, codEmpresa);
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> listarEmpresas() {
		Query query = em.createQuery("select c from Empresa c");

		return (List<Empresa>) query.getResultList();
	}
	
	public List<Empresa> buscarEmpresas(Integer firstIndex , Integer maxNumber) {
		Query query = em.createQuery("select c from Empresa c");
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxNumber);
		return (List<Empresa>) query.getResultList();
	}
	
	public int buscarContarEmpresas() {
		Query query = em.createQuery("select c from Empresa c");
		
		List lista = (List)query.getResultList();
		int total = 0;
		if (lista != null && lista.size() > 0){
			total = lista.size();
		}
		return total;
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> buscarEmpresaPorNombre(Serializable nombreEmpresa) {
		Query query = em
				.createQuery("select c from Empresa c where c.nombreEmpresa=:nombreEmpresa");
		query.setParameter("nombreEmpresa", nombreEmpresa);

		return (List<Empresa>) query.getResultList();
	}

	public void eliminarEmpresa(int codEmpresa) {
		Query query = em
				.createQuery("delete from Empresa b where b.codEmpresa = :codEmpresa ");
		query.setParameter("codEmpresa", codEmpresa);
		query.executeUpdate();
	}

}
