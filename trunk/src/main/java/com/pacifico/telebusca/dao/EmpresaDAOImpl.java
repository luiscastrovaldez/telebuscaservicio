package com.pacifico.telebusca.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dominio.Empresa;


public class EmpresaDAOImpl implements EmpresaDAO {

	
	@PersistenceContext  //Inyecta el EntityManager aqui
	private EntityManager em;

	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void guardarEmpresa(Empresa empresa) {		
		em.persist(empresa);
		em.flush();
	}

	public Empresa actualizarEmpresa(Empresa empresa) {		
		return (Empresa)em.merge(empresa);
	}

	public Empresa buscarEmpresa(Serializable pkEmpresa) {
		return em.find(Empresa.class, pkEmpresa);
	}

}
