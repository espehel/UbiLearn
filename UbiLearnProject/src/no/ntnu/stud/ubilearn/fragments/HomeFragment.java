package no.ntnu.stud.ubilearn.fragments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import no.ntnu.stud.ubilearn.R;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class HomeFragment extends Fragment
{
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState)
	{
		View fragmentView = inflater.inflate(
				R.layout.fragment_home, container, false);
		
		
		// TEST: Here we try to read from the userdata.txt file.
		// The .txt file could also have been implemented as
		// a .xml file, and we would then need to load the data differently.
		InputStream inputStream = 
				getResources().openRawResource(R.raw.userdata);
		InputStreamReader inputStreamReader =
				new InputStreamReader(inputStream);
		BufferedReader bufferedReader =
				new BufferedReader(inputStreamReader);
		
		
		String name 			= "";
		String status 			= "";
		String achievements 	= "";
		String unlockedCases 	= "";
		String lockedCases		= "";
		String caseData			= "";
		
		
		try
		{
			name 			= bufferedReader.readLine();
			status			= bufferedReader.readLine();
			achievements	= bufferedReader.readLine();
			unlockedCases	= bufferedReader.readLine();
			lockedCases		= bufferedReader.readLine();
			
			
			// We now need to load from 0 to many case data and dynamically
			// add them to the layout file.
			// Here we check to see if we have stored points for different
			// cases in userdata.txt and if so we dynamically add these
			// scores to the fragment_home.xml. If the score is good enough
			// we could replace the score with a medallion.
			
			// Read a line to see if we have data for a case
			caseData = bufferedReader.readLine();
			
			// TODO: Unfinished. Add data dynamically...
			// This is for testing purposes. Perhaps doing it this way will
			// slow the application and we need to change it???
			while(caseData != null)
			{
				// A line should consist of two numbers. The first to indicate
				// what the user has achieved and the second the maximum score
				// for the specific case. (Actually all case data should decide
				// what 'Status' the user has).
				String[] splitStr 	= caseData.split("/");
					
				caseData			= bufferedReader.readLine();
			}
		}
		catch(IOException exception)
		{
			// TODO: Replace with a dialog box and handle the error better.
			System.out.println("Problems reading text file!");
		}
		
		
		// We set the different TextViews in fragment_home.xml based on the
		// values read from file
		TextView userName = 
				(TextView)fragmentView.findViewById(R.id.homeUserName);
		userName.setText(name);
		
		TextView userStatus = 
				(TextView)fragmentView.findViewById(R.id.homeStatus);
		userStatus.setText(status);
		
		TextView userAchievement = 
				(TextView)fragmentView.findViewById(R.id.homeAchievement);
		userAchievement.setText(achievements);
		
		TextView userUnlockedCases =
				(TextView)fragmentView.findViewById(R.id.homeUnlockedCases);
		userUnlockedCases.setText(unlockedCases);
		
		TextView userLockedCases =
				(TextView)fragmentView.findViewById(R.id.homeLockedCases);
		userLockedCases.setText(lockedCases);
		
		/*
		// Here we set the different TextViews in fragment_home.xml based on
		// hardcoded values. Should be replaced with values read from file
		// but we keep it in case of errors reading from file.
		TextView userName = 
				(TextView)fragmentView.findViewById(R.id.homeUserName);
		userName.setText("Ola Nordman");
		
		TextView userStatus = 
				(TextView)fragmentView.findViewById(R.id.homeStatus);
		userStatus.setText("Nybegynner");
		
		TextView userAchievement = 
				(TextView)fragmentView.findViewById(R.id.homeAchievement);
		userAchievement.setText("Ingen");
		
		TextView userUnlockedCases =
				(TextView)fragmentView.findViewById(R.id.homeUnlockedCases);
		userUnlockedCases.setText("3");
		
		TextView userLockedCases =
				(TextView)fragmentView.findViewById(R.id.homeLockedCases);
		userLockedCases.setText("27");		
		*/
		
		
		// We need to handle button clicks from the fragment_home.xml file. If
		// the user clicks 'Oppl�ring' or 'Praksis' we should replace this
		// fragment with the chosen one.
		Button trainingButton = 
				(Button)fragmentView.findViewById(R.id.homeButtonTraining);
		
		
		trainingButton.setOnClickListener(new OnClickListener()
		{
			public void onClick(View view)
			{
				Fragment fragment = new Training();
				getFragmentManager().beginTransaction().
				replace(R.id.content_frame, fragment).
				/*addToBackStack("Home").*/commit();
			}
		} );
		
		
		Button practiseButton = 
				(Button)fragmentView.findViewById(R.id.homeButtonPractise);
		
		
		practiseButton.setOnClickListener(new OnClickListener()
		{
			public void onClick(View view)
			{
				Fragment fragment = new Practise();
				getFragmentManager().beginTransaction().
				replace(R.id.content_frame, fragment).
				/*addToBackStack("Home").*/commit();
			}
		} );
				
		
		return fragmentView;
		//return inflater.inflate(R.layout.fragment_home, container, false);
	}
}
