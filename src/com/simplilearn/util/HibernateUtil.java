package com.simplilearn.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.simplilearn.entity.Admin;
import com.simplilearn.entity.FlightDetails;
import com.simplilearn.entity.Persons;



public class HibernateUtil {
static SessionFactory sessionFactory=null;
public static SessionFactory buildSessionFactor()
{
	if (sessionFactory!=null)
	{
		return sessionFactory;
	}
	// step 1 creating configuration object
	Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FlightDetails.class).addAnnotatedClass(Persons.class).addAnnotatedClass(Admin.class);
	sessionFactory=cfg.buildSessionFactory();
	return sessionFactory;
	
}
}