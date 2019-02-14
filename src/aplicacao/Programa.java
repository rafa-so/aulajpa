package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	public static void main(String[] args) {
		//Pessoa p1 = new Pessoa(null, "Rafael Oliveira", "rafaeloliveira@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Ernesto Araujo", "anaclara@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Ricardo Sales", "ricardo@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		//em.getTransaction().begin();
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		//em.getTransaction().commit();
		
		System.out.println("pronto");
		em.close();
		emf.close();
	}
}