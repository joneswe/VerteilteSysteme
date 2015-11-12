package vislabExample.controller;


import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import vislabExample.model.businessLogic.UserManager;
import vislabExample.model.database.User;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -983183915002226000L;

	private String username = null;
	private String password = null;
	private String firstname = "";
	private String lastname = "";

	public static final int USER_EXISTS_PASSWORD_OK = 0;

	public static final int USER_EXISTS_PASSWORD_NOK = 1;

	public static final int USER_NOT_FOUND = 2;

	
	public String execute() throws Exception {

		UserManager userManager = new UserManager();
		
		User dbUser = userManager.getUser(getUsername(), getPassword());

		/** hier ist die Schnittstelle zur Geschäftslogik
		 * Verarbeitung der eingegebenen Daten, z.B. Überprüfen der Zugangsdaten, holen der Userdaten
		 */
		
		
		if (dbUser.getUsername().equals(getUsername())) {
		
			if (dbUser.getPassword().equals(getPassword())) {
	
				setFirstname(dbUser.getFirstname());
				setLastname(dbUser.getLastname());
				
				return SUCCESS;
	
			} else {
				addActionError(getText("error.user.passwordforgotten"));
				addActionError("Bitte geben Sie das richtige Passwort ein!");
				return "input";
			}
		}
		else {
			addFieldError("username", getText("error.username.register"));
			 return INPUT;
		}
	}
	
	
	public String getLastname() {
		return lastname;
	}
	
	private void setLastname(String lastname) {
		this.lastname = lastname;	
	}

	public String getFirstname() {
		return firstname;
	}

	private void setFirstname(String firstname) {
		this.firstname = firstname;
	}

    public String getUsername() { return (this.username); }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return (this.password); }
    public void setPassword(String password) { this.password  = password; }

    
    @Override
    public void validate() {
    	if (!this.username.equals("")&&!this.username.startsWith("Us")){
    		addFieldError("username", "Username muss mit Us beginnen!");
    	}
    }

}
