package no.ntnu.stud.ubilearn.patientcase;

import java.util.ArrayList;
import java.util.Collections;

import no.ntnu.stud.ubilearn.User;


import android.util.Log;

public class Quiz {
	private String question;
	private ArrayList<String> answers; //answers[3] er riktig svar
	private String correct;
	private long id;
	private String objectId;
	/**
	 * the the same as the id of a patient
	 */
	private long ownerId;
	
	public Quiz(String qstn, String ans1, String ans2, String ans3, String correct){
		this.question = qstn;
		this.answers = new ArrayList<String>();
		this.answers.add(ans1);
		this.answers.add(ans2);
		this.answers.add(ans3);
		this.answers.add(correct);
		this.correct = correct;//riktig svar
	}
	
	
	
	public String[] getAlternatives(){
		
		ArrayList<String> shuff = answers;
		Collections.shuffle(shuff);
		
		String[] result = new String[shuff.size()];
		result = shuff.toArray(result);
		
		return result;
	}

	
	public String getQuestion(){
		return this.question;
	}
	
	public boolean checkAnswer(String ans){
		Log.v("ans", ans);
		if(this.correct.equals(ans)){
			//Log.v("ans på plass 3", answers.get(3));
			User.getInstance().addPoints();
			System.out.println("antall poeng: "+ User.getInstance().getPoints());
			return true;
		}
		return false;
	}
	
}
