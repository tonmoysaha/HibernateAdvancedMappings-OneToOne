package com.hibernate.mapping.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure()
				.addAnnotatedClass(annotatedClass)

	}

}
