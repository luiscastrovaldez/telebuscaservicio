package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.pacifico.telebusca.dominio.Empresa;

public class EmpresaDAOImpl implements EmpresaDAO {

	@PersistenceContext(name="teleBuscaPersistence")
	private EntityManager em;

	public void guardarEmpresa(Empresa empresa) {
		em.persist(empresa);
		em.flush();
	}

	public Empresa actualizarEmpresa(Empresa empresa) {
		return (Empresa) em.merge(empresa);
	}

	public Empresa buscarEmpresaPorCodigo(Serializable codEmpresa) {
		return em.find(Empresa.class, codEmpresa);
	}

	
	@SuppressWarnings("unchecked")
	public List<Empresa> buscarEmpresaPorNombre(Serializable nombreEmpresa) {
		Query query = em
				.createQuery("select c from Empresa c where c.nombreEmpresa=:nombreEmpresa");
		query.setParameter("nombreEmpresa", nombreEmpresa);

		return (List<Empresa>)query.getResultList();
	}

	public void eliminarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub

	}

}
