package no.ntnu.stud.ubilearn.fragments;

import no.ntnu.stud.ubilearn.R;
import no.ntnu.stud.ubilearn.models.Patient;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class PatientCaseFragment extends Fragment{
	
	private String _name, _age, _gender, _pasientInfo;
	private int _level;
	private Patient patient;
	
	//Empty constructor for validFragment
	public PatientCaseFragment() {
		
	}
	
	public PatientCaseFragment(Patient patient) {
		this.patient = patient;
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		_name = patient.getName();
		_age = patient.getAge();
		_gender = patient.getGender();
		_pasientInfo = patient.getInfo();
		_level = Integer.parseInt(patient.getLevel());
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView = inflater.inflate(R.layout.training_case, container, false);
		
		TextView name = (TextView) rootView.findViewById(R.id.case_PatientName);
		name.setText(_name);
		TextView age = (TextView) rootView.findViewById(R.id.case_patientAge);
		age.setText("Alder: " + _age);
		TextView gender = (TextView) rootView.findViewById(R.id.case_patientGender);
		gender.setText("Kjønn: " + _gender);
		TextView pasientInfo = (TextView) rootView.findViewById(R.id.case_patientInfoField);
		pasientInfo.setText(_pasientInfo);
		RatingBar level = (RatingBar)rootView.findViewById(R.id.training_ratingBar);
		level.setRating(_level);
		Button next = (Button)rootView.findViewById(R.id.training_case_next);
		
		next.setOnClickListener(new OnClickListener() {//neste knapp til Quiz fra pasientCase
			
			@Override
			public void onClick(View v) {

				//TODO: remove line
				Log.v("Navnet til pasientet", "er: " + patient.getName());
				Fragment fragment = new QuizFragment(patient);
				getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("quiz").commit();

			}
		});
		//tilbake knapp fra pasientcase
		Button back = (Button)rootView.findViewById(R.id.training_case_back);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getFragmentManager().popBackStack();
			}
		});
		
		return rootView;
	}
	
}
