package com.mhb.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishServiceImpl implements WishService {

	@Override
	public String generateWishMessage() {
		Calendar calendar=null;
		int hour=0;
		//get Date and Time
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		if(hour<=12)
	    	return "Good Morning";
		else if(hour<=16)
			return "Good AfterNoon";
		else if(hour<=20)
			return "Good Evening ";
		else
			return "Good Night ";
	}//method
}//class
