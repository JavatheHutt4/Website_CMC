package CMCPackage;

import java.util.ArrayList;

/**
 * Class to represent a user in the CMC system
 * 
 * @author tdrichmond
 * @version 3/14/2016
 */
public class User extends Member {

	// Access to the UserHome class
	private UserHome uh;

	/**
	 * Constructor method for User
	 * 
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param type
	 * @param status
	 */
	public User(String firstName, String lastName, String userName, String password, char status) {
		super(firstName, lastName, userName, password, 'u', status);
		uh = new UserHome(this);
	}

	/**
	 * Method to update the User's password, first and last name
	 * 
	 * @param firstname
	 * @param lastname
	 * @param password
	 */
	public void updateInformation(String first, String last, String password) {
		this.setFirstName(first);
		this.setLastName(last);
		this.setPassword(password);
	}

	/**
	 * View the list of saved schools
	 * 
	 * @return the list of saved schools
	 */
	public ArrayList<String> getSavedSchools() {
		return uh.getSavedSchools(this.getUserName());
	}

	/**
	 * View the details of a saved school
	 * 
	 * @param the
	 *            saved school
	 * @return the specified saved school
	 */
	public String viewSavedSchool(School school) {
		return school.toString();
	}
	
	/**
	 * removes saved school
	 * 
	 * @param school
	 *            to be removed
	 */
	public void removeSavedSchool(String s) {
		uh.removeSavedSchool(s);
	}
}
