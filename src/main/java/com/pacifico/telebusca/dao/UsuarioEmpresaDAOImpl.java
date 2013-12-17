package com.pacifico.telebusca.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.stereotype.Repository;

import com.pacifico.telebusca.dominio.Empresa;
import com.pacifico.telebusca.dominio.UsuarioEmpresa;

/**
 * 
 * @author lcastro
 * 
 */
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

	public void eliminarUsuarioEmpresaByCodEmpresa(int codEmpresa) {
		Query query = em
				.createQuery("delete from UsuarioEmpresa b where b.codEmpresa = :codEmpresa ");
		query.setParameter("codEmpresa", codEmpresa);
		query.executeUpdate();
	}

	public void eliminarUsuarioEmpresaByNombreUsuario(String nombreUsuario) {
		Query query = em
				.createQuery("delete from UsuarioEmpresa b where b.usuario = :nombreUsuario ");
		query.setParameter("nombreUsuario", nombreUsuario);
		query.executeUpdate();
	}
	
	public List<UsuarioEmpresa> buscarUsuarioEmpresaByNombreUsuario(String nombreUsuario) {
		Query query = em
				.createQuery("select b from UsuarioEmpresa b where b.usuario = :nombreUsuario ");
		query.setParameter("nombreUsuario", nombreUsuario);
		return (List<UsuarioEmpresa>) query.getResultList();
	}

	public UsuarioEmpresa buscarUsuarioEmpresaPorId(
			Serializable pkUsuarioEmpresa) {
		return em.find(UsuarioEmpresa.class, pkUsuarioEmpresa);
	}

	public List<Empresa> listarUsuariosyEmpresasByNombreUsuario(
			String nombreUsuario) {
		Query query = em
				.createQuery("select a from Empresa a, UsuarioEmpresa b where a.codEmpresa = b.codEmpresa "
						+ "and b.usuario =:nombreUsuario");
		query.setParameter("nombreUsuario", nombreUsuario);
		return (List<Empresa>) query.getResultList();
	}

	/*public List<UsuariosEmpresasBean> listarUsuariosyEmpresasByNombreUsuarioAndCodEmpresa(
			String nombreUsuario, int codEmpresa) {
		Query query = em
				.createQuery("select new com.pacifico.telebusca.web.beans.UsuariosEmpresasBean(a,b) "
						+ "from Empresa a, UsuarioEmpresa b where a.codEmpresa = b.codEmpresa "
						+ "and b.usuario =:nombreUsuario and a.codEmpresa =:codEmpresa");
		query.setParameter("nombreUsuario", nombreUsuario);
		query.setParameter("codEmpresa", codEmpresa);
		return (List<UsuariosEmpresasBean>) query.getResultList();
	}*/

	public List<UsuarioEmpresa> listarUsuariosyEmpresasAsignadas() {
		Query query = em
				.createQuery("select b from Empresa a, UsuarioEmpresa b where a.codEmpresa = b.codEmpresa");
		return (List<UsuarioEmpresa>) query.getResultList();
	}
	
	public List<Empresa> listarUsuariosyEmpresasAsignadasyPorAsignar(String nombreUsuario) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT A.CODEMPRESA as codEmpresa,A.NOM as nombreEmpresa,B.USR as usuario,B.CODEMPRESA as codEmpresa1 FROM EMPRESA A LEFT JOIN USUARIO_EMPRESA B ON A.CODEMPRESA = B.CODEMPRESA "
				+ " WHERE lower(B.USR) = lower(:usuario) or lower(B.USR) is null");
		Query query = em.createNativeQuery(sql.toString());
		query.setParameter("usuario", nombreUsuario);
		List<Object> objectos = query.getResultList();
		List<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa = null;
		for (Iterator iterator = objectos.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			BigDecimal cod = (BigDecimal)object[0];
			String nombreEmpresa = (String)object[1];
			String usuario = (String)object[2];
			BigDecimal cod1 = (BigDecimal)object[3];
			empresa = new Empresa(cod != null ? cod.intValue() : 0, nombreEmpresa != null ? nombreEmpresa : "", usuario != null ? usuario : "",cod1 != null ? cod1.intValue() : 0);
			empresas.add(empresa);
		}
		
		return  empresas;
	}
	
	public List<Empresa> listarUsuariosyEmpresasAsignadasyPorAsignar() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT A.CODEMPRESA as codEmpresa,A.NOM as nombreEmpresa,B.USR as usuario,B.CODEMPRESA as codEmpresa1 FROM EMPRESA A LEFT JOIN USUARIO_EMPRESA B ON A.CODEMPRESA = B.CODEMPRESA ");
		Query query = em.createNativeQuery(sql.toString());
		
		List<Object> objectos = query.getResultList();
		List<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa = null;
		for (Iterator iterator = objectos.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			BigDecimal cod = (BigDecimal)object[0];
			String nombreEmpresa = (String)object[1];
			String usuario = (String)object[2];
			BigDecimal cod1 = (BigDecimal)object[3];
			empresa = new Empresa(cod != null ? cod.intValue() : 0, nombreEmpresa != null ? nombreEmpresa : "", usuario != null ? usuario : "",cod1 != null ? cod1.intValue() : 0);
			empresas.add(empresa);
		}
		
		return  empresas;
	}
	
	

	public int buscarContarUsuarioEmpresas() {
		Query query = em
				.createQuery("select b from Empresa a, UsuarioEmpresa b where a.codEmpresa = b.codEmpresa");
		List lista = (List)query.getResultList();
		int total = 0;
		if (lista != null && lista.size() > 0){
			total = lista.size();
		}
		return total;
	}

	public List<UsuarioEmpresa> buscarUsuarioEmpresas(Integer firstIndex,
			Integer maxNumber) {
		Query query = em
				.createQuery("select b from Empresa a, UsuarioEmpresa b where a.codEmpresa = b.codEmpresa");
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxNumber);
		return (List<UsuarioEmpresa>)query.getResultList();
	}

	

}
