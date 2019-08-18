package br.edu.positivo.sistemweb.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.TransactionScoped;

import br.edu.positivo.sistemweb.entity.Pedido;

public class PedidoServiceImpl implements PedidoService{

	@PersistenceContext(unitName = "sistemaweb")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> listar() {
		Query query = em.createQuery("select p from Pedido p");
		return query.getResultList();
	}

	
	@Override
	@TransactionScoped()
	public void finalizar() {
		if(pedido.getId() == null) {
			em.persist(pedido);
		} else {
			em.merge(pedido);
		}
	}
	
	
}
