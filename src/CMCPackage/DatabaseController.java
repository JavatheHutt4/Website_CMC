package CMCPackage; 
import dblibrary.project.csci230.*;  


/**
 * This class is the DatabaseController class--the one that will be getting our data from our database.
 * For any method that is called by the controller classes that needs information from the database,
 * DatabaseController will retrieve that information and pass it along to the desired controller
 * 
 * @author jcblomquist
 * @version 3/10/2016
 *
 */
public class DatabaseController {

	/**
	 * the database library that will be used to retrieve, add, remove, and update information
	 */
	public UniversityDBLibrary databaseLibrary;
	/**
	 * a 2D array of all of the schools from the database
	 */
	public String[][] schoolsFromLibrary;
	/**
	 * a 2D array of all of the users from the database
	 */
	public String[][] usersFromLibrary;
	/**
	 * a 2D array of all of the schools from the database, with their emphasis
	 */
	public String[][] schoolsWithEmphasis;
	/**
	 * a 2D array of all of the usernames with their saved schools
	 */
	public String[][] usernamesWithSavedSchools;
	
	/**
	 * DatabaseController constructor
	 */
	public DatabaseController(){
		databaseLibrary = new UniversityDBLibrary("javathehut", "javathehut", "jjjt4");
	}
	
	/**
	 * addSchool allows a new school to be added to the UniversityDBLibrary. It first checks to see
	 * if there is already a school with that name. If there is, it returns an int value of -1,
	 * implying that the school was not added.
	 * 
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param perFemale
	 * @param satVerbal
	 * @param satMath
	 * @param expenses
	 * @param perFinancial
	 * @param numApplicants
	 * @param perAdmitted
	 * @param perEnrolled
	 * @param acadScale
	 * @param socialScale
	 * @param QOLScale
	 * @return 1 if successful, -1 if unsuccessful
	 */
	public int addSchool(String name, String state, String location, String control, int numStudents, double perFemale, double satVerbal, double satMath, 
			double expenses, double perFinancial, int numApplicants, double perAdmitted, double perEnrolled, int acadScale, int socialScale, int QOLScale){
		if(!(state.equals("ALABAMA") || state.equals("ALASKA") || state.equals("ARIZONA") || state.equals("ARKANSAS") || state.equals("CALIFORNIA") ||
				state.equals("COLORADO") || state.equals("CONNECTICUT") || state.equals("DELAWARE") || state.equals("FLORIDA") || state.equals("GEORGIA") || 
				state.equals("HAWAII") || state.equals("IDAHO") || state.equals("ILLINOIS") || state.equals("INDIANA") || state.equals("IOWA") || 
				state.equals("KANSAS") || state.equals("KENTUCKY") || state.equals("LOUISIANA") || state.equals("MAINE") || state.equals("MARYLAND") || 
				state.equals("MASSACHUSETTS") || state.equals("MICHIGAN") || state.equals("MINNESOTA") || state.equals("MISSISSIPPI") || state.equals("MISSOURI") || 
				state.equals("MONTANA") || state.equals("NEBRASKA") || state.equals("NEVADA") || state.equals("NEW HAMPSHIRE") || state.equals("NEW JERSEY") || 
				state.equals("NEW MEXICO") || state.equals("NEW YORK") || state.equals("NORTH CAROLINA") || state.equals("NORTH DAKOTA") || state.equals("OHIO") || 
				state.equals("OKLAHOMA") || state.equals("OREGON") || state.equals("PENNSYLVANIA") || state.equals("RHODE ISLAND") || state.equals("SOUTH CAROLINA") || 
				state.equals("SOUTH DAKOTA") || state.equals("TENNESSEE") || state.equals("TEXAS") || state.equals("UTAH") || state.equals("VERMONT") || 
				state.equals("VIRGINIA") || state.equals("WASHINGTON") || state.equals("WEST VIRGINIA") || state.equals("WISCONSIN") || state.equals("WYOMING") || 
				state.equals("DISTRICT OF COLUMBIA") || state.equals("FOREIGN") || state.equals("-1")))
			return -1;
		if(!(location.equals("SUBURBAN") || location.equals("URBAN") || location.equals("SMALL-CITY") || location.equals("-1")))
			return -1;
		if(!(control.equals("PRIVATE") || control.equals("STATE") || control.equals("CITY") || control.equals("-1")))
			return -1;
		if(numStudents < -1)
			return -1;
		if((perFemale < 0 || perFemale > 100) && perFemale != -1)
			return -1;
		if((satVerbal > 800) || (satVerbal < -1))
			return -1;
		if((satMath > 800) || (satMath < -1))
			return -1;
		if(expenses < -1)
			return -1;
		if((perFinancial < 0 || perFinancial > 100) && perFinancial != -1)
			return -1;
		if(numApplicants < -1)
			return -1;
		if((perAdmitted < 0 || perAdmitted > 100) && perAdmitted != -1)
			return -1;
		if((perEnrolled < 0 || perEnrolled > 100) && perEnrolled != -1)
			return -1;
		if((acadScale > 5) || ((acadScale < 1) && (acadScale != -1)))
			return -1;
		if((socialScale > 5) || ((socialScale < 1) && (socialScale != -1)))
			return -1;
		if((QOLScale > 5) || ((QOLScale < 1) && (QOLScale != -1)))
			return -1;
		return databaseLibrary.university_addUniversity(name, state, location, control, numStudents, perFemale, satVerbal, satMath, expenses,
				perFinancial, numApplicants, perAdmitted, perEnrolled, acadScale, socialScale, QOLScale);
	}
	/**
	 * editSchool checks to see that a school exists within the database, then updates its information when
	 * it is found. The parameters that will be updated are given by the user.
	 * 
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param perFemale
	 * @param satVerbal
	 * @param satMath
	 * @param expenses
	 * @param perFinancial
	 * @param numApplicants
	 * @param perAdmitted
	 * @param perEnrolled
	 * @param acadScale
	 * @param socialScale
	 * @param QOLScale
	 * @return 1 if successful, -1 if unsuccessful
	 */
	public int editSchool(String name, String state, String location, String control, int numStudents, double perFemale, double satVerbal, double satMath, 
			double expenses, double perFinancial, int numApplicants, double perAdmitted, double perEnrolled, int acadScale, int socialScale, int QOLScale){
		schoolsFromLibrary = databaseLibrary.university_getUniversities();
		if(!(state.equals("ALABAMA") || state.equals("ALASKA") || state.equals("ARIZONA") || state.equals("ARKANSAS") || state.equals("CALIFORNIA") ||
				state.equals("COLORADO") || state.equals("CONNECTICUT") || state.equals("DELAWARE") || state.equals("FLORIDA") || state.equals("GEORGIA") || 
				state.equals("HAWAII") || state.equals("IDAHO") || state.equals("ILLINOIS") || state.equals("INDIANA") || state.equals("IOWA") || 
				state.equals("KANSAS") || state.equals("KENTUCKY") || state.equals("LOUISIANA") || state.equals("MAINE") || state.equals("MARYLAND") || 
				state.equals("MASSACHUSETTS") || state.equals("MICHIGAN") || state.equals("MINNESOTA") || state.equals("MISSISSIPPI") || state.equals("MISSOURI") || 
				state.equals("MONTANA") || state.equals("NEBRASKA") || state.equals("NEVADA") || state.equals("NEW HAMPSHIRE") || state.equals("NEW JERSEY") || 
				state.equals("NEW MEXICO") || state.equals("NEW YORK") || state.equals("NORTH CAROLINA") || state.equals("NORTH DAKOTA") || state.equals("OHIO") || 
				state.equals("OKLAHOMA") || state.equals("OREGON") || state.equals("PENNSYLVANIA") || state.equals("RHODE ISLAND") || state.equals("SOUTH CAROLINA") || 
				state.equals("SOUTH DAKOTA") || state.equals("TENNESSEE") || state.equals("TEXAS") || state.equals("UTAH") || state.equals("VERMONT") || 
				state.equals("VIRGINIA") || state.equals("WASHINGTON") || state.equals("WEST VIRGINIA") || state.equals("WISCONSIN") || state.equals("WYOMING") || 
				state.equals("DISTRICT OF COLUMBIA") || state.equals("FOREIGN") || state.equals("-1")))
			return -1;
		if(!(location.equals("SUBURBAN") || location.equals("URBAN") || location.equals("SMALL-CITY") || location.equals("-1")))
			return -1;
		if(!(control.equals("PRIVATE") || control.equals("STATE") || control.equals("CITY") || control.equals("-1")))
			return -1;
		if(numStudents < -1)
			return -1;
		if((perFemale < 0 || perFemale > 100) && perFemale != -1)
			return -1;
		if((satVerbal > 800) || (satVerbal < -1))
			return -1;
		if((satMath > 800) || (satMath < -1))
			return -1;
		if(expenses < -1)
			return -1;
		if((perFinancial < 0 || perFinancial > 100) && perFinancial != -1)
			return -1;
		if(numApplicants < -1)
			return -1;
		if((perAdmitted < 0 || perAdmitted > 100) && perAdmitted != -1)
			return -1;
		if((perEnrolled < 0 || perEnrolled > 100) && perEnrolled != -1)
			return -1;
		if((acadScale > 5) || ((acadScale < 1) && (acadScale != -1)))
			return -1;
		if((socialScale > 5) || ((socialScale < 1) && (socialScale != -1)))
			return -1;
		if((QOLScale > 5) || ((QOLScale < 1) && (QOLScale != -1)))
			return -1;
		for(int i = 0; i < schoolsFromLibrary.length; i++){
			if(schoolsFromLibrary[i][0].equals(name)){
				return databaseLibrary.university_editUniversity(name, state, location, control, numStudents, perFemale, 
				satVerbal, satMath, expenses, perFinancial, numApplicants, perAdmitted, perEnrolled, acadScale, socialScale, QOLScale);
			}			
		}
		return -1;
	}
	/**
	 * addNewMember adds a new member to the CMC system. It checks to see if there is already a member
	 * with the desired username- if there is not, the new member is added to the system.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param type
	 * @return 1 if successful, -1 if unsuccessful
	 */
	public int addNewMember(String firstName, String lastName, String username, String password, char type){
		usersFromLibrary = databaseLibrary.user_getUsers();
		if((type != 'a') && (type != 'u')){
			return -1;
		}
		for(int i = 0; i < usersFromLibrary.length; i++){
			if(usersFromLibrary[i][2].equals(username))
				return -1;
			else
				continue;
		}
		return databaseLibrary.user_addUser(firstName, lastName, username, password, type);
		
	}
	
