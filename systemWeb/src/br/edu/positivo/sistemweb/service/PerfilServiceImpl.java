package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.TransactionScoped;

import br.edu.positivo.sistemweb.entity.Perfil;

@Stateless
public class PerfilServiceImpl implements PerfilService {
	
	@PersistenceContext(unitName = "sistemaweb")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> listar() {
		Query query = em.createQuery("select f from Perfil f");
		return query.getResultList();
	}

	@Override
	public Perfil getPerfilById(Integer id) {
		return em.find(Perfil.class, id);
	}
	
	@Override
	public void remove(Perfil perfil) {
		em.remove(em.merge(perfil));		
	}
	
	@Override
	@TransactionScoped()
	public void salvar(Perfil perfil) {
		if(perfil.getId() == null) {
			em.persist(perfil);
		} else {
			em.merge(perfil);
		}
	}

}
