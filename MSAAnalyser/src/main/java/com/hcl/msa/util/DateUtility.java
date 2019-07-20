package com.hcl.msa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDate = formatter.format(date);
		System.out.println("Date Format with dd-M-yyyy hh:mm:ss : " + strDate);
		return strDate;
	}

}
