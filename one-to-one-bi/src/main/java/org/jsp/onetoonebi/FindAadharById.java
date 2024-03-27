package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharById {
	public static void main(String[] args) {
		System.out.println("Enter aadhar id");
		int aadhar_id = new Scanner(System.in).nextInt();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select a from AadharCard a where a.id=?1");
		q.setParameter(1, aadhar_id);
		
		try {
			AadharCard aadhar = (AadharCard) q.getSingleResult();
			System.out.println(aadhar);
		} catch(NoResultException e) {
			System.err.println("Invalid aadhar id");
		}
	}
}
