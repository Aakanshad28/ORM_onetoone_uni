package onetoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetoone_uni.dto.AadharCard;
import onetoone_uni.dto.Person;

public class PersonDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aakansha");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePerson(Person person) {
		AadharCard aadharCard = person.getAadharCard();
		entityTransaction.begin();
		//entityManager.persist(aadharCard);
		entityManager.persist(person);
		entityTransaction.commit();

	}

	public void getPerson(int id) {
		Person person = entityManager.find(Person.class, 1);
		
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("the person with given id is not found");

		}
	}

	public void getAllPersons() {
		Query query = entityManager.createQuery("SELECT p FROM Person p");
		System.out.println(query.getResultList());

	}

	public void deletePerson(int id) {
		Person person = entityManager.find(Person.class, id);
		if (person != null) {
			entityTransaction.begin();
			//entityManager.remove(person.getAadharCard());
			entityManager.remove(person);
			entityTransaction.commit();
		} else {
			System.out.println("Person with id " + id + " not found");
		}

	}
	public void updatePerson(int id,Person person) {
		Person dbPerson = entityManager.find(Person.class, id);
		if (dbPerson!=null) {
			person.setId(id);//person.setId(dbPerson.getId())
			person.setAadharCard(dbPerson.getAadharCard());//partial method chaining
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("Person with id " + id + " not found");
		}
		
	}
	public void updateBoth(int id,Person person) {
		Person dbPerson=entityManager.find(Person.class, id);
		if (dbPerson!=null) {
			person.setId(id);
			person.getAadharCard().setId(dbPerson.getAadharCard().getId());// complete method chaining
			entityTransaction.begin();
//			entityManager.merge(person.getAadharCard());
			entityManager.merge(person);
			entityTransaction.commit();
			
		}
	}
	//if we get the null pointer exception or if the link is break between two object
	public void updatePersonWithAadharCard(int personId,int aId) {
		Person person=entityManager.find(Person.class, personId);
		if (person!=null) {
			AadharCard aadharCard=entityManager.find(AadharCard.class, aId);
			if (aadharCard!=null) {
				person.setAadharCard(aadharCard);
				entityTransaction.begin();
				entityManager.merge(person);
				entityTransaction.commit();
				
			} else {
				System.out.println("AadharCard wuth given id not found!");

			}
			
		} else {
			System.out.println("Person with given id is not found!");

		}
		
	}

}
