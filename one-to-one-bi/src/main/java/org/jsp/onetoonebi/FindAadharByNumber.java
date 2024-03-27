package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByNumber {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Aadhar number");
		long aadharnumber = sc.nextLong();
		Query query=manager.createQuery("select a from AadharCard a where a.number=?1");
		query.setParameter(1, aadharnumber);
		
		try {
			AadharCard aadhar = (AadharCard) query.getSingleResult();
			System.out.println(aadhar);
			
		} catch(NoResultException e) {
			System.err.println("Invalid aadhar card number");
		}
		
	}

}
