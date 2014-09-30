package com.example.splashscreen;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SplashScreenFragment extends Fragment {

	private final Handler handler = new Handler();
	private boolean rolled = false;                       // bad name, dont use it
	private HomeScreenFragment homeScreen;
	private int id = 42;
	
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.splash_screen, null);        // correct warnings
	  }
	  
	  public void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setRetainInstance(true); 	
		    handler.postDelayed(confirmChange, 4000);
		  }
	  
	  Runnable confirmChange = new Runnable() {		
		@Override
		public void run() {
			if (!rolled) changeFragment();		
		}
	  };
	  
	  public void onResume() {		  
		    super.onResume();
		    if (rolled) {   
			    handler.postDelayed(confirmChange, 4000);
		    }
		    rolled = false;
		  }
	  
	  public void onStop() {                                   // dont use those cicles
		    super.onStop();
		    if (!getActivity().hasWindowFocus()) {            // dont use it
	    		rolled = true;
	    	}
		  }
	  
	  public void onDestroy() {
		    handler.removeCallbacks(confirmChange);
		    super.onDestroy();
		  }		  
	  
	  
	  private void changeFragment() {
		  homeScreen = new HomeScreenFragment();
		  try {
		  getFragmentManager().beginTransaction().replace(id, homeScreen).commit();
		  }
		  catch (Exception e) {                  // nulls are not allowed
			  e.printStackTrace();             // do something
		  }
	  }
}

