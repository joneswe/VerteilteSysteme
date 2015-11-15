package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.businesslogic.CustomerManager;
import model.database.Customer;

/**
 * Created by Tim on 13.11.2015.
 */


public class LoginAction extends ActionSupport {


    private String username;
    private String password;
    private String firstname;
    private String lastname;




    public String execute() throws Exception {

            CustomerManager customerManager = new CustomerManager();

            Customer customer = customerManager.getCustomerByPrimaryKey(getUsername());

            if (customer == null) {

                addActionError(getText("error.username.register"));
                return "input";
            } else {
                if (customer.getPassword().equals(getPassword())) {
                    setFirstname(customer.getFirstname());
                    setLastname(customer.getLastname());
                    return "success";
                } else {
                    addActionError(getText("error.user.passwordforgotten"));
                    //addActionError("Bitte geben Sie das richtige Passwort ein!");
                    return "input";
                }
            }


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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password  = password;
    }


    @Override
    public void validate() {
            if (getUsername().length() == 0) {
                addFieldError("username", getText("error.login.username_blank"));
            }
            if (getPassword().length() == 0) {
                addFieldError("password", getText("error.login.password_blank"));
            }
    }

}
