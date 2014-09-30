package com.example.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

// format all
// do with activity, use saveInstanceState

public class MainActivity extends Activity {

	static String TAG = "mylog";
	private final Handler handler = new Handler();
	private final long SPLASH_TIME = 6000;
	private String ELAPSED_TIME = "elapsedTime";
	private long pastTime;
	private long startTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		Log.d(TAG, "MainActivity: onCreate()");

		startTime = System.currentTimeMillis();
		if (savedInstanceState == null) {
			pastTime = 0;
			handler.postDelayed(confirmChange, SPLASH_TIME);

		} else {
			pastTime = savedInstanceState.getLong(ELAPSED_TIME);
			Log.d(TAG, String.valueOf(pastTime));
			if (pastTime < SPLASH_TIME) {
				handler.postDelayed(confirmChange, SPLASH_TIME - pastTime);
			} else
				handler.post(confirmChange);
		}
	}

	Runnable confirmChange = new Runnable() {
		@Override
		public void run() {
			changeActivity();
		}
	};

	private void changeActivity() {
		handler.removeCallbacks(confirmChange);
		Intent intent = new Intent(this, HomeScreenActivity.class);
		startActivity(intent);
		//finish();
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putLong(ELAPSED_TIME, System.currentTimeMillis() - startTime
				+ pastTime);

	}


	@Override
	protected void onDestroy() {
		handler.removeCallbacks(confirmChange);
		super.onDestroy();
	}

//	@Override
//	protected void onStop() {
//		super.onStop();
//		if (!isChangingConfigurations()) {
//			isChangingOrientation = false;
//		}
//	}

//	@Override
//	protected void onResume() {
//		super.onResume();
//		if (isChangingOrientation) {
//			handler.postDelayed(confirmChange, 0);
//		}
//	}

}
