package CMCPackage; 
/**
 * The Admin class represents the Members of the systems that are administrators.
 * @author jcblomquist
 * @version 3/9/2016
 */

public class Admin extends Member {
	
	
	/**
	 * Constructor method for Admin
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param status
	 */
	public Admin(String firstName, String lastName, String userName, String password, char status) {
		super(firstName, lastName, userName, password, 'a', status);
	}
}
