package model.businesslogic;


import model.database.Customer;
import org.hibernate.Session;
import model.util.HibernateUtil;


public class CustomerManager {

    public Customer getCustomerByPrimaryKey(String primaryKey) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Customer customer = session.get(Customer.class, primaryKey);
        session.getTransaction().commit();
        return customer;
    }

    public void saveCustomer(Customer customer) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }


}



