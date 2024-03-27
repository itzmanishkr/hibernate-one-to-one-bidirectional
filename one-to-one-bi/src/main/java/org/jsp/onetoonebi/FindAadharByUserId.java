package org.jsp.onetoonebi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserId {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Enter User Id to find Aadhar Card");
		
		Scanner sc = new Scanner(System.in);
		int userid = sc.nextInt();
		
		
		
		//Both can be possible because it is bi-directional
//		Query q = manager.createQuery("select a from AadharCard a where a.user.id=?1");
		Query q = manager.createQuery("select u.card from User u where u.id=?1");
		q.setParameter(1, userid);
		
		try {
			AadharCard aadharCard = (AadharCard) q.getSingleResult();
			System.out.println(aadharCard);
		} catch(NoResultException e) {
			System.err.println("Invalid User Id");
		}
		
	}
}
