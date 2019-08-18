package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.TransactionScoped;

import br.edu.positivo.sistemweb.entity.Jogo;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class JogoServiceImpl implements JogoService {

	@PersistenceContext(unitName = "sistemaweb")
	EntityManager em;
	
	@Override
	@TransactionScoped()
	public void salvar(Jogo jogo) {
		if(jogo.getId() == null) {
			em.persist(jogo);
		} else {
			em.merge(jogo);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jogo> listar() {
		Query query = em.createQuery("select j from Jogo j");
		return query.getResultList();
	}

	@Override
	public void remove(Jogo jogo) {
		em.remove(em.merge(jogo));	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jogo> listar(Integer idPerfil) {
		Query query = em.createQuery("select j from Jogo j where j.perfil.id = " + idPerfil);
		return query.getResultList();
	}	
}
