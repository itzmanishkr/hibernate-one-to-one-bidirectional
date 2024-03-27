package org.jsp.onetoonebi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharNumberAndDob {

	public static void main(String[] args) {
		System.out.println("Enter aadhar number and dob (yyyy-mm-dd)");
		Scanner sc = new Scanner(System.in);
		long aadharnumber = sc.nextLong();
		LocalDate dob = LocalDate.parse(sc.next());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select u from User u where u.card.number=?1 and u.card.dob=?2");
		q.setParameter(1, aadharnumber);
		q.setParameter(2, dob);
		
		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		} catch (NoResultException e) {
			System.err.println("Invalid aadhar number or date of birth");
		}
	}
}
