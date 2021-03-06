package no.ntnu.stud.ubilearn.fragments.practise;

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

/**
 * class for the practice fragment
 * @author ingeborgoftedal
 *
 */
@SuppressLint("ValidFragment")
public class PracticeSPPBFragment extends Fragment {
	
	Patient patient;
	
	/**
	 * constructor
	 * @param object of the type Patient
	 */
	public PracticeSPPBFragment(Patient patient){
		this.patient = patient;
	}
	
	/**
	 * creates a new view, defines the onClickListeners who redirects to the three tests
	 */
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		
		View view =  inflater.inflate(R.layout.fragment_practice_sppb, container, false);
		
		Button enterGangtest = (Button) view.findViewById(R.id.gangtest_button);
		
		/**
		 * clicklistener to navigate to the gangtest
		 */
		enterGangtest.setOnClickListener(new OnClickListener()
		{
			public void onClick(View vi)
			{
				Fragment fragment = new PracticeSPPBWalkingFragment(patient);
				getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("practise").commit();
			}
		});

		
		/**
		 * clicklistener to navigate to the balance test
		 */
		Button balance = (Button) view.findViewById(R.id.balance_button);

		balance.setOnClickListener(new OnClickListener()
		{
			public void onClick(View vi)
			{
				Fragment fragment = new PractiseBalanceFragment(patient);
				getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("practise").commit();
			}
		});
		
		/**
		 * clicklistener to navigate to the stand up test
		 */
		Button standup = (Button) view.findViewById(R.id.standup_button);

		standup.setOnClickListener(new OnClickListener()
		{
			public void onClick(View vi)
			{
				Fragment fragment = new PractiseStandupFragment(patient);
				getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("practise").commit();
			}
		});

		return view;
	}
}


