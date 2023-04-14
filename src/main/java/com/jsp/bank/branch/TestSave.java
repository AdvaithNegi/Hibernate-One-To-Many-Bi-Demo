package com.jsp.bank.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		List<Branch> al = new ArrayList<Branch>();

		Branch branch1 = new Branch();
		branch1.setLoc("Panvel");
		branch1.setIfsc_code("SBI123");

		Branch branch2 = new Branch();
		branch2.setLoc("Thane");
		branch2.setIfsc_code("SBI456");

		Branch branch3 = new Branch();
		branch3.setLoc("Vashi");
		branch3.setIfsc_code("SBI789");

		al.add(branch1);
		al.add(branch2);
		al.add(branch3);

		Bank bank = new Bank();
		bank.setName("SBI");
		bank.setBranchs(al);

		branch1.setBank(bank);
		branch2.setBank(bank);
		branch3.setBank(bank);

		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();

	}
}
