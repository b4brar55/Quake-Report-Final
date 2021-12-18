package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.Date;
import java.util.List;
import android.icu.text.SimpleDateFormat;
import android.text.format.DateFormat;

public class EarthquakeAdapater extends ArrayAdapter<Earthquake> {
	  public EarthquakeAdapater(Context context, List<Earthquake>earthquakes) {
			super(context, 0, earthquakes);
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
			View listItemView = convertView;
			if (listItemView == null) 
			{
				  listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
			}
			Earthquake currentEarthquake = getItem(position);
			
			TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
			magnitudeView.setText(currentEarthquake.getMagnitude());
			
			TextView locationView = (TextView) listItemView.findViewById(R.id.location);
			locationView.setText(currentEarthquake.getLocation());
			
			//TextView dateView = (TextView) listItemView.findViewById(R.id.date);
			//dateView.setText(currentEarthquake.getDate());
			Date dateObject = new Date(currentEarthquake.getTimeInMilisecond());
			TextView dateView = (TextView) listItemView.findViewById(R.id.date);
			// Format the date string (i.e. "Mar 3, 1984")
			String formattedDate = formatDate(dateObject);
			// Display the date of the current earthquake in that TextView
			dateView.setText(formattedDate);

			TextView timeView = (TextView) listItemView.findViewById(R.id.time);
			// Format the time string (i.e. "4:30PM")
			String formattedTime = formatTime(dateObject);
			// Display the time of the current earthquake in that TextView
			timeView.setText(formattedTime);
			
			//String fomattedDate = new formatDate(dateObject);
			//String formattedTime = new formatTime(dateObject);
			
			return listItemView;
			
	  }
	  
	  private String formatDate(Date dateObject){
			SimpleDateFormat dateFormat = new SimpleDateFormat( "LLL dd, yyyy");
			return dateFormat.format(dateObject);
	  }
	  public String formatTime(Date dateObject){
			SimpleDateFormat timeFormat = new SimpleDateFormat( "h: mm a");
			return timeFormat.format(dateObject);
	  }
}
