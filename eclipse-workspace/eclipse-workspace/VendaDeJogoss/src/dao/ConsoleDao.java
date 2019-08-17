package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Console;

public class ConsoleDao {

	static EntityManagerFactory emf = Persistence.
			createEntityManagerFactory("cadernosystem");
	
	public void inserir(Console console) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(console);
		em.getTransaction().commit();
	}

	public Console buscarPorId(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Console.class, id);
	}
	
	public void alterar(Console console) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(console);
		em.getTransaction().commit();
	}
	
	public List<Console> listar() {	
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select c from Console c");
		
		return q.getResultList();
	}

}