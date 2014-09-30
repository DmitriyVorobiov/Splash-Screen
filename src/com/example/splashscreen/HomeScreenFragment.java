package com.example.splashscreen;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeScreenFragment extends Fragment {
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    return inflater.inflate(R.layout.home_screen, null);     //  warning

	  }
	  
	  @Override
	  public void onStart() {
		    super.onStart();
	        ListView listView = (ListView) getActivity().findViewById(R.id.listView);
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
	            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.items));
	        listView.setAdapter(adapter);
	        
		  }
}
