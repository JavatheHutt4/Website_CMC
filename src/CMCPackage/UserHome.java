package CMCPackage;

import java.util.ArrayList;

/**
 * UserHome class used to control the USer class
 * 
 * @author jffritz, jrfolkerds
 * @version 3/14/16
 */
public class UserHome {

	/**
	 * User object representing the User using interface
	 */
	private User user;

	/**
	 * SearchController object to manage search functions
	 */
	private SearchController sc;

	/**
	 * DatabaseController object to access the database
	 */
	public DatabaseController db;

	/**
	 * Constructor for UserHome object which instantiates database
	 */
	public UserHome() {
		db = new DatabaseController();
		sc = new SearchController();
	}
	
	/**
	 * Constructor for UserHome object which instantiates user
	 */
	public UserHome(User u) {
		db = new DatabaseController();
		sc = new SearchController();
		user = u;
	}

	/**
	 * Uses the db to get all of the users and there information returned in a
	 * 2-D array of strings
	 * 
	 * @return 2-d array of the user and there info
	 */
	public String[][] getAllUsers() {
		return db.getUsers();
	}

	/**
	 * Runs the findByName method on db
	 * 
	 * @param the
	 *            username of the user you are searching for
	 * @return the user you searched for
	 */
	public Member findByName(String u) {
		return db.findByName(u);
	}

	/**
	 * Runs the viewSavedSchool method from User class
	 * 
	 * @param School
	 *            object that is being searched for
	 * @return the school toString() from user
	 */
	public String viewSavedSchool(School s) {
		return user.viewSavedSchool(s);
	}

	/**
	 * Runs the removeSavedSchool method from User class
	 * 
	 * @param String
	 *            school name to be saved
	 */
	public int removeSavedSchool(String s) {
		System.out.println("Test1");
		return db.removeSchool(user.getUserName(), s);
	}

	/**
	 * View the list of saved schools
	 * 
	 * @param username
	 *            the specified user's username
	 * @return the list of saved schools
	 */
	public ArrayList<String> getSavedSchools(String username) {
		ArrayList<String> schools = new ArrayList<String>();
		String[][] all = db.getUsernamesWithSavedSchools();
		for (int i = 0; i < all.length; i++) {
			if (all[i][0].equals(username)) {
				schools.add(all[i][1]);
			}
		}
		return schools;
	}

	/**
	 * search finds the schools that match the given criteria from a user's
	 * search // UserHome contacts SeachController to get the search
	 * 
	 * @param name
	 *            - sequence of characters user is searching for in a school's
	 *            name
	 * @param state
	 *            - sequence of characters user is searching for in a school's
	 *            state
	 * @param location
	 *            - sequence of characters user is searching for in a school's
	 *            location
	 * @param control
	 *            - sequence of characters user is searching for in a school's
	 *            control
	 * @param lowNumStudents
	 *            - lower bound for parameter
	 * @param highNumStudents
	 *            - upper bound for parameter
	 * @param lowPerFemale
	 *            - lower bound for parameter
	 * @param highPerFemale
	 *            - upper bound for parameter
	 * @param lowSatVerbal
	 *            - lower bound for parameter
	 * @param highSatVerbal
	 *            - upper bound for parameter
	 * @param lowSatMath
	 *            - lower bound for parameter
	 * @param highSatMath
	 *            - upper bound for parameter
	 * @param lowExpenses
	 *            - lower bound for parameter
	 * @param highExpenses
	 *            - upper bound for parameter
	 * @param lowPerFinancial
	 *            - lower bound for parameter
	 * @param highPerFinancial
	 *            - upper bound for parameter
	 * @param lowNumApplicants
	 *            - lower bound for parameter
	 * @param highNumApplicants
	 *            - upper bound for parameter
	 * @param lowPerAdmitted
	 *            - lower bound for parameter
	 * @param highPerAdmitted
	 *            - upper bound for parameter
	 * @param lowPerEnrolled
	 *            - lower bound for parameter
	 * @param highPerEnrolled
	 *            - upper bound for parameter
	 * @param lowAcadScale
	 *            - lower bound for parameter
	 * @param highAcadScale
	 *            - upper bound for parameter
	 * @param lowSocialScale
	 *            - lower bound for parameter
	 * @param highSocialScale
	 *            - upper bound for parameter
	 * @param lowQOLScale
	 *            - lower bound for parameter
	 * @param highQOLScale
	 *            - upper bound for parameter
	 * @param emph1
	 *            - emphasis being searched for
	 * @param emph2
	 *            - emphasis being searched for
	 * @param emph3
	 *            - emphasis being searched for
	 * @param emph4
	 *            - emphasis being searched for
	 * @param emph5
	 *            - emphasis being searched for
	 * @return the schools that match the search
	 */
	public String[][] search(String name, String state, String location, String control, int lowNumStudents,
			int highNumStudents, int lowPerFemale, int highPerFemale, int lowSatVerbal, int highSatVerbal,
			int lowSatMath, int highSatMath, int lowExpenses, int highExpenses, int lowPerFinancial,
			int highPerFinancial, int lowNumApplicants, int highNumApplicants, int lowPerAdmitted, int highPerAdmitted,
			int lowPerEnrolled, int highPerEnrolled, int lowAcadScale, int highAcadScale, int lowSocialScale,
			int highSocialScale, int lowQOLScale, int highQOLScale, String emph1, String emph2, String emph3,
			String emph4, String emph5) {
		String[][] search = sc.search(name, state, location, control, lowNumStudents, highNumStudents, lowPerFemale,
				highPerFemale, lowSatVerbal, highSatVerbal, lowSatMath, highSatMath, lowExpenses, highExpenses,
				lowPerFinancial, highPerFinancial, lowNumApplicants, highNumApplicants, lowPerAdmitted, highPerAdmitted,
				lowPerEnrolled, highPerEnrolled, lowAcadScale, highAcadScale, lowSocialScale, highSocialScale,
				lowQOLScale, highQOLScale, emph1, emph2, emph3, emph4, emph5);
		return search;
	}

	/**
	 * getRecommendedSchools compares a given school with schools in the
	 * database to find the most similar ones.
	 * 
	 * @param s
	 *            - the school that is being given for CMC to compare the other
	 *            schools to
	 * @return a 2D array with the 5 most similar schools
	 */
	public String[][] recommendSchool(School s) {
		String[][] school = sc.getRecommendedSchools(s);
		return school;
	}

	/**
	 * Runs the saveSchool method from User class
	 * 
	 * @param String
	 *            school name to be saved
	 */
	public void saveSchool(String s) {
		int i = db.saveSchool(user.getUserName(), s);
		if (i != -1) {
			System.out.println("School was successfully saved");
		} else {
			String[][] all = db.getSchools();
			for (int j = 0; j < all.length; j++) {
				if (all[j][0].equals(s)) {
					System.out.println("School has already been saved");
					return;
				}
			}
			System.out.println("School does not exist");
		}
	}

	/**
	 * sets the instance of the User to the logged on user
	 */
	public void setMember(Member member) {
		this.user = (User) member;
	}

	/**
	 * gets the instance of the logged on user
	 */
	public User getMember() {
		return user;
	}

	/**
	 * Allows the user to change their first name, last name, or password
	 * 
	 * @param f
	 *            the first name to be changed
	 * @param l
	 *            the last name to be changed
	 * @param p
	 *            the password to be changed
	 */
	public void editUserInfo(String f, String l, String p) {
		db.editUser(f, l, user.getUserName(), p, user.getType(), user.getStatus());
		user.updateInformation(f, l, p);
	}
}
