package CMCPackage;

import java.io.IOException;

/**
 * SearchController is a class that has two primary uses: 1. Returning a list of
 * schools that match search criteria from a user 2. Finding the five most
 * similar schools to a certain school.
 * 
 * @author jcblomquist
 * @version 3-14-16
 */
public class SearchController {
	/**
	 * 2D array of the schools that match the search
	 */
	public String[][] matchingSchools;
	/**
	 * 2D array of the schools that match the search, before adding another
	 * matched school
	 */
	public String[][] temp;
	/**
	 * 2D array of the schools that are within the database
	 */
	public String[][] schoolsInLibrary;
	/**
	 * 2D array of the 5 schools that are most similar to the school that is
	 * being viewed
	 */
	public String[][] recommendedSchools;
	/**
	 * 2D array of the schools in the database with a distance value derived
	 * from their similarity to the viewed school
	 */
	public String[][] schoolsWithDistance;
	/**
	 * 2D array of the schools with emphasis given
	 */
	public String[][] listofSchoolsWithEmphasis;
	/**
	 * array of information for a particular school that will be used in finding
	 * related schools
	 */
	public String[] schoolString;
	/**
	 * the database that will be initialized for pulling data
	 */
	public DatabaseController db;
	/**
	 * keeps track of the number of matching schools to deliver an accurate
	 * sized array of matching schools
	 */
	public int count;
	/**
	 * value given to a school based on similarities to a searched school
	 */
	public double distance;
	/**
	 * maximum value of a certain attribute within the database
	 */
	public double max;
	/**
	 * minimum value of a certain attribute within the database
	 */
	public double min;
	/**
	 * holds temporary max/min value while the new value is checked against it
	 */
	public double tempDouble;

	IOException InvalidSearchException = new IOException();

	/**
	 * Constructor for a SearchController object
	 */
	public SearchController() {
		db = new DatabaseController();
	}

