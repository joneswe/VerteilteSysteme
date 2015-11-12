package vislabExample.model.database;

public class User{
	
    /** nullable persistent field */
    private String password;

    /** nullable persistent field */
    private String username;

    
    /** nullable persistent field */
    private String lastname;

    /** nullable persistent field */
    private String firstname;

	public User() {
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



}
