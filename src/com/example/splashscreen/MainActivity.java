package com.example.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends Activity {

	private final String LOG_TAG = MainActivity.class.getName();
	private final Handler handler = new Handler();
	private final long SPLASH_TIME = 4000;
	private final String ELAPSED_TIME = "elapsedTime";
	private long pastTime;
	private long startTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		startTime = System.currentTimeMillis();
		if (savedInstanceState == null) {
			pastTime = 0;
			handler.postDelayed(changeRunnable, SPLASH_TIME);

		} else {
			pastTime = savedInstanceState.getLong(ELAPSED_TIME);
			if (pastTime < SPLASH_TIME) {
				handler.postDelayed(changeRunnable, SPLASH_TIME - pastTime);
			} else
				handler.post(changeRunnable);
		}
	}

	Runnable changeRunnable = new Runnable() {
		@Override
		public void run() {
			changeActivity();
		}
	};

	private void changeActivity() {
		Intent intent = new Intent(this, HomeScreenActivity.class);
		startActivity(intent);
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putLong(ELAPSED_TIME, System.currentTimeMillis() - startTime
				+ pastTime);

	}

	// used android:noHistory="true" to disable splash screen
	@Override
	protected void onDestroy() {
		handler.removeCallbacks(changeRunnable);
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (!isChangingConfigurations()) {
			Log.d(LOG_TAG, "application is hidden");
			// remove callback to disable HomeScreen appearance, if application
			// is hidden
			handler.removeCallbacks(changeRunnable);
		}
	}

}