	/**
	 * search finds the schools that match the given criteria from a user's
	 * search
	 * 
	 * @param name
	 *            - substring user is searching for in a school's name
	 * @param state
	 *            - substring user is searching for in a school's state
	 * @param location
	 *            - string user is searching for in a school's location
	 * @param control
	 *            - string user is searching for in a school's control
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
			int highNumStudents, double lowPerFemale, double highPerFemale, double lowSatVerbal, double highSatVerbal,
			double lowSatMath, double highSatMath, double lowExpenses, double highExpenses, double lowPerFinancial,
			double highPerFinancial, int lowNumApplicants, int highNumApplicants, double lowPerAdmitted,
			double highPerAdmitted, double lowPerEnrolled, double highPerEnrolled, int lowAcadScale, int highAcadScale,
			int lowSocialScale, int highSocialScale, int lowQOLScale, int highQOLScale, String emph1, String emph2,
			String emph3, String emph4, String emph5) {
		schoolsInLibrary = db.getSchools();
		String[][] invalidSearchString = null;
		if ((lowNumStudents > highNumStudents) && (highNumStudents != -1))
			return invalidSearchString;
		if ((lowPerFemale > highPerFemale) && (highPerFemale != -1))
			return invalidSearchString;
		if ((lowSatVerbal > highSatVerbal) && (highSatVerbal != -1))
			return invalidSearchString;
		if ((lowSatMath > highSatMath) && (highSatMath != -1))
			return invalidSearchString;
		if ((lowExpenses > highExpenses) && (highExpenses != -1))
			return invalidSearchString;
		if ((lowPerFinancial > highPerFinancial) && (highPerFinancial != -1))
			return invalidSearchString;
		if ((lowNumApplicants > highNumApplicants) && (highNumApplicants != -1))
			return invalidSearchString;
		if ((lowPerAdmitted > highPerAdmitted) && (highPerAdmitted != -1))
			return invalidSearchString;
		if ((lowPerEnrolled > highPerEnrolled) && (highPerEnrolled != -1))
			return invalidSearchString;
		if ((lowAcadScale > highAcadScale) && (highAcadScale != -1))
			return invalidSearchString;
		if ((lowSocialScale > highSocialScale) && (highSocialScale != -1))
			return invalidSearchString;
		if ((lowQOLScale > highQOLScale) && (highQOLScale != -1))
			return invalidSearchString;
		count = 0;
		for (int i = 0; i < schoolsInLibrary.length; i++) {
			if (schoolsInLibrary[i][0].contains(name) || name.equals(""))
				if (schoolsInLibrary[i][1].contains(state) || state.equals(""))
					if (schoolsInLibrary[i][2].equals(location) || location.equals(""))
						if (schoolsInLibrary[i][3].equals(control) || control.equals(""))
							if (lowNumStudents <= Integer.parseInt(schoolsInLibrary[i][4])
									&& Integer.parseInt(schoolsInLibrary[i][4]) <= highNumStudents
									|| lowNumStudents <= Integer.parseInt(schoolsInLibrary[i][4])
											&& highNumStudents == -1
									|| highNumStudents >= Integer.parseInt(schoolsInLibrary[i][4])
											&& lowNumStudents == -1
									|| lowNumStudents == -1 && highNumStudents == -1)
								if (lowPerFemale <= Double.parseDouble(schoolsInLibrary[i][5])
										&& Double.parseDouble(schoolsInLibrary[i][5]) <= highPerFemale
										|| lowPerFemale <= Double.parseDouble(schoolsInLibrary[i][5])
												&& highPerFemale == -1
										|| highPerFemale >= Double.parseDouble(schoolsInLibrary[i][5])
												&& lowPerFemale == -1
										|| lowPerFemale == -1 && highPerFemale == -1)
									if (lowSatVerbal <= Double.parseDouble(schoolsInLibrary[i][6])
											&& Double.parseDouble(schoolsInLibrary[i][6]) <= highSatVerbal
											|| lowSatVerbal <= Double.parseDouble(schoolsInLibrary[i][6])
													&& highSatVerbal == -1
											|| highSatVerbal >= Double.parseDouble(schoolsInLibrary[i][6])
													&& lowSatVerbal == -1
											|| lowSatVerbal == -1 && highSatVerbal == -1)
										if (lowSatMath <= Double.parseDouble(schoolsInLibrary[i][7])
												&& Double.parseDouble(schoolsInLibrary[i][7]) <= highSatMath
												|| lowSatMath <= Double.parseDouble(schoolsInLibrary[i][7])
														&& highSatMath == -1
												|| highSatMath >= Double.parseDouble(schoolsInLibrary[i][7])
														&& lowSatMath == -1
												|| lowSatMath == -1 && highSatMath == -1)
											if (lowExpenses <= Double.parseDouble(schoolsInLibrary[i][8])
													&& Double.parseDouble(schoolsInLibrary[i][8]) <= highExpenses
													|| lowExpenses <= Double.parseDouble(schoolsInLibrary[i][8])
															&& highExpenses == -1
													|| highExpenses >= Double.parseDouble(schoolsInLibrary[i][8])
															&& lowExpenses == -1
													|| lowExpenses == -1 && highExpenses == -1)
												if (lowPerFinancial <= Double.parseDouble(schoolsInLibrary[i][9])
														&& Double
																.parseDouble(schoolsInLibrary[i][9]) <= highPerFinancial
														|| lowPerFinancial <= Double.parseDouble(schoolsInLibrary[i][9])
																&& highPerFinancial == -1
														|| highPerFinancial >= Double
																.parseDouble(schoolsInLibrary[i][9])
																&& lowPerFinancial == -1
														|| lowPerFinancial == -1 && highPerFinancial == -1)
													if (lowNumApplicants <= Integer.parseInt(schoolsInLibrary[i][10])
															&& Integer.parseInt(
																	schoolsInLibrary[i][10]) <= highNumApplicants
															|| lowNumApplicants <= Integer
																	.parseInt(schoolsInLibrary[i][10])
																	&& highNumApplicants == -1
															|| highNumApplicants >= Integer
																	.parseInt(schoolsInLibrary[i][10])
																	&& lowNumApplicants == -1
															|| lowNumApplicants == -1 && highNumApplicants == -1)
														if (lowPerAdmitted <= Double
																.parseDouble(schoolsInLibrary[i][11])
																&& Double.parseDouble(
																		schoolsInLibrary[i][11]) <= highPerAdmitted
																|| lowPerAdmitted <= Double
																		.parseDouble(schoolsInLibrary[i][11])
																		&& highPerAdmitted == -1
																|| highPerAdmitted >= Double
																		.parseDouble(schoolsInLibrary[i][11])
																		&& lowPerAdmitted == -1
																|| lowPerAdmitted == -1 && highPerAdmitted == -1)
															if (lowPerEnrolled <= Double
																	.parseDouble(schoolsInLibrary[i][12])
																	&& Double.parseDouble(
																			schoolsInLibrary[i][12]) <= highPerEnrolled
																	|| lowPerEnrolled <= Double
																			.parseDouble(schoolsInLibrary[i][12])
																			&& highPerEnrolled == -1
																	|| highPerEnrolled >= Double
																			.parseDouble(schoolsInLibrary[i][12])
																			&& lowPerEnrolled == -1
																	|| lowPerEnrolled == -1 && highPerEnrolled == -1)
																if (lowAcadScale <= Integer
																		.parseInt(schoolsInLibrary[i][13])
																		&& Integer.parseInt(
																				schoolsInLibrary[i][13]) <= highAcadScale
																		|| lowAcadScale <= Integer
																				.parseInt(schoolsInLibrary[i][13])
																				&& highAcadScale == -1
																		|| highAcadScale >= Integer
																				.parseInt(schoolsInLibrary[i][13])
																				&& lowAcadScale == -1
																		|| lowAcadScale == -1 && highAcadScale == -1)
																	if (lowSocialScale <= Integer
																			.parseInt(schoolsInLibrary[i][14])
																			&& Integer.parseInt(
																					schoolsInLibrary[i][14]) <= highSocialScale
																			|| lowSocialScale <= Integer
																					.parseInt(schoolsInLibrary[i][14])
																					&& highSocialScale == -1
																			|| highSocialScale >= Integer
																					.parseInt(schoolsInLibrary[i][14])
																					&& lowSocialScale == -1
																			|| lowSocialScale == -1
																					&& highSocialScale == -1)
																		if (lowQOLScale <= Integer
																				.parseInt(schoolsInLibrary[i][15])
																				&& Integer.parseInt(
																						schoolsInLibrary[i][15]) <= highQOLScale
																				|| lowQOLScale <= Integer.parseInt(
																						schoolsInLibrary[i][15])
																						&& highQOLScale == -1
																				|| highQOLScale >= Integer.parseInt(
																						schoolsInLibrary[i][15])
																						&& lowQOLScale == -1
																				|| lowQOLScale == -1
																						&& highQOLScale == -1) {
																			boolean emphasisFound = false;
																			listofSchoolsWithEmphasis = db
																					.getSchoolsWithEmphases();
																			for (int m = 0; m < listofSchoolsWithEmphasis.length; m++) {
																				if (listofSchoolsWithEmphasis[m][0]
																						.equals(schoolsInLibrary[i][0])) {
																					if (listofSchoolsWithEmphasis[m][1]
																							.equals(emph1)
																							|| listofSchoolsWithEmphasis[m][1]
																									.equals(emph2)
																							|| listofSchoolsWithEmphasis[m][1]
																									.equals(emph3)
																							|| listofSchoolsWithEmphasis[m][1]
																									.equals(emph4)
																							|| listofSchoolsWithEmphasis[m][1]
																									.equals(emph5)
																							|| ((emph1.equals("")) && (emph2.equals("")) && (emph3.equals("")) && (emph4.equals("")) && (emph5.equals("")))){
																						emphasisFound = true;
																						break;
																					}

																				}
																			}
																			if (emphasisFound) {
																				temp = matchingSchools;
																				matchingSchools = new String[count
																						+ 1][18];
																				for (int k = 0; k < count; k++) {
																					for (int l = 0; l < 18; l++) {
																						matchingSchools[k][l] = temp[k][l];
																					}
																				}
																				for (int j = 0; j < schoolsInLibrary[i].length; j++)
																					matchingSchools[count][j] = schoolsInLibrary[i][j];
																				count++;
																			}
																		}
		}
		return matchingSchools;
	}

	/**
	 * getMax finds the maximum value of a certain attribute in all of the
	 * schools
	 * 
	 * @param i
	 *            - the index to look in for the specific attribute
	 * @return the maximum value of the attribute
	 */
	public double getMax(int i) {
		if ((i < 4) || (i > 15))
			return -1.0;
		schoolsInLibrary = db.getSchools();
		max = Double.parseDouble(schoolsInLibrary[0][i]);
		for (int j = 0; j < schoolsInLibrary.length; j++) {
			tempDouble = Double.parseDouble(schoolsInLibrary[j][i]);
			if (tempDouble > max)
				max = tempDouble;
		}
		return max;
	}

