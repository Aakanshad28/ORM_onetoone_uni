
package onetoone_uni.controller;

import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_uni.dao.AadharDao;
import onetoone_uni.dao.PersonDao;
import onetoone_uni.dto.AadharCard;
import onetoone_uni.dto.Person;

public class MainController {
	public static void main(String[] args) {
		AadharCard aadharCard = new AadharCard();
		aadharCard.setId(111);
		aadharCard.setName("shivam");
		aadharCard.setAddress("Maha");

		Person person = new Person();
		person.setId(111);
		person.setName("aanaya");
		person.setPhone(234585778);
		person.setAddress("Mh");
		person.setAadharCard(aadharCard);

//		// Person person1= entityManager.find(Person.class, 1);
        PersonDao dao = new PersonDao();
//        dao.savePerson(person);

		 dao.getPerson(2);

		// dao.getAllPersons();

//		AadharDao aadharCardDao=new AadharDao();
//		aadharCardDao.deleteAadharCard(102);

		// dao.deletePerson(1);

//		Scanner scanner=new Scanner(System.in);
//		System.out.println("Enter the id:");
//		int id=scanner.nextInt();
//		System.out.println("Enter the name:");
//		String  name=scanner.next();
//		System.out.println("Enter the phone");
//		long phone=scanner.nextLong();
//		System.out.println("enter the address:");
//		String address=scanner.next();

		// aadharCardDao.updateAadhar(102);

		// person.setId(3);
//		person.setName("vinay");
//		person.setPhone(876543212);
//		person.setAddress("TN");
//		 dao.updatePerson(3, person);

//		AadharCard aadharCard = new AadharCard();
//		aadharCard.setName("ravi");
//		aadharCard.setAddress("chennai");
//		Person person = new Person();
//		person.setName("ravi");
//		person.setPhone(34567890);
//		person.setAddress("chennai");
//		person.setAadharCard(aadharCard);
//		
//		PersonDao dao = new PersonDao();
		dao.updateBoth(111, person);
//		
	}

}
