package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CustomerManager;
import model.database.Customer;

/**
 * Created by Tim on 15.11.2015.
 */
public class RegistrationAction extends ActionSupport {

    private String username;
    private String firstname;
    private String lastname;
    private String password;

    public String execute() throws Exception {

        CustomerManager customerManager = new CustomerManager();
        Customer customer = customerManager.getCustomerByPrimaryKey(getUsername());

        if (customer != null) {
            addActionError(getText("error.register.username_exists"));
            return "input";
        } else {
            customer = new Customer();
            customer.setUsername(getUsername());
            customer.setFirstname(getFirstname());
            customer.setLastname(getLastname());
            customer.setPassword(getPassword());
            customerManager.saveCustomer(customer);
            return "success";
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void validate() {
        if (getUsername().length() == 0) {
            addFieldError("username", getText("error.login.username_blank"));
        }
        if (getPassword().length() == 0) {
            addFieldError("password", getText("error.login.password_blank"));
        }
        if (getFirstname().length() == 0) {
            addFieldError("firstname", getText("error.register.firstname_blank"));
        }
        if (getLastname().length() == 0) {
            addFieldError("lastname", getText("error.register.lastname_blank"));
        }
    }
}
