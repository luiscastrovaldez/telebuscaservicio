package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.stereotype.Repository;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;
import com.pacifico.telebusca.web.beans.UsuariosEmpresasBean;

@Repository
public class UsuarioEmpresaDAOImpl extends HibernateJpaDialect implements
		UsuarioEmpresaDAO {

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	public void guardarUsuarioEmpresa(UsuarioEmpresa usuarioempresa) {
		this.em.persist(usuarioempresa);
		this.em.flush();
	}

	public UsuarioEmpresa actualizarUsuarioEmpresa(UsuarioEmpresa usuarioempresa) {
		return (UsuarioEmpresa) em.merge(usuarioempresa);
	}
	
	public void eliminarUsuarioEmpresaByCodEmpresa(int codEmpresa){
		Query query = em
		.createQuery("delete from UsuarioEmpresa b where b.codEmpresa = :codEmpresa ");
		query.setParameter("codEmpresa", codEmpresa);
		query.executeUpdate();
	}
	
	public void eliminarUsuarioEmpresaByNombreUsuario(String nombreUsuario){
		Query query = em
		.createQuery("delete from UsuarioEmpresa b where b.usuario = :nombreUsuario ");
		query.setParameter("nombreUsuario", nombreUsuario);
		query.executeUpdate();
	}

	public UsuarioEmpresa buscarUsuarioEmpresaPorId(
			Serializable pkUsuarioEmpresa) {
		return em.find(UsuarioEmpresa.class, pkUsuarioEmpresa);
	}

	public List<Empresa> listarUsuariosyEmpresasByNombreUsuario(String nombreUsuario) {
		Query query = em
				.createQuery("select a from Empresa a, UsuarioEmpresa b where a.codEmpresa = b.codEmpresa "
						+ "and b.usuario =:nombreUsuario");
		query.setParameter("nombreUsuario", nombreUsuario);
		return (List<Empresa>) query.getResultList();
	}
	
	public List<UsuariosEmpresasBean> listarUsuariosyEmpresasByNombreUsuarioAndCodEmpresa(String nombreUsuario, int codEmpresa) {
		Query query = em
				.createQuery("select new com.pacifico.telebusca.web.beans.UsuariosEmpresasBean(a,b) from Empresa a, UsuarioEmpresa b where a.codEmpresa = b.codEmpresa "
						+ "and b.usuario =:nombreUsuario and a.codEmpresa =:codEmpresa");
		query.setParameter("nombreUsuario", nombreUsuario);
		query.setParameter("codEmpresa", codEmpresa);
		return (List<UsuariosEmpresasBean>) query.getResultList();
	}

	public List<UsuariosEmpresasBean> listarUsuariosyEmpresas() {
		Query query = em
				.createQuery("select new com.pacifico.telebusca.web.beans.UsuariosEmpresasBean(a,b) from Empresa a, UsuarioEmpresa b where a.codEmpresa = b.codEmpresa");

		return (List<UsuariosEmpresasBean>) query.getResultList();
	}
	
	public List<UsuariosEmpresasBean> listarUsuariosyEmpresas1() {
		Query query = em
				.createQuery("select new com.pacifico.telebusca.web.beans.UsuariosEmpresasBean(a,b) from Empresa a, UsuarioEmpresa b where a.codEmpresa != b.codEmpresa group by a.codEmpresa ");

		return (List<UsuariosEmpresasBean>) query.getResultList();
	}
	
	public List<UsuariosEmpresasBean> listarEmpresasAsignadasNoAsignadas() {
		Query query = em
				.createQuery("select a from UsuarioEmpresa as a " +
						"left outer join  a.codEmpresa  as empresa");

		return (List<UsuariosEmpresasBean>) query.getResultList();
	}

}
