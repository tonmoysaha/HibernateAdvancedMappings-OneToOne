package com.hibernate.one.to.one.mapping.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.mapping.onetoone.entity.unidirectional.Instructor;
import com.hibernate.mapping.onetoone.entity.unidirectional.InstructorDetailClass;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetailClass.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();

		try {

			session.beginTransaction();

			int instructorId = 1;
			//its delete id from both table Instructor && InstructorDetailClass
			Instructor instructor = session.get(Instructor.class, instructorId);
			if (instructor != null) {
				session.delete(instructor);
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
