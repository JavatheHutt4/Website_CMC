package CMCPackage;

/**
 * SchoolHome class to control the Schools in the CMC system
 * 
 * @author jrfolkerds
 * @version 3/14/2016
 */
public class SchoolHome {

	/**
	 * Instance of School to be used
	 */
	public School school;

	/**
	 * DatabaseController object to access the database
	 */
	public DatabaseController db;

	/**
	 * Constructor method for SchoolHome
	 */
	public SchoolHome() {
		db = new DatabaseController();
	}

	/**
	 * Method that constructs and returns a school object from the String name
	 * of the school
	 * 
	 * @param the
	 *            school name as a string
	 * @return the school as a School object
	 */
	public School findByName(String school) {
		String[][] all = db.getSchools();
		String[] emphasis = this.getSchoolEmphases(school);
		for (int i = 0; i < all.length; i++) {
			if (all[i][0].equals(school)) {
				School s = new School(all[i][0], all[i][1], all[i][2], all[i][3], Integer.parseInt(all[i][4]),
						Integer.parseInt(all[i][5]), Integer.parseInt(all[i][6]), Integer.parseInt(all[i][7]),
						Integer.parseInt(all[i][8]), Integer.parseInt(all[i][9]), Integer.parseInt(all[i][10]),
						Integer.parseInt(all[i][11]), Integer.parseInt(all[i][12]), Integer.parseInt(all[i][13]),
						Integer.parseInt(all[i][14]), Integer.parseInt(all[i][15]), emphasis);
				return s;
			}
		}
		return null;
	}

	/**
	 * Method to return the emphases for a specified school
	 * 
	 * @param school
	 *            the name of the school as a String
	 * @returns String array containing every emphasis of the School
	 */
	public String[] getSchoolEmphases(String school) {
		String[][] all = db.getSchoolsWithEmphases();
		String[] emphases = new String[5];
		int j = 0;
		for (int i = 0; i < all.length; i++) {
			if (all[i][0].equals(school)) {
				emphases[j] = all[i][1];
				j++;
			}
		}
		return emphases;
	}

	/**
	 * Class to return array of all universities
	 * 
	 * @return a 2d array of every school with all of the school's information
	 */
	public String[][] getAllUniversities() {
		return db.getSchools();
	}

}
