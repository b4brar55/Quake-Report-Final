package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {
	  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
		  ArrayList<Earthquake> earthquakes = new ArrayList<>();
		  earthquakes.add(new Earthquake("7.2","San Francisco", "2 feb 2016"));
		  earthquakes.add(new Earthquake("3.2","London","18 aug 1955"));
		  earthquakes.add(new Earthquake("5.1","Tokyo","23 march 1931"));
		  earthquakes.add(new Earthquake("7.4","Mexico City","4 june 1944"));
		  earthquakes.add(new Earthquake("6.6","Moscow","1 april 1945"));
		  earthquakes.add(new Earthquake("3.5","Rio de Janeiro","1june 2000"));
		  earthquakes.add(new Earthquake("8.2","Paris","june 1984"));

		  // Find a reference to the {@link ListView} in the layout
		  ListView earthquakeListView = (ListView) findViewById(R.id.list);

		  // Create a new {@link ArrayAdapter} of earthquakes
		  EarthquakeAdapater adapter = new EarthquakeAdapater(this, earthquakes);

		  // Set the adapter on the {@link ListView}
		  // so the list can be populated in the user interface
		  earthquakeListView.setAdapter(adapter);
    }
}
