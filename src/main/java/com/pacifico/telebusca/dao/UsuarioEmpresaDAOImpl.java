package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

import com.pacifico.telebusca.dominio.UsuarioEmpresa;

public class UsuarioEmpresaDAOImpl extends HibernateJpaDialect implements
		UsuarioEmpresaDAO {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	// Inyecta el EntityManager aqui
	private EntityManager em;

	public void guardarUsuarioEmpresa(UsuarioEmpresa usuarioempresa) {
		em.persist(usuarioempresa);
		em.flush();
	}

	public UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa) {
		return (UsuarioEmpresa) em.merge(usuarioempresa);
	}

	public UsuarioEmpresa buscarUsuarioEmpresaPorId(
			Serializable pkUsuarioEmpresa) {
		return em.find(UsuarioEmpresa.class, pkUsuarioEmpresa);
	}

	public List buscarUsuarioEmpresaPorNombre(Serializable nombre) {
		Query query = em
				.createQuery("select c from Empresa c where c.empresa=:nombre");
		query.setParameter("nombre", nombre);

		return query.getResultList();
	}

	public List listarUsuarioPorEmpresa() {
		// TODO Auto-generated method stub
		return null;
	}

}
