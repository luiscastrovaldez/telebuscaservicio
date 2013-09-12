package com.pacifico.telebusca.dao;

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

}
