package com.example.android.quakereport;

import android.content.Context;

import android.graphics.drawable.GradientDrawable;

import android.icu.text.SimpleDateFormat;

import android.support.v4.content.ContextCompat;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.text.DecimalFormat;

import java.util.Date;

import java.util.List;

public class EarthquakeAdapater extends ArrayAdapter<Earthquake> {

	  public EarthquakeAdapater(Context context, List<Earthquake>earthquakes) {			super(context, 0, earthquakes);

	  }

	  private static final String LOCATION_SEPRATE = " of ";

	  @Override

	  public View getView(int position, View convertView, ViewGroup parent) {

			View listItemView = convertView;

			if (listItemView == null) 

			{

				  listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);

			}

			Earthquake currentEarthquake = getItem(position);

			

			//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

			//String formatMagnitude var ha jis-vich formatMagnitude Function pass hoi jnda

			String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());

			

			TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);

			magnitudeView.setText(formattedMagnitude);

			

			//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

			//eh v lec 161 ch code kita

			GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

			// Get the appropriate background color based on the current earthquake magnitude

			int magnitudecolor = getMagnitudeColor(currentEarthquake.getMagnitude());

			// Set the color on the magnitude circle

			magnitudeCircle.setColor(magnitudecolor);

			

			//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

			//eh lec 157 vich hai

			//hun apa ek variable de vich location lae ke usnu

			//split krage

		    String originalLocation = currentEarthquake.getLocation();

			//hun 2 variable de vich split hoe value nu store krage

			String primaryLocation;

			String locationOffset;

			// hun apa [of] nu seprater laeke string split krage

			if(originalLocation.contains(LOCATION_SEPRATE)){

				  String[] parts = originalLocation.split(LOCATION_SEPRATE);

				  locationOffset = parts[0];

				 primaryLocation = parts[1];

			}else{

				  locationOffset = getContext().getString(R.string.near_the);

				  primaryLocation = originalLocation;

			}

			TextView locationPrimaryView = (TextView) listItemView.findViewById(R.id.location_primary);

			locationPrimaryView.setText(primaryLocation);

			TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);

			locationOffsetView.setText(locationOffset);

			//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

			

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

	  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	  // eh lec 159 vich code hoea c

	  private String formatMagnitude(double magnitude){

			DecimalFormat magnitudeFormat = new DecimalFormat("0.0");

			return magnitudeFormat.format(magnitude);

	  }

	  //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	  

	  private String formatDate(Date dateObject){

			SimpleDateFormat dateFormat = new SimpleDateFormat( "LLL dd, yyyy");

			return dateFormat.format(dateObject);

	  }

	  public String formatTime(Date dateObject){

			SimpleDateFormat timeFormat = new SimpleDateFormat( "h: mm a");

			return timeFormat.format(dateObject);

	  }

	  // eh lec 161 ch code kita

	  private int getMagnitudeColor(double magnitude)

	  {

			int magnitudeColorResourceId;

			int magnitudeFloor = (int) Math.floor(magnitude);

			switch (magnitudeFloor)

			{

				  case 0:

				  case 1:

						magnitudeColorResourceId = R.color.magnitude1;

						break;

				  case 2:

						magnitudeColorResourceId = R.color.magnitude2;

						break;

				  case 3:

						magnitudeColorResourceId = R.color.magnitude3;

						break;

				  case 4:

						magnitudeColorResourceId = R.color.magnitude4;

						break;

				  case 5:

						magnitudeColorResourceId = R.color.magnitude5;

						break;

				  case 6:

						magnitudeColorResourceId = R.color.magnitude6;

						break;

				  case 7:

						magnitudeColorResourceId = R.color.magnitude7;

						break;

				  case 8:

						magnitudeColorResourceId = R.color.magnitude8;

						break;

				  case 9:

						magnitudeColorResourceId = R.color.magnitude9;

						break;

				  default:

						magnitudeColorResourceId = R.color.magnitude10plus;

						break;

			}

			return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

	  }

}
