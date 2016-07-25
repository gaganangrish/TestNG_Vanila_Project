package com.Main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TempCode {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		String currentmonth = new SimpleDateFormat("MMMM").format(cal.getTime());
		System.out.println(currentmonth);

	}

}
