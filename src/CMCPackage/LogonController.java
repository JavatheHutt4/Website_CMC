package CMCPackage;
/**
 * 
 */

/**
 * LogonController class to make changes to a member object and it's login
 * status
 * 
 * @author tdrichmond
 * @version
 */
public class LogonController {

	/**
	 * Member which is currently logged in
	 */
	private Member member;

	/**
	 * DatabaseController to access the user information
	 */
	private DatabaseController DB;

	/**
	 * Constructor for a LogonController
	 */
	public LogonController() {
		DB = new DatabaseController();
		member = null;
	}

	/**
	 * Changes the password of the logged on member
	 * 
	 * @param String
	 *            password
	 */
	public void changePassword(String pass) {
		if (member == null) {
			throw new NullPointerException("Cannot change password, no user logged on.");
		}
		member.setPassword(pass);
	}

	/**
	 * logs on a user with the userName and password passed as parameters
	 * 
	 * @param String
	 *            user
	 * @param String
	 *            password
	 */
	public Member logon(String user, String pass) {
		Member temp = DB.findByName(user);
		if (temp != null) {
			if (temp.getPassword().equals(pass)) {
				member = temp;
				System.out.println(
						"Logon Successful! Welcome, " + member.getFirstName() + " " + member.getLastName() + ".");
				return member;
			} else {
				System.out.println("Logon Unsuccessful. Please check your username and password!");
				return null;
			}
		} else {
			System.out.println("Logon Unsuccessful. Please check your username and password!");
			return null;
		}
	}

	/**
	 * logs off any member who is currently logged on, and returns them to the
	 * logon screen
	 */
	public void logoff() {
		member = null;
		System.out.println("Log Off Successful");
	}

	public Member getMember() {
		if (member == null)
			System.out.println("No member logged on");
		return member;
	}

	public String toString() {
		if (member == null)
			return "No member is currently logged on.";
		else if (member.getType() == 'a')
			return "The Member currently logged in is user " + member.getUserName() + " of type admin.";
		else
			return "The Member currently logged in is user " + member.getUserName() + " of type user.";
	}
}
