package com.jsp.map.cascade.joincolumn;

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

		List<Staff> al = new ArrayList<Staff>();

		Staff staff1 = new Staff();
		staff1.setName("sejal");
		staff1.setEmail("sejal@mail.com");

		Staff staff2 = new Staff();
		staff2.setName("Masoom");
		staff2.setEmail("masoom@mail.com");

		Staff staff3 = new Staff();
		staff3.setName("Gayatri");
		staff3.setEmail("gayatri@mail.com");

		al.add(staff1);
		al.add(staff2);
		al.add(staff3);

		Hospital hospital = new Hospital();
		hospital.setName("MGM");
		hospital.setStaffs(al);

		staff1.setHospital(hospital);
		staff2.setHospital(hospital);
		staff3.setHospital(hospital);

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();

	}
}
