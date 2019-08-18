package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.TransactionScoped;

import br.edu.positivo.sistemweb.entity.Usuario;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class UsuarioServiceImpl implements UsuarioService {

	@PersistenceContext(unitName = "sistemaweb")
	EntityManager em;
	
	@Override
	@TransactionScoped()
	public void salvar(Usuario usuario) {
		if(usuario.getId() == null) {
			em.persist(usuario);
		} else {
			em.merge(usuario);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		Query query = em.createQuery("select u from Usuario u");
		return query.getResultList();
	}
	
	@Override
	public void remove(Usuario usuario) {
		em.remove(em.merge(usuario));		
	}
	
	@Override
	public Usuario getUsuarioById(Integer id) {
		return em.find(Usuario.class, id);
	}

}
