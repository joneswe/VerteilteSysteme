package vislabExample.model.db;

import vislabExample.model.bl.CustomerManager;
import vislabExample.model.sf.HibernateUtil;

/**
 * Created by Tim on 13.11.2015.
 */
public class Main {

    public static void main(String[] args) {
        Customer cstm = new Customer("lebetyp", "peter", "mueller", "geheim" );
        CustomerManager cstmmngr = new CustomerManager();
        cstmmngr.saveCustomer(cstm);

    }
}
