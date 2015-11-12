package com.suppliers.model;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageSuppliers {
	private static SessionFactory factory; 
	
	public void listSuppliers( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List<?> suppliers = session.createQuery("FROM Supplier").list();          
	         for (Object supplier : suppliers) {
	        	 System.out.print(((Supplier) supplier).getSno() + " | "); 
		         System.out.print(((Supplier) supplier).getSname() + " | ");
		         System.out.println(((Supplier) supplier).getCity());
			}
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	
	public static void main(String[] args) {
		
		factory = new Configuration().configure().buildSessionFactory();  
		new ManageSuppliers().listSuppliers();
	}

}


