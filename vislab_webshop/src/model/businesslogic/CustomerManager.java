package model.businesslogic;


import org.hibernate.Session;
import model.database.Customer;
import model.util.HibernateUtil;


/**
 * Created by Tim on 13.11.2015.
 */

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



