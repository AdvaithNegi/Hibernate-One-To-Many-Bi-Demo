package com.jsp.bank.branch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDelete {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch1 = entityManager.find(Branch.class, 7);
		Branch branch2 = entityManager.find(Branch.class, 8);
		Branch branch3 = entityManager.find(Branch.class, 9);
		Bank bank = entityManager.find(Bank.class, 3);

		entityTransaction.begin();
		entityManager.remove(branch1);
		entityManager.remove(branch2);
		entityManager.remove(branch3);
		entityManager.remove(bank);
		entityTransaction.commit();
	}
}
