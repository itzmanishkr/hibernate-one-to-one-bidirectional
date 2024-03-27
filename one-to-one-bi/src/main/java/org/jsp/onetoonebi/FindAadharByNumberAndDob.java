package org.jsp.onetoonebi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByNumberAndDob {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		System.out.println("Enter Aadhar Number and date of birth(yyyy-mm-dd)");
		
		Scanner sc = new Scanner(System.in);
		long aadharno = sc.nextLong();
		LocalDate date = LocalDate.parse(sc.next());
		
		Query q = manager.createQuery("select a from AadharCard a where a.number=?1 and a.dob=?2");
		q.setParameter(1, aadharno);
		q.setParameter(2, date);
		try {
			AadharCard aadharCard = (AadharCard) q.getSingleResult();
			System.out.println(aadharCard);
		} catch(NoResultException e) {
			System.err.println("Your Aadhar no or dob ma be incorrect");
		}
		
	}
}