	/**
	 * editUser takes information for as user as a parameter from an admin and attempts to update
	 * the information. It first searches for a user with the username, then updates the other information.
	 * It searches for the username because it is uneditable by the admin.
	 *
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param type
	 * @param status
	 * @return 1 if successful, -1 if unsuccessful
	 */
	public int editUser(String firstName, String lastName, String username, String password, char type, char status){
		usersFromLibrary = databaseLibrary.user_getUsers();
		if((type != 'a' && type != 'u') || (status != 'Y' && status != 'N'))
			return -1;
		for(int i = 0; i < usersFromLibrary.length; i++){
			if(usersFromLibrary[i][2].equals(username)){
				return databaseLibrary.user_editUser(username, firstName, lastName, password, type, status);
			}
			else
				continue;
		}
		return -1;	
	}
	
	/**
	 * getUsers fetches all of the users stored in the database and provides them to the user
	 * 
	 * @return all of the users in the library
	 */
	public String[][] getUsers(){
		usersFromLibrary = databaseLibrary.user_getUsers();
		return usersFromLibrary;
		
	}
	
	/**
	 * getSchools fetches all of the schools stored in the database and provides them to the user
	 * 
	 * @return all of the users in the library
	 */
	public String[][] getSchools(){
		schoolsFromLibrary = databaseLibrary.university_getUniversities();
		return schoolsFromLibrary;
	}
	
