package com.hibernate.one.to.one.mapping.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.mapping.onetoone.entity.Bidirectional.*;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetailClass.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			int instructorId = 2;
			//its delete id from both table Instructor && InstructorDetailClass
			InstructorDetailClass instructorDetailClass = session.get(InstructorDetailClass.class, instructorId);
			if (instructorDetailClass != null) {
				session.delete(instructorDetailClass);
				System.out.println("delete successflly");
			}else {
				System.out.println("instructor not found");
			}

			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
		}

	}

}
