package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This class is used to set up and manage the SessionFactory.
 * The SessionFactory is used to create sessions to interact with the database.
 */
public class HibernateUtil {
	
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    /**
     * This method returns the SessionFactory instance.
     * 
     * @return The SessionFactory used to open sessions for database operations.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
