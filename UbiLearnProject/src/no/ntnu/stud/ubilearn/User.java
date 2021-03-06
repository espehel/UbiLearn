package no.ntnu.stud.ubilearn;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.parse.Parse;
import com.parse.ParseUser;

import android.content.Context;
import android.util.Log;
import no.ntnu.stud.ubilearn.db.TrainingDAO;
import no.ntnu.stud.ubilearn.models.*;
import no.ntnu.stud.ubilearn.parse.SyncContent;
/**
 * singleton class for storing application data
 * @author ingeborgoftedal
 *
 */
public class User {
	private ArrayList<CasePatient> casePatientList = new ArrayList<CasePatient>();
	private HashMap<String, CasePatientStatus> mapCasePatientStatus = new HashMap<String, CasePatientStatus>();

	private static User instance;
	private int _level = 1;
	ArrayList<CasePatient> temp = new ArrayList<CasePatient>();
	private int patientLevel;

	/**
	 * This is used to hold testdata representing the name of the user.
	 */
	private String _name;

	public HashMap<String, CasePatientStatus> getMapCasePatientStatus() {
		return mapCasePatientStatus;
	}

	public void setMapCasePatientStatus(
			HashMap<String, CasePatientStatus> mapCasePatientStatus) {
		this.mapCasePatientStatus = mapCasePatientStatus;
	}

	/**
	 * This is used to hold testdata representing different levels containing
	 * different houses.
	 */
	private List<TrainingLevel> _levelList;

	private int level = 1;
	private ArrayList<ListItem> exercises;
	private int currentLevel;

	// #########################################################################
	private User() {
		this.exercises = null;
		
		
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Test using initialized objects of type TrainingHouse and
		// TrainingLevel.
		_name = "Ola Nordman"; // Test name.

		_levelList = new ArrayList<TrainingLevel>();

		List<TrainingHouse> houseListLevel1 = new ArrayList<TrainingHouse>(
				Arrays.asList(new TrainingHouse("Dagmar", true, 6, 8),
						new TrainingHouse("Hallvard", false, 4, 12),
						new TrainingHouse("Fredrik", false, 10, 14),
						new TrainingHouse("Ragnhild", false, 4, 9),
						new TrainingHouse("Kyrre", true, 11, 11),
						new TrainingHouse("Espen", true, 13, 15),
						new TrainingHouse("Ingeborg", false, 2, 4),
						new TrainingHouse("Vegard", false, 0, 9),
						new TrainingHouse("Haldis", false, 0, 11),
						new TrainingHouse("Alfredo", false, 0, 9),
						new TrainingHouse("Kristian", false, 0, 15)));

		List<TrainingHouse> houseListLevel2 = new ArrayList<TrainingHouse>(
				Arrays.asList(new TrainingHouse("House 1", true, 10, 10),
						new TrainingHouse("House 2", true, 10, 10),
						new TrainingHouse("House 3", true, 10, 10),
						new TrainingHouse("House 4", true, 10, 10),
						new TrainingHouse("House 5", true, 10, 10)));

		List<TrainingHouse> houseListLevel3 = new ArrayList<TrainingHouse>(
				Arrays.asList(new TrainingHouse("House 1", false, 3, 10),
						new TrainingHouse("House 2", false, 0, 10),
						new TrainingHouse("House 3", false, 0, 10),
						new TrainingHouse("House 4", false, 0, 10),
						new TrainingHouse("House 5", false, 0, 10)));

		List<TrainingHouse> houseListLevel4 = new ArrayList<TrainingHouse>(
				Arrays.asList(new TrainingHouse("House 1", false, 0, 10),
						new TrainingHouse("House 2", false, 0, 10),
						new TrainingHouse("House 3", false, 0, 10),
						new TrainingHouse("House 4", false, 0, 10),
						new TrainingHouse("House 5", false, 0, 10)));

		List<TrainingHouse> houseListLevel5 = new ArrayList<TrainingHouse>(
				Arrays.asList(new TrainingHouse("House 1", false, 0, 10),
						new TrainingHouse("House 2", false, 0, 10),
						new TrainingHouse("House 3", false, 0, 10),
						new TrainingHouse("House 4", false, 0, 10),
						new TrainingHouse("House 5", false, 0, 10)));

		List<TrainingHouse> houseListLevel6 = new ArrayList<TrainingHouse>(
				Arrays.asList(new TrainingHouse("House 1", false, 0, 10),
						new TrainingHouse("House 2", false, 0, 10),
						new TrainingHouse("House 3", false, 0, 10),
						new TrainingHouse("House 4", false, 0, 10),
						new TrainingHouse("House 5", false, 0, 10)));

		TrainingLevel level1 = new TrainingLevel("Level 1", false, 50, 117,
				houseListLevel1);

		TrainingLevel level2 = new TrainingLevel("Fall", false, 50, 50,
				houseListLevel2);

		TrainingLevel level3 = new TrainingLevel("Level 3", false, 3, 50,
				houseListLevel3);

		TrainingLevel level4 = new TrainingLevel("Level 4", true, 0, 50,
				houseListLevel4);

		TrainingLevel level5 = new TrainingLevel("Level 5", true, 0, 50,
				houseListLevel5);

		TrainingLevel level6 = new TrainingLevel("Level 6", true, 0, 50,
				houseListLevel6);

		_levelList.add(level1);
		_levelList.add(level2);
		_levelList.add(level3);
		_levelList.add(level4);
		_levelList.add(level5);
		_levelList.add(level6);
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	}

