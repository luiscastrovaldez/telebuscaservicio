package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pacifico.telebusca.dominio.UsuarioEmpresa;


public class UsuarioEmpresaDAOImpl implements UsuarioEmpresaDAO {

	
	@PersistenceContext  //Inyecta el EntityManager aqui
	private EntityManager em;

	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void guardarEmpresa(UsuarioEmpresa usuarioempresa) {		
		em.persist(usuarioempresa);
		em.flush();
	}

	public UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa) {		
		return (UsuarioEmpresa)em.merge(usuarioempresa);
	}

	public UsuarioEmpresa buscarUsuarioEmpresaById(Serializable pkUsuarioEmpresa) {
		return em.find(UsuarioEmpresa.class, pkUsuarioEmpresa);
	}

	public List buscarUsuarioEmpresaByNombre(Serializable nombre) {
		Query query = em.createQuery("select c from Empresa c where c.empresa=:nombre");
		query.setParameter("nombre", nombre);
				
		return query.getResultList();
	}

}
