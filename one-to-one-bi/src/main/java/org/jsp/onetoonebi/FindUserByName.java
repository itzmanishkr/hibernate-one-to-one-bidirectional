package org.jsp.onetoonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of user");
		String name=sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		
		Query q = manager.createQuery("select u from User u where u.name=?1");
		q.setParameter(1, name);
		
		List<User> users = q.getResultList();
		
		if(users.size()>0) {
			for(User u: users) {
				System.out.println(u);
			}
			
		}
		else {
			System.err.println("Invalid user name");
		}
	}
}
