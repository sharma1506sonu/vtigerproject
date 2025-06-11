package com.comcast.crm.genericwebdriverutility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandomNmber() {
	Random random=new Random();
	int ranNum = random.nextInt(1000);
	return ranNum;
}

public String getSystemDate() {
	Date dateObj=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(dateObj);
	return date;
}
public String getRequiredDate(int days) {
	
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal =Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String endDate = sim.format(cal.getTime());
	return endDate;
}

}
