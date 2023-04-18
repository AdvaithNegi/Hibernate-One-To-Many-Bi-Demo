package com.jsp.bank.branch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestGetAll {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql1 = "select b from Bank b";
		String sql2 = "select b from Branch b";
		Query query1 = entityManager.createQuery(sql1);
		Query query2 = entityManager.createQuery(sql2);
		List<Bank> banks = query1.getResultList();
		List<Branch> branchs = query2.getResultList();
		for (Bank bank : banks) {
			System.out.println("======================Bank Details=================");
			System.out.println("Bank ID   : " + bank.getId());
			System.out.println("Bank Name : " + bank.getName());
		}

		for (Branch branch : branchs) {
			System.out.println("======================Branch Details=================");
			System.out.println("Branch ID        : " + branch.getId());
			System.out.println("Branch ISFC_code : " + branch.getIfsc_code());
			System.out.println("Branch Loc       : " + branch.getLoc());
		}
	}

}
