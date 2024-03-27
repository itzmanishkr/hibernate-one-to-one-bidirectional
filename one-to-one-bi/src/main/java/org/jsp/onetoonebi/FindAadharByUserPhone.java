package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserPhone {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Enter Phone number to find Aadhar Card");
		
		Scanner sc = new Scanner(System.in);
		long phone = sc.nextLong();
		
		//Both we can write because of bi-directional mapping
//		Query q = manager.createQuery("select u.card from User u where u.phone=?1");
		Query q = manager.createQuery("select a from AadharCard a where a.user.phone=?1");
		q.setParameter(1, phone);
		
		try {
			AadharCard aadharCard = (AadharCard) q.getSingleResult();
			System.out.println(aadharCard);
		} catch(NoResultException e) {
			System.err.println("Invalid Phone Number");
		}
	}
}
