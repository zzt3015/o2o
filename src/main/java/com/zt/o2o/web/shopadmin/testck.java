package com.zt.o2o.web.shopadmin;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testck {
   
	
	
	public static void main(String[] args) {
		String ksrq = "2018-01-09";
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition p = new ParsePosition(0);
		Date ksrq_date = sdf.parse(ksrq, p);
		Calendar cc = Calendar.getInstance();
//		cc.setTime(ksrq_date);
	    System.out.println(ksrq_date);
	}
}
