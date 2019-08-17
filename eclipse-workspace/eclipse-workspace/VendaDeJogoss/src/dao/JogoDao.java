package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Jogo;

public class JogoDao {

	static EntityManagerFactory emf = Persistence.
			createEntityManagerFactory("cadernosystem");
	
	public void inserir(Jogo jogo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(jogo);
		em.getTransaction().commit();
	}

	public Jogo buscarPorId(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Jogo.class, id);
	}
	
	public void alterar(Jogo jogo) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(jogo);
		em.getTransaction().commit();
	}
	
	public List<Jogo> listar() {	
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select j from Jogo j");
		
		return q.getResultList();
	}
}
