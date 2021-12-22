package com.example.android.quakereport;

public class Earthquake {

	  private Double mMagnitude;	  private String mLocation;

	  private String mDate;

	  private long mTimeInMilisecond;

	  public Earthquake(Double magnitude, String location, long timeInMilisecond) {

			mMagnitude = magnitude;

			mLocation = location;

			//mDate = date; //apa es nu lec comment kita c bcz,

			//apa ek hi le lea c time & date

			// ta karke 

			mTimeInMilisecond = timeInMilisecond;

	  }

	  public Double getMagnitude() {

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