	/**
	 * getMin finds the minimum value of a certain attribute in all of the
	 * schools
	 * 
	 * @param i
	 *            - the index to look in for the specific attribute
	 * @return the minimum value of the attribute
	 */
	public double getMin(int i) {
		if ((i < 4) || (i > 15))
			return -1;
		schoolsInLibrary = db.getSchools();
		min = -1;
		int k = 0;
		while (min == -1) {
			min = Double.parseDouble(schoolsInLibrary[k][i]);
			k++;
		}
		for (int j = 0; j < schoolsInLibrary.length; j++) {
			tempDouble = Double.parseDouble(schoolsInLibrary[j][i]);
			if (tempDouble == -1)
				continue;
			if (tempDouble < min)
				min = tempDouble;
		}
		return min;
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
	public String[][] getRecommendedSchools(School s) {
		schoolsInLibrary = db.getSchools();
		recommendedSchools = new String[5][17];
		schoolString = new String[16];
		schoolsWithDistance = new String[schoolsInLibrary.length][17];
		schoolString[0] = s.getName();
		schoolString[1] = s.getState();
		schoolString[2] = s.getLocation();
		schoolString[3] = s.getControl();
		schoolString[4] = Integer.toString(s.getNumStudents());
		schoolString[5] = Double.toString(s.getPerFemale());
		schoolString[6] = Double.toString(s.getSatVerbal());
		schoolString[7] = Double.toString(s.getSatMath());
		schoolString[8] = Double.toString(s.getExpenses());
		schoolString[9] = Double.toString(s.getPerFinancial());
		schoolString[10] = Integer.toString(s.getNumApplicants());
		schoolString[11] = Double.toString(s.getPerAdmitted());
		schoolString[12] = Double.toString(s.getPerEnrolled());
		schoolString[13] = Integer.toString(s.getAcadScale());
		schoolString[14] = Integer.toString(s.getSocialScale());
		schoolString[15] = Integer.toString(s.getQOLScale());
		for (int i = 0; i < schoolsInLibrary.length; i++) {
			// names will obviously be different, so they are ignored. If it is
			// the school itself, we skip it.
			distance = 0;
			if (schoolString[0].equals(schoolsInLibrary[i][0]))
				continue;
			if (schoolString[1] != schoolsInLibrary[i][1])
				distance += 1;
			if (schoolString[2] != schoolsInLibrary[i][2])
				distance += 1;
			if (schoolString[3] != schoolsInLibrary[i][3])
				distance += 1;
			for (int j = 4; j < 16; j++) {
				distance += (Math.abs(Double.parseDouble(schoolString[j]) - Double.parseDouble(schoolsInLibrary[i][j]))
						/ (getMax(j) - getMin(j)));
			}
			// the distances are now obtained, so we create a new array with one
			// more column, for distance
			for (int k = 0; k < 16; k++) {
				schoolsWithDistance[i][k] = schoolsInLibrary[i][k];
			}
			// we need to 'manually' sort the first five schools, because
			// attempting to sort
			// them with an empty array would not insert them in (distance > 0
			// for all schools)
			schoolsWithDistance[i][16] = Double.toString(distance);
			if (i == 0) {
				recommendedSchools[0] = schoolsWithDistance[i];
			}
			if (i == 1) {
				if (distance < Double.parseDouble(recommendedSchools[0][16])) {
					recommendedSchools[1] = recommendedSchools[0];
					recommendedSchools[0] = schoolsWithDistance[i];
				} else
					recommendedSchools[1] = schoolsWithDistance[i];
			}
			if (i == 2) {
				if (distance < Double.parseDouble(recommendedSchools[0][16])) {
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = recommendedSchools[0];
					recommendedSchools[0] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[1][16])) {
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = schoolsWithDistance[i];
				} else
					recommendedSchools[2] = schoolsWithDistance[i];
			}
			if (i == 3) {
				if (distance < Double.parseDouble(recommendedSchools[0][16])) {
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = recommendedSchools[0];
					recommendedSchools[0] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[1][16])) {
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[2][16])) {
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = schoolsWithDistance[i];
				} else
					recommendedSchools[3] = schoolsWithDistance[i];
			}
			if (i == 4) {
				if (distance < Double.parseDouble(recommendedSchools[0][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = recommendedSchools[0];
					recommendedSchools[0] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[1][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[2][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[3][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = schoolsWithDistance[i];
				} else
					recommendedSchools[4] = schoolsWithDistance[i];
			}
			// this case is used in the instance that one one the fist five
			// schools in the library is being compared against
			if (i == 5) {
				if (distance < Double.parseDouble(recommendedSchools[0][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = recommendedSchools[0];
					recommendedSchools[0] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[1][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[2][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[3][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[4][16])) {
					recommendedSchools[4] = schoolsWithDistance[i];
				} else if (Double.parseDouble(recommendedSchools[4][16]) == 0) {
					recommendedSchools[4] = schoolsWithDistance[i];
				}
			}
			// this if loop goes through the remaining schools, sorting them as
			// necessary
			if (i > 5) {
				if (distance < Double.parseDouble(recommendedSchools[0][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = recommendedSchools[0];
					recommendedSchools[0] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[1][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = recommendedSchools[1];
					recommendedSchools[1] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[2][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = recommendedSchools[2];
					recommendedSchools[2] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[3][16])) {
					recommendedSchools[4] = recommendedSchools[3];
					recommendedSchools[3] = schoolsWithDistance[i];
				} else if (distance < Double.parseDouble(recommendedSchools[4][16])) {
					recommendedSchools[4] = schoolsWithDistance[i];
				}
			}
			// String schoolName = schoolsWithDistance[i][0];
			// if(distance < 20.0){
			// System.out.println(schoolName);
			// System.out.println(distance);
			// } //use this to check distance values of schools
		}
		return recommendedSchools;
	}
}
