package no.ntnu.stud.ubilearn.fragments;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import models.Patient;
import no.ntnu.stud.ubilearn.R;
import no.ntnu.stud.ubilearn.R.drawable;
import no.ntnu.stud.ubilearn.R.id;
import no.ntnu.stud.ubilearn.R.layout;
import android.os.Bundle;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;




import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;






public class Training extends Fragment {
	private RelativeLayout rl;
	private ScrollView sv;
	private View root;
//	private static final String jsonFilePath = "assets/pasient_info.json";

	ArrayList<Patient> patientList;
	int i;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle b){
		root = inflater.inflate(R.layout.fragment_training, null);
		sv = (ScrollView) root.findViewById(R.id.training_scroll);
		rl = (RelativeLayout) root.findViewById(R.id.training_rel);
		patientList = new ArrayList<Patient>();
		generatePatients();

		sv.post(new Runnable() {            
			@Override
			public void run() {
				// sv.fullScroll(View.FOCUS_DOWN); 
				sv.scrollTo(0, sv.getBottom()*2);
			}
		});


		return root;
	}



	public void houseClick(View v){
		final View house = v;
		final Dialog dialog = new Dialog(getActivity());
		dialog.setContentView(R.layout.training_popup);
		if(house.getContentDescription().toString().length() > 0 ){
			i = Integer.parseInt(house.getContentDescription().toString());
		}

		Button cancel = (Button) dialog.findViewById(R.id.training_popup_cancel);

		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		Button enter = (Button) dialog.findViewById(R.id.training_popup_enter);

		enter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View vi) {
				Bundle data = new Bundle();
				
				if(i>=0){
				data.putString("name", patientList.get(i).getName());
				data.putString("age", patientList.get(i).getAge());
				data.putString("gender", patientList.get(i).getGender());
				data.putString("info", patientList.get(i).getInfo());
				data.putString("level", patientList.get(i).getLevel());
				}
				Fragment patient = new PatientCaseFragment();
				patient.setArguments(data);

				getFragmentManager().beginTransaction().replace(R.id.content_frame, patient).addToBackStack("training").commit();
				dialog.dismiss();
			}
		});

		dialog.setTitle(patientList.get(i).getName() + " sitt hus");
		dialog.show();
	}

	private void generatePatients(){
		String json = null;
		try {
			InputStream is = getActivity().getAssets().open("pasient_info.json");
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			
			json = new String(buffer, "UTF-8");
			
		} catch (IOException ie) {
			Log.e("ERROR I/O", "error reading patients file");
		}
		try {
			JSONObject jsonObj = new JSONObject(json);
			JSONArray patientArray = jsonObj.getJSONArray("pasienter");
			
			for (int i = 0; i < patientArray.length(); i++) {
				JSONObject patientObj = (JSONObject) patientArray.get(i);
				patientList.add(new Patient
						(patientObj.getString("name"), 
						 patientObj.getString("age"), 
						 patientObj.getString("gender"), 
						 patientObj.getString("info"), 
						 patientObj.getString("level")));
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e("ERROR JSON", "error parsing json");
		}
	}

}
