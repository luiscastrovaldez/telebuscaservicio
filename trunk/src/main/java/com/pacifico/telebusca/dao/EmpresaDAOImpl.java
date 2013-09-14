package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dominio.Empresa;


public class EmpresaDAOImpl implements EmpresaDAO {

	
	@PersistenceContext  //Inyecta el EntityManager aqui
	private EntityManager em;

	
	public void guardarEmpresa(Empresa empresa) {		
		em.persist(empresa);
		em.flush();
	}

	public Empresa actualizarEmpresa(Empresa empresa) {		
		return (Empresa)em.merge(empresa);
	}

	public Empresa buscarEmpresaPorId(Serializable pkEmpresa) {
		return em.find(Empresa.class, pkEmpresa);
	}

	public List buscarEmpresaPorNombre(Serializable nombre) {
		Query query = em.createQuery("select c from Empresa c where c.empresa=:nombre");
		query.setParameter("nombre", nombre);
				
		return query.getResultList();
	}

	public void eliminarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

}
