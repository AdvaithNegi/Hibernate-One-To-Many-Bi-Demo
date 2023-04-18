package com.jsp.bank.branch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Bank bank = entityManager.find(Bank.class, 3);
		System.out.println("BANK ID     : " + bank.getId());
		System.out.println("BANK ID     : " + bank.getName());
		System.out.println("Branch ID   : " + bank.getBranchs().get(0).getId());
		System.out.println("Branch ISFC : " + bank.getBranchs().get(0).getIfsc_code());
		System.out.println("Branch Loc  : " + bank.getBranchs().get(0).getLoc());

	}
}
