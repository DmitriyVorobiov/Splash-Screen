package com.example.splashscreen;
import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;



     // format all
// do with activity, use saveInstanceState

public class MainActivity extends Activity {

	SplashScreenFragment splashScreen;                    // need identifs
	  private FrameLayout container;
	  private int id;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
	    container = new FrameLayout(this);	    // create xml
	    id = 42;                                    // save constants
	    container.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
	    container.setId(id);
	    setContentView(container);
	    
        if (savedInstanceState == null){
        splashScreen = new SplashScreenFragment();
        getFragmentManager().beginTransaction().add(id, splashScreen).commit();
        }
    }
}
