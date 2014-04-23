package no.ntnu.stud.ubilearn.fragments;

import java.util.ArrayList;

import no.ntnu.stud.ubilearn.R;
import no.ntnu.stud.ubilearn.models.Patient;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class PractisePatientsFragment extends Fragment 
{
	
	//UI
	private TextView patientName;
	private EditText patientNameEdit;
	private TextView patientAge;
	private EditText patientAgeEdit;
	private TextView patientProblems;
	private EditText patientProblemsEdit;
	private TextView patientOther;
	private EditText patientOtherEdit;
	private TextView SPPBresult;
	private ImageView editInfo;
	Patient patient;
	public PractisePatientsFragment(Patient patient){
		this.patient = patient;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		
		View rootView = inflater.inflate(R.layout.fragment_practise_patient, container, false);

		patientName = (TextView)rootView.findViewById(R.id.practise_patient_name);
		
		patientNameEdit = (EditText)rootView.findViewById(R.id.practise_patient_name_edit);

		patientAge = (TextView)rootView.findViewById(R.id.practice_patient_age);
		patientAge.setText("Alder: ");
		
		patientAgeEdit = (EditText)rootView.findViewById(R.id.practise_patient_age_edit);
		

		patientProblems = (TextView)rootView.findViewById(R.id.practice_patient_problems);
		patientProblems.setText("Problemområder: ");
		patientProblemsEdit = patientNameEdit = (EditText)rootView.findViewById(R.id.practice_patient_problems_edit);

		patientOther = (TextView)rootView.findViewById(R.id.practice_patient_other);
		patientOther.setText("Kommentar: ");
		patientOtherEdit = (EditText)rootView.findViewById(R.id.practice_patient_other_edit);
		setEnabled(false);
		
		editInfo = (ImageView)rootView.findViewById(R.id.edit_info_button);
		
		Button enterSPPB = (Button)rootView.findViewById(R.id.practice_SPPB_button);
		
		enterSPPB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment fragment = new PracticeSPPBFragment(patient);

				Bundle data = new Bundle();

				getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("training").commit();
				
			}
		});
		
		editInfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setEnabled(true);
				
			}
		});
		
		return rootView;

	}
	private void setEnabled(boolean b){
		int v;
//		if(b){
//			v = 0x00000000;
//		}
//		else{
//			v = 0x00000004;	
//			}
	//	patientNameEdit.setVisibility(v);
		patientNameEdit.setEnabled(b);
		patientNameEdit.setText(patient.getName());
		patientNameEdit.setText(patient.getName());
//		patientAgeEdit.setVisibility(v);
		patientAgeEdit.setEnabled(b);
		patientAgeEdit.setText(patient.getAge());
//		patientProblemsEdit.setVisibility(v);
		patientProblemsEdit.setEnabled(b);
		patientProblemsEdit.setText(patient.getProblems());
//		patientOtherEdit.setVisibility(v);
		patientOtherEdit.setEnabled(b);
		patientOtherEdit.setText(patient.getComment());
		}
	}

