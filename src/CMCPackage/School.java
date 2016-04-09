package CMCPackage;
import java.util.Arrays;

/**
 * Class to represent a school
 * @author tdrichmond (Jon helped too), jrfolkerds
 * @version 3/14/2016
 */
public class School {
	
	//School name
	private String name;
	//State where the school is located
	private String state;
	//Type of location(urban, rural)
	private String location;
	//Public or private
	private String control;
	//Number of students
	private int numStudents;
	//Percent of female students
	private double perFemale;
	//Average SAT Verbal score
	private double satVerbal;
	//Average SAT Math score
	private double satMath;
	//Tuition
	private double expenses;
	//Percent of students receiving financial aid
	private double perFinancial;
	//Number of applicants annually
	private int numApplicants;
	//Percent of applicants admitted
	private double perAdmitted;
	//Percent of applicants enrolled
	private double perEnrolled;
	//Academic scale 1-5 (5 is best)
	private int acadScale;
	//Social life scale 1-5
	private int socialScale;
	//Quality of life scale 1-5
	private int QOLScale;
	//String array containing the School's emphasis
	private String[] emphasis;
	
	/**;
	 * Constructor method for School
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
	 * @param emphasis
	 */
	public School(String name, String state, String location, String control, int numStudents,
			double perFemale, double satVerbal, double satMath, double expenses, double perFinancial, int numApplicants,  
			double perAdmitted, double perEnrolled, int acadScale, int socialScale, int QOLScale, String[] emphasis){
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numStudents = numStudents;
		this.perFemale = perFemale;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.expenses = expenses;
		this.perFinancial = perFinancial;
		this.numApplicants = numApplicants;
		this.perAdmitted = perAdmitted;
		this.perEnrolled = perEnrolled;
		this.acadScale = acadScale;
		this.socialScale = socialScale;
		this.QOLScale = QOLScale;
		this.emphasis = emphasis;
	}
	
	/**
	 * Method to set information of existing school
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
	 * @param emphasis
	 */
	public void setInformation(String name, String state, String location, String control, int numStudents,
			double perFemale, double satVerbal, double satMath, double expenses, double perFinancial, int numApplicants,  
			double perAdmitted, double perEnrolled, int acadScale, int socialScale, int QOLScale, String[] emphasis){
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numStudents = numStudents;
		this.perFemale = perFemale;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.expenses = expenses;
		this.perFinancial = perFinancial;
		this.numApplicants = numApplicants;
		this.perEnrolled = perEnrolled;
		this.acadScale = acadScale;
		this.socialScale = socialScale;
		this.QOLScale = QOLScale;
		this.emphasis = emphasis;
	}
	
	/**
	 * Get the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the state
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Get the location
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Get the control
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * Get the number of students
	 * @return the numStudents
	 */
	public int getNumStudents() {
		return numStudents;
	}

	/**
	 * Get the percentage of female students
	 * @return the perFemale
	 */
	public double getPerFemale() {
		return perFemale;
	}

	/**
	 * Get the average SAT Verbal score
	 * @return the satVerbal
	 */
	public double getSatVerbal() {
		return satVerbal;
	}

	/**
	 * Get the average SAT Math score
	 * @return the satMath
	 */
	public double getSatMath() {
		return satMath;
	}

	/**
	 * Get the cost of tuition
	 * @return the expenses
	 */
	public double getExpenses() {
		return expenses;
	}

	/**
	 * Get the percent of students on financial aid
	 * @return the perFinancial
	 */
	public double getPerFinancial() {
		return perFinancial;
	}

	/**
	 * Get the number of applicants
	 * @return the numApplicants
	 */
	public int getNumApplicants() {
		return numApplicants;
	}

	/**
	 * Get the percent of applicants admitted
	 * @return the perAdmitted
	 */
	public double getPerAdmitted() {
		return perAdmitted;
	}

	/**
	 * Get the percent of admitted applicants enrolled
	 * @return the perEnrolled
	 */
	public double getPerEnrolled() {
		return perEnrolled;
	}

	/**
	 * Get the academic scale (1-5; 5 is best)
	 * @return the acadScale
	 */
	public int getAcadScale() {
		return acadScale;
	}

	/**
	 * Get the social scale (1-5)
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}

	/**
	 * Get the quality of life scale (1-5)
	 * @return the qOLScale
	 */
	public int getQOLScale() {
		return QOLScale;
	}
	
	/**
	 * Get an array of the emphases for the school
	 * @return the String array of emphasis'
	 */
	public String[] getEmphasis(){
		return emphasis;
	}

	
	/**
	 * Method that returns a String with the School name, state, and location.
	 * @return the school name, date, and location
	 */
	public String viewSchoolDetails(){
		return "Name: " + name + "\tState: "+ state +"\tLocation: "+location;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "School [name=" + name + ", state=" + state + ", location=" + location + ", control=" + control
				+ ", numStudents=" + numStudents + ", perFemale=" + perFemale + ", satVerbal=" + satVerbal
				+ ", satMath=" + satMath + ", expenses=" + expenses + ", perFinancial=" + perFinancial
				+ ", numApplicants=" + numApplicants + ", perAdmitted=" + perAdmitted + ", perEnrolled=" + perEnrolled
				+ ", acadScale=" + acadScale + ", socialScale=" + socialScale + ", QOLScale=" + QOLScale + ", emphasis="
				+ Arrays.toString(emphasis) + "]";
	}
	
	
	
}
