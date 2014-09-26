package com.example.splashscreen;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SplashScreenFragment extends Fragment {

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.splash_screen, null);
	  }
	  
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		  }
	  @Override
	  public void onStart() {
		    super.onStart();
		    // create handler here
		    changeFragment();
		  }
	  
	  private void changeFragment() {
		  HomeScreenFragment homeScreen = new HomeScreenFragment();
		  getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, homeScreen).commit();
	  }
}

