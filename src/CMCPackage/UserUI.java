package CMCPackage;

import java.util.ArrayList;

/**
 * UserUI class, accessed by the agent, used to control the UserHome class
 * 
 * @author jffritz
 * @version 3/13/16
 */
public class UserUI {

	/**
	 * UserHome object to be used by UI
	 */
	private UserHome userHome;

	/**
	 * LogonController object to manage Member and the login status
	 */
	private LogonController log;

	/**
	 * SchoolHome object to manage saved schools
	 */
	private SchoolHome sh;

	/**
	 * UserUI constructor to create both UserHome and LogonController instances
	 */
	public UserUI() {
		userHome = new UserHome();
		log = new LogonController();
		sh = new SchoolHome();
	}

	/**
	 * search finds the schools that match the given criteria from a user's
	 * search // UserUI contacts UserHome what contacts SeachController to get
	 * the search
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
		String[][] search = userHome.search(name, state, location, control, lowNumStudents, highNumStudents,
				lowPerFemale, highPerFemale, lowSatVerbal, highSatVerbal, lowSatMath, highSatMath, lowExpenses,
				highExpenses, lowPerFinancial, highPerFinancial, lowNumApplicants, highNumApplicants, lowPerAdmitted,
				highPerAdmitted, lowPerEnrolled, highPerEnrolled, lowAcadScale, highAcadScale, lowSocialScale,
				highSocialScale, lowQOLScale, highQOLScale, emph1, emph2, emph3, emph4, emph5);
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
		String[][] school = userHome.recommendSchool(s);
		return school;
	}

	/**
	 * updates the users info through userHome object
	 * 
	 * @param first
	 *            name
	 * @param last
	 *            name
	 * @param password
	 */
	public void manageMyProfile(String f, String l, String p) {
		userHome.getMember().updateInformation(f, l, p);
	}

	/**
	 * lists schools and user is given the option to view or remove the school
	 */
	public ArrayList<String> viewSavedSchools() {
		return userHome.getSavedSchools(log.getMember().getUserName());
	}

	// turn into manageSavedSchools
	/**
	 * save school
	 * 
	 * @param string
	 *            name of school to be saved
	 */
	public void saveSchool(String s) {
		userHome.saveSchool(s);
	}

	/**
	 * Views the specified school
	 * 
	 * @param the
	 *            string name of school to be viewed
	 */
	public School viewSpecificSchool(String n) {
		return sh.findByName(n);
	}

	/**
	 * Runs the logon method from the LogonController class
	 * 
	 * @param username
	 * @param password
	 */
	public void logon(String user, String pass) {
		int i = log.logon(user, pass);
		userHome.setMember(log.getMember());
	}

	/**
	 * Runs the logoff method from the LogonController class
	 */
	public void logoff() {
		log.logoff();
		userHome.setMember(null);
	}

	/**
	 * removes saved school
	 * 
	 * @param school
	 *            to be removed
	 */
	public void removeSavedSchool(String s) {
		userHome.removeSavedSchool(s);
	}

	/**
	 * gets the instance of LogonController
	 * 
	 * @return log
	 */
	public LogonController getLog() {
		return log;
	}

	/**
	 * gets the instance of UserHome
	 * 
	 * @return userHome
	 */
	public UserHome getUserHome() {
		return userHome;
	}

	/**
	 * view the member information of user
	 * 
	 * @return String of member info
	 */
	public String viewMemberInfo() {
		return getLog().getMember().toString();
	}
}
