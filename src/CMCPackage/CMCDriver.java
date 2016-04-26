package CMCPackage;

/**
 * driver class for the CMC project to demonstrate its uses
 * 
 * @author tdrichmond
 * @version 03/14/16
 *
 */
public class CMCDriver {

	// MUST EDIT USER AND SCHOOL BACK TO PREVIOUS STATE

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AdminUI adminUI = new AdminUI();
		UserUI userUI = new UserUI();
		SchoolHome schoolHome = new SchoolHome();

		System.out.println("********************************Tests for user agent uses********************************");
		// testing user logon with invalid username and password
		userUI.logon("invalid", "invalid");
		// testing user logon with valid username and password
		userUI.logon("juser", "user");
		// prints the info for current user
		System.out.println(userUI.viewMemberInfo());
		// tests the users ability to manage own profile
		System.out.println("\nUsing manage profile to change name and password of user:");
		userUI.manageMyProfile("Stanley", "Steamer", "CarpetCleaner");
		System.out.println(userUI.viewMemberInfo());
		userUI.manageMyProfile("John", "User", "user");
		// tests search method for BARUCH college
		System.out.println("\nSearching for college BARUCH in NEW YORK...");
		String[][] searchResults = userUI.search("BARUCH", "NEW YORK", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, "", "", "", "", "");
		for (int i = 0; i < searchResults.length; i++) {
			System.out.println(userUI.viewSpecificSchool(searchResults[i][0]));
		}
		// tests the view specific search results
		System.out.println("\nViewing specific details for ST JOHNS UNIVERSITY:");
		System.out.println(userUI.viewSpecificSchool("ST JOHNS UNIVERSITY"));
		System.out.println("\nSearching for recommended schools related to WASHINGTON AND LEE college:");
		//String[][] recommendedSchools = userUI.recommendSchool(schoolHome.findByName("WASHINGTON AND LEE"));
		//for (int i = 0; i < recommendedSchools.length; i++) {
			//System.out.println(schoolHome.findByName(recommendedSchools[i][0]));
		//}
		// testing the save school function
		System.out.println("\nTesting if save school works with invalid and valid cases");
		userUI.saveSchool("RAHAL UNIVERSITY");
		userUI.saveSchool("BARUCH");
		System.out.println(userUI.viewSavedSchools());
		// testing the remove saved school function
		System.out.println("Removing BARUCH from saved schools\n");
		userUI.removeSavedSchool("BARUCH");

		// test logoff function for user entity
		userUI.logoff();

		System.out.println(
				"\n********************************Tests for admin agent uses********************************");
		// testing admin logon with invalid username and password
		adminUI.logon("invalid", "invalid");
		// testing admin logon with valid username and password
		adminUI.logon("nadmin", "admin");
		// prints the info for current admin
		System.out.println(adminUI.viewMemberInfo());
		// tests the add new member case
		System.out.println("\nTesting manipulation of members by admin -");
		System.out.println("\nInformation of added member -");
		adminUI.addMember("new", "member", "newMember", "password", 'u', 'Y');
		System.out.println(userUI.getUserHome().findByName("newMember"));
		// tests the edit new member case, changing the first name to "moreNew"
		System.out.println("\nInformation of edited member -");
		adminUI.editMember("moreNew", "member", "newMember", "password", 'u', 'Y');
		System.out.println(userUI.getUserHome().findByName("newMember"));
		adminUI.deactivateMember(adminUI.getAdminHome().findByName("newMember"));
		adminUI.editMember("new", "member", "newMember", "password", 'u', 'Y');
		System.out.println("\nDeactivating User...\nStatus of user after deactivation: "
				+ adminUI.getAdminHome().findByName("newMember").getStatus());
		System.out.println("\nTesting manipulation of universites by admin -");
		// tests the add new university case
		adminUI.addUniversity("myUniversity", "Minnesota", "Small-City", "Private", 9001, 50, 50, 50, 50000, 90, 12,
				100, 2, 4, 5, 2);
		System.out.println("Adding new school called myUniversity:");
		System.out.println(schoolHome.findByName("myUniversity"));
		// tests the edit university case, changing the state to Maryland
		adminUI.editUniversity("myUniversity", "Maryland", "Small-City", "Private", 9001, 50, 50, 50, 50000, 90, 12,
				100, 2, 4, 5, 5);
		System.out.println("Editing myUniversity to be in Maryland:");
		System.out.println(schoolHome.findByName("myUniversity") + "\n");
		// test logoff function for admin entity
		adminUI.logoff();
	}
}