	// -------------------------------------------------------------------------
	/**
	 * This method returns test data that has been initialized.
	 * 
	 * @return A list of instances of type TrainingLevel.
	 */
	public List<TrainingLevel> getTestLevels() {
		return _levelList;
	}

	// -------------------------------------------------------------------------
	public static User getInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = new User();
			return instance;
		}
	}

	// pasient listen
	public ArrayList<CasePatient> getCasePatientList() {

		return casePatientList;
	}

	public void setCasePatientList(ArrayList<CasePatient> patientList) {
		this.casePatientList = patientList;
	}

	// -------------------------------------------------------------------------
	/**
	 * Retrieves the name of the user that is currently logged in the
	 * application.
	 * 
	 * @return The name of the user that is currently logged in.
	 */
	public String getName() {
		if (ParseUser.getCurrentUser() == null) {
			return "No user";
		}
		return ParseUser.getCurrentUser().getUsername();
	}

	// -------------------------------------------------------------------------
	/**
	 * Retrieves a list of all the levels in the training part.
	 * 
	 * @return A list of the levels in the training part
	 */

	public List<TrainingLevel> getLevels(Context context)

	{
		int topLevel = 0;
		for (CasePatient caseP : casePatientList) {
			if (caseP.getLevel() > topLevel) {
				topLevel = caseP.getLevel();
			}
		}
		ArrayList<TrainingLevel> list = new ArrayList<TrainingLevel>();
		TrainingDAO dao = new TrainingDAO(context);
		dao.open();
		for (int i = 1; i <= topLevel; i++) {
			ArrayList<TrainingHouse> houses = new ArrayList<TrainingHouse>();
			TrainingLevel lv = new TrainingLevel("Level " + i,
					(getQuizLevel() < i), -1, dao.getNofQuizzes(i), houses);
			int levelScore = 0;
			for (CasePatient caseP : casePatientList) {
				if (caseP.getGender().equals("test")) {
					continue;
				}
				if (caseP.getLevel() == i) {
					CasePatientStatus cps = mapCasePatientStatus.get(caseP
							.getObjectId());
					if (cps == null) {
						if (dao.getPatientQuizzes(caseP) == null) {
							houses.add(new TrainingHouse(caseP.getName(),
									false, 0, 0));
						} else {
							houses.add(new TrainingHouse(caseP.getName(),
									false, 0, dao.getPatientQuizzes(caseP)
									.size()));
						}
					} else {
						levelScore += cps.getHighScore();
						houses.add(new TrainingHouse(caseP.getName(), cps
								.isComplete(), cps.getHighScore(), dao
								.getPatientQuizzes(caseP).size()));
					}
				}
			}
			lv.setUserScore(levelScore);
			list.add(lv);
		}
		dao.close();
		return list;
	}

	// -------------------------------------------------------------------------
	/**
	 * Function returns a TrainingLevel object specified by the position in the
	 * list of levels. This is based on testdata.
	 * 
	 * @param position
	 *            - The position in the list of levels.
	 * @return An object of type TrainingLevel or null if object in specified
	 *         position does not exist.
	 */
	public TrainingLevel getLevelNo(int position) {
		try {
			TrainingLevel level = _levelList.get(position);

			return level;
		} catch (IndexOutOfBoundsException exception) {
			return null;
		}
	}

	// -------------------------------------------------------------------------

	/**
	 * sets the correct level according to how many houses that is finished in a level
	 * fills empty houses with test to avoid error
	 * 
	 * @return
	 */
	public int getQuizLevel() {
		int counter = 0;

		// START TESTING
		for (int j = 0; j < 33; j++) {
			if (casePatientList.size() == j) {
				casePatientList.add(j, new CasePatient("null", "0", "test",
						"0", "0"));
			}

		}
		// END TESTING
		Log.v("Real patients: ", getAllPatients(getCurrentLevel()).size() + "");
		for (int i = 0 + (11 * (_level - 1)); i < (11 * _level); i++) {
			if (mapCasePatientStatus.get(casePatientList.get(i).getObjectId()) != null
					&& mapCasePatientStatus.get(
							casePatientList.get(i).getObjectId()).isComplete()) {
				counter++;

			}
		}
		if (counter >= (int) (getAllPatients(getCurrentLevel()).size() * 0.75)) {
			_level++;
			return getQuizLevel();
		} else {
			return _level;
		}
	}
	/**Sets the status of the house, if it is complete and how many point scored
	 * 
	 * @param housePoints questions answers
	 * @param complete booleans status housecomplete
	 * @param objectid the id of the quiz
	 */
	public void setHouseStatus(int housePoints, boolean complete,
			String objectid) {
		CasePatientStatus temp = null;
		if (mapCasePatientStatus.get(objectid) != null) {
			temp = mapCasePatientStatus.get(objectid);
			mapCasePatientStatus.remove(temp);
			temp.setHighScore(housePoints);
			temp.setComplete(complete);
			mapCasePatientStatus.put(objectid, temp);
		} else {
			mapCasePatientStatus.put(objectid, new CasePatientStatus(
					housePoints, complete));
		}
		Log.v("SyncContent", "Sync Training Progress");
		// SyncContent.saveTrainingProgress();
	}
	
	/** Method for getting the status of a house 
	 * 
	 * @param objectId the id of the house in question
	 * @return the current status of the house with objectid
	 */
	public CasePatientStatus getHouseStatus(String objectId) {
		if (mapCasePatientStatus.get(objectId) == null) {
			return new CasePatientStatus(0, false);
		} else {
			return mapCasePatientStatus.get(objectId);
		}
	}

	public void setExerciseCategory(ArrayList<ListItem> list) {
		this.exercises = list;
	}

	public ArrayList<ListItem> getExercises() {
		return exercises;
	}

	/**
	 * Method for getting all patients for the current level
	 * @param level the current level
	 * @return ArrayList with patient for the current level
	 */
	public ArrayList<CasePatient> getAllPatients(int level) {

		ArrayList<CasePatient> realPatients = new ArrayList<CasePatient>();
		for (int i = 0 + (11 * (_level - 1)); i < (11 * _level); i++) {

			if (casePatientList.get(i) != null
					&& !casePatientList.get(i).getGender().equals("test")) {
				realPatients.add(casePatientList.get(i));
			}
		}
		return realPatients;

	}

	public void setCurrentLevel(int level) {
		this.currentLevel = currentLevel;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}
}
