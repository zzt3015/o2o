package com.zt.o2o.web.shopadmin;

import java.util.regex.Pattern;

public class testzz {

	
	public static void main(String[] args) {
		String method = "^[1][3|4|5|7|8][0-9]{9}$";
//		Pattern p = Pattern.compile(method);
		
		System.out.println("19920006205".matches(method));
	}
}
