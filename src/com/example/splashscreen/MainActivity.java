package com.example.splashscreen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {

	SplashScreenFragment splashScreen;
	private final String LOG_TAG = "MainActivity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "created");
        

        splashScreen = new SplashScreenFragment();
        getFragmentManager().beginTransaction().add(R.id.fragmentContainer, splashScreen).commit();
    }
}
