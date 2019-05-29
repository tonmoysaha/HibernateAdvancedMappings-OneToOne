package com.hibernate.one.to.one.mapping.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.mapping.onetoone.entity.unidirectional.Instructor;
import com.hibernate.mapping.onetoone.entity.unidirectional.InstructorDetailClass;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetailClass.class)
				.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();

		try {
			InstructorDetailClass instructorDetailClass = new InstructorDetailClass(
					"https://www.youtube.com/watch?v=ZFNTeqj1GDA&list=RDZFNTeqj1GDA&start_radio=1", "love to code");
			Instructor instructor = new Instructor("opi", "saha", "opi@gmail.com");

			// its also save the instructorDetailClass details
			instructor.setInstructorDetailClass(instructorDetailClass);

			session.beginTransaction();

			//session.save(instructor);

			session.getTransaction().commit();
		} finally {
			// TODO: handle finally clause
			sessionFactory.close();
		}

	}

}
