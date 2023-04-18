package com.jsp.bank.branch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdate {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bank bank = entityManager.find(Bank.class, 2);
		bank.setName("HDFC");

		Branch branch = entityManager.find(Branch.class, 4);
		branch.setIfsc_code("HDBC1234");

		entityTransaction.begin();
		entityManager.merge(bank);
		entityManager.merge(branch);
		entityTransaction.commit();

	}
}
