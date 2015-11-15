package model.businesslogic;

import model.database.Customer;

/**
 * Created by Tim on 13.11.2015.
 */
public class Main {

    public static void main(String[] args) {
        Customer cstm = new Customer("lebetyp", "peter", "ja", "ja");
        CustomerManager mngr = new CustomerManager();
        Customer customer = mngr.getCustomerByPrimaryKey("lebetyp");


    }
}
