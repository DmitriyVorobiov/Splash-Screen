package com.example.splashscreen;
import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

	SplashScreenFragment splashScreen;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        

        if (savedInstanceState == null){
        splashScreen = new SplashScreenFragment();
        getFragmentManager().beginTransaction().add(R.id.fragmentContainer, splashScreen).commit();
        }
    }
}
