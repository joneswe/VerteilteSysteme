package model.util;

import model.database.Category;
import model.database.Customer;
import model.database.Game;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            //add Annotated Classes
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Game.class);
            configuration.addAnnotatedClass(Category.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
            System.out.println("Initial SessionFactory creation");
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