	/**
	 * findByName fetches the information for a user based on a userName parameter
	 * 
	 * @param user representing userName to search for
	 * @return Member object of the user found, or null if no member exists
	 */
	public Member findByName(String username){
		usersFromLibrary = databaseLibrary.user_getUsers();
		
		for(int i = 0; i < usersFromLibrary.length; i++){
			if(usersFromLibrary[i][2].equals(username)){
				if(usersFromLibrary[i][4].charAt(0) == 'a')
					return new Admin( usersFromLibrary[i][0], usersFromLibrary[i][1], usersFromLibrary[i][2], 
							usersFromLibrary[i][3],usersFromLibrary[i][5].charAt(0));
				else
					return new User( usersFromLibrary[i][0], usersFromLibrary[i][1],usersFromLibrary[i][2], 
							usersFromLibrary[i][3],usersFromLibrary[i][5].charAt(0));
			}
		}
		return null;
	}
	
	/**
	 * getSchoolsWithEmphases fetches the information for all schools and their emphases
	 * 
	 * @param user representing userName to search for
	 * @return 2D string array with the school emphases
	 */
	public String[][] getSchoolsWithEmphases(){
		schoolsWithEmphasis = databaseLibrary.university_getNamesWithEmphases();
		return schoolsWithEmphasis;
	}

