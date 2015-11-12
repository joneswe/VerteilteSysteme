package vislabExample.model.businessLogic;


import vislabExample.model.database.User;

/**
   class für BenutzerObjekte

*/


public class UserManager {
	

	//public static final int USER_EXISTS_PASSWORD_OK = 0;

	public User getUser(String username, String password) {
		/*
		 * da noch keine Verbindung zur Datenbank besteht werden die Userdaten hier festgelegt
		 */

		User dbUser = new User();
		dbUser.setUsername("User1");
		dbUser.setFirstname("Vorname");
		dbUser.setLastname("Musteruser");
		dbUser.setPassword("pas123");
		
		return dbUser;
	}

}


