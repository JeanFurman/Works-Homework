package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Cliente;

public class ClienteDao {
	
	static EntityManagerFactory emf = Persistence.
			createEntityManagerFactory("cadernosystem");
	
	public void inserir(Cliente cliente) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}

	public Cliente buscarPorId(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Cliente.class, id);
	}
	
	public void alterar(Cliente cliente) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
	}
	
	public List<Cliente> listar() {	
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select cl from Cliente cl");
		
		return q.getResultList();
	}	
}
