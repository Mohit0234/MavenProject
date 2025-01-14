package com.example;

import com.example.Country;
import com.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * This class provides methods to perform CRUD operations for Country.
 */
public class CountryService {

    /**
     * Adds a new country to the database.
     * 
     * @param name Name of the country.
     * @param population Population of the country.
     */
	public void createCountry(String name, Long population) {
		
		// Open a new session to interact with the database
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        // Start a transaction
        Transaction transaction = session.beginTransaction();
        
        // Create a new Country object and set its details
        Country country = new Country();
        country.setName(name);
        country.setPopulation(population);
        
        // Save the country to the database
        session.save(country);
        
        // Commit the transaction
        transaction.commit();
        
        // Close the session
        session.close();
        System.out.println("Country added successfully!");
    }

	/**
     * Reads and displays a country's details from the database by name.
     * 
     * @param name Name of the country to read.
     */
    public void readCountry(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = session.createQuery("FROM Country WHERE name = :name", Country.class)
                                 .setParameter("name", name)
                                 .uniqueResult();
        session.close();

        if (country != null) {
            System.out.println("Country ID: " + country.getId());
            System.out.println("Country Name: " + country.getName());
            System.out.println("Population: " + country.getPopulation());
        } else {
            System.out.println("Country not found!");
        }
    }
    
    /**
     * Updates the population of a country in the database.
     * 
     * @param name          Name of the country to update.
     * @param newPopulation New population value.
     */
    public void updateCountry(String name, Long newPopulation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Country country = session.createQuery("FROM Country WHERE name = :name", Country.class)
                                 .setParameter("name", name)
                                 .uniqueResult();
        if (country != null) {
            country.setPopulation(newPopulation);
            session.update(country);
            transaction.commit();
            System.out.println("Country updated successfully!");
        } else {
            System.out.println("Country not found!");
        }
        session.close();
    }
    
    /**
     * Deletes a country from the database by name.
     * 
     * @param name Name of the country to delete.
     */
    public void deleteCountry(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Country country = session.createQuery("FROM Country WHERE name = :name", Country.class)
                                 .setParameter("name", name)
                                 .uniqueResult();
        if (country != null) {
            session.delete(country);
            transaction.commit();
            System.out.println("Country deleted successfully!");
        } else {
            System.out.println("Country not found!");
        }
        session.close();
    }
}
