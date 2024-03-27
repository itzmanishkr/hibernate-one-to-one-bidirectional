package org.jsp.onetoonebi;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserAndAadhar {

	public static void main(String[] args) {
		
		User user = new User();
		user.setName("rajeev");
		user.setPhone(976543278L);
		
		AadharCard card = new AadharCard();
		card.setNumber(123412340000l);
		card.setDob(LocalDate.parse("1999-05-01"));
		card.setAddress("Bengaluru");
		user.setCard(card);
		card.setUser(user);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		manager.persist(user);
		transaction.begin();
		transaction.commit();
		
	}
}
