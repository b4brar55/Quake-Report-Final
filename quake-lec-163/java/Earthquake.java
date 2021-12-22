package com.example.android.quakereport;

public class Earthquake {

	  private Double mMagnitude;	  private String mLocation;

	 // private String mDate;

	 private String mUrl;

	  private long mTimeInMilisecond;

	  public Earthquake(Double magnitude, String location, long timeInMilisecond, String url) {

			mMagnitude = magnitude;

			mLocation = location;

			//mDate = date; //apa es nu lec comment kita c bcz,

			//apa ek hi le lea c time & date

			// ta karke 

			mTimeInMilisecond = timeInMilisecond;

			mUrl = url;

	  }

	  public Double getMagnitude() {

			return mMagnitude;

	  }

	  public String getLocation() {

			return mLocation;

	  }

	  

	 /*lec 163 ch comment 

	 eh comment kita c bcoz apa already timeInMilisecond

	 da method bna lea jo date & time dsda

	 public String getDate() {

			return mDate;

	  }*/

	  public long getTimeInMilisecond(){

			return mTimeInMilisecond;

	  }

	  public String getUrl(){

			return mUrl;

	  }

}
