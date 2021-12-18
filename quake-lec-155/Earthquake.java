package com.example.android.quakereport;

public class Earthquake {
	  private String mMagnitude;
	  private String mLocation;
	  private String mDate;
	  private long mTimeInMilisecond;
	  public Earthquake(String magnitude, String location, long timeInMilisecond) {
			mMagnitude = magnitude;
			mLocation = location;
			//mDate = date; //apa es nu lec comment kita c bcz,
			//apa ek hi le lea c time & date
			// ta karke 
			mTimeInMilisecond = timeInMilisecond;
	  }
	  public String getMagnitude() {
			return mMagnitude;
	  }

	  public String getLocation() {
			return mLocation;
	  }
	  public String getDate() {
			return mDate;
	  }
	  public long getTimeInMilisecond(){
			return mTimeInMilisecond;
	  }
}