	/**
	 * saveSchool calls the user_saveSchool method from the UniversityDBLibrary class
	 * 
	 * @param userName of the agent
	 * @param school name
	 * @return int representing number of schools added, -1 if the operation failed
	 */
	public int saveSchool(String userName, String school) {
		return databaseLibrary.user_saveSchool(userName,school);
	}

	/**
	 * removeSchool calls the user_removeSchool method from the UniversityDBLibrary class
	 * 
	 * @param userName of the agent
	 * @param school name
	 * @return int representing number of schools removed, -1 if the operation failed
	 */
	public int removeSchool(String userName, String school) {
		return databaseLibrary.user_removeSchool(userName, school);
	}
	
	/**
	 * addUniversityEmphasis adds an emphasis, paired with a school, to the database
	 * @param school
	 * @param emphasis 
	 * @return 1 if successful, -1 if the school/emphasis pair already existed
	 */
	public int addUniversityEmphasis(String school, String emphasis){
		schoolsWithEmphasis = databaseLibrary.university_getNamesWithEmphases();
		for(int i = 0; i < schoolsWithEmphasis.length; i++){
			if(schoolsWithEmphasis[i][0].equals(school) && schoolsWithEmphasis[i][1].equals(emphasis)){
				return -1;
			} 
		}
		return databaseLibrary.university_addUniversityEmphasis(school, emphasis);
	}
	
//	public int deleteUniversityEmphasis(String school, String emphasis){
//		schoolsWithEmphasis = databaseLibrary.university_getNamesWithEmphases();
//		for(int i = 0; i < schoolsWithEmphasis.length; i++){
//			if(schoolsWithEmphasis[i][0].equals(school) && schoolsWithEmphasis[i][1].equals(emphasis)){
//				return -1;
//			} 
//		}
//		return databaseLibrary.university_addUniversityEmphasis(school, emphasis);
//	}
	
	/**
	 * getUsernamesWithSavedSchools fetches a 2d array of the users with their saved schools from the database
	 * @return users with their saved schools
	 */
	 public String[][] getUsernamesWithSavedSchools(){
	 	usernamesWithSavedSchools = databaseLibrary.user_getUsernamesWithSavedSchools();
	 	return usernamesWithSavedSchools; 
	 }
}
