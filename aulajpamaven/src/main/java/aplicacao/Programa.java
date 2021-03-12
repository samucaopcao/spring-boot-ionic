package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null,"André da Silva","andre@gmail.com");
		Pessoa p2 = new Pessoa(null,"Barbara da Silva","barbara@gmail.com");
		Pessoa p3 = new Pessoa(null,"Carlos da Silva","carlos@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa p = em.find(Pessoa.class, 2);//Buscará no Banco de dados a pessoa numero 02
		em.getTransaction().begin();
		em.remove(p);// Excluirá a pessoa que buscamos acima
		em.getTransaction().commit();
		
		
		System.out.println("Tudo pronto!");
		
		System.out.println(p);
		em.close();
		emf.close();
		
	}

}
