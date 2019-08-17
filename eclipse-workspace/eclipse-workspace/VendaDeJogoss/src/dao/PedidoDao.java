package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.Pedido;

public class PedidoDao {
	
	static EntityManagerFactory emf = Persistence.
			createEntityManagerFactory("cadernosystem");
	
	public void inserir(Pedido pedido) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
	}


}
