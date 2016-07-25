package com.TempCode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cucumber.api.java.lu.a;

public class TempClass {

	public static void main(String[] args) throws ParseException {

		/*
		 * // Date beginupd = new Date(); Calendar cal = Calendar.getInstance();
		 * // cal.setTime(beginupd); long millis = cal.getTimeInMillis();
		 * System.out.println(cal); System.out.println(millis);
		 */

		// Calendar date = new GregorianCalendar();
		// date.set(Calendar.HOUR_OF_DAY, 0);
		// date.set(Calendar.MINUTE, 0);
		// date.set(Calendar.SECOND, 0);
		// date.set(Calendar.MILLISECOND, 0);
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// String dateString = sdf.format(date.getTime());
		// System.out.println(dateString);
		//
		// dateString = "7/7/2016 00:00:00";
		// SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// Date date1 = sdf1.parse(dateString);
		// long milliSecs = date1.getTime();
		// String stringMillinS = String.valueOf(milliSecs);
		//
		// System.out.println(stringMillinS);

		 String input_date="8/1/16";
		 SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		 Date dt1=format1.parse(input_date);
		 DateFormat format2=new SimpleDateFormat("M");
		 String finalMonth=format2.format(dt1);
		 System.out.println(finalMonth);
		 int month = Integer.parseInt(finalMonth);
		 System.out.println(month);
		 
		 java.util.Date date= new Date();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 int currentMonth = cal.get(Calendar.MONTH);
		 System.out.println(currentMonth+1);
		 
//		 char[] chararry = finalYear.toCharArray();
//		 if (String.valueOf(chararry[0]).equalsIgnoreCase("0")) {
//			 finalYear = finalYear.replaceFirst(".", "2");
//		}

		 

//		String input_date = "18/01/2016";
//		String[] arr = input_date.split("/");
//		char[] charArry = arr[0].toCharArray();
//		if (charArry.length < 2) {
//			arr[0] = "0" + arr[0];
//		}
//		System.out.println(arr[0]);
		 
//			String airportCode = "MEL";
//			String airportName=null;
//			String[] airportCodesArr = { "ADL", "BNK", "BNE", "CNS", "CBR", "DRW", "OOL", "HTI", "HIS", "HBA", "LST", "MKY",
//					"AVV", "MEL", "NTL", "PER", "MCY", "SYD", "TSV", "AYQ", "PPP", "PNH", "REP", "KWE", "HAK", "HGH", "SYX",
//					"HGH", "SWA", "WUH", "NAN", "HKG", "DPS", "CGK", "LOP", "KNO", "PLM", "PKU", "SUB", "FUK", "KOJ", "KMJ",
//					"MYJ", "NGO", "OIT", "OKA", "KIX", "CTS", "TAK", "NRT", "MFM", "KUL", "PEN", "RGN", "AKL", "CHC", "DUD",
//					"NPE", "NSN", "NPL", "PMR", "ZQN", "WLG", "MNL", "SIN", "TPE", "BKK", "HKT", "HNL", "BMV", "VCL", "DLI",
//					"DAD", "VDH", "HPH", "HAN", "SGN", "HUI", "CXR", "PQC", "UIH", "THD", "TBB", "VII" };
//			
//			String[] airportNamesArr = { "Adelaide", "Ballina Byron", "Brisbane", "Cairns", "Canberra", "Darwin",
//					"Gold Coast", "Hamilton Island", "Hayman Island", "Hobart", "Launceston", "Mackay",
//					"Melbourne (Avalon)", "Melbourne (Tullamarine)", "Newcastle – Port Stephens", "Perth", "Sunshine Coast",
//					"Sydney", "Townsville", "Uluru (Ayers Rock)", "Whitsunday Coast", "Phnom Penh", "Siem Reap", "Guiyang",
//					"Haikou", "Hangzhou", "Sanya", "Shanghai", "Shantou / Jieyang", "Wuhan", "Nadi", "Hong Kong",
//					"Bali (Denpasar)", "Jakarta", "Lombok", "Medan - Kualanamu", "Palembang", "Pekanbaru", "Surabaya",
//					"Fukuoka", "Kagoshima", "Kumamoto", "Matsuyama", "Nagoya (Chubu)", "Oita", "Okinawa (Naha)", "Osaka",
//					"Sapporo", "Takamatsu", "Tokyo (Narita)", "Macau", "Kuala Lumpur", "Penang", "Yangon", "Auckland",
//					"Christchurch", "Dunedin", "Napier", "Nelson", "New Plymouth", "Palmerston North", "Queenstown",
//					"Wellington", "Manila", "Singapore", "Taipei", "Bangkok", "Phuket", "Honolulu", "Buon Ma Thuot",
//					"Chu Lai", "Da Lat", "Da Nang", "Dong Hoi", "Hai Phong", "Hanoi", "Ho Chi Minh City", "Hue",
//					"Nha Trang", "Phu Quoc", "Quy Nhon", "Thanh Hoa", "Tuy Hoa", "Vinh" };
//			
//			if (airportCode.equalsIgnoreCase("Tul")) {
//				airportName="Melbourne (Tullamarine)";
//			} else {
//				for (int i = 0; i < airportCodesArr.length; i++) {
//					if (airportCodesArr[i].equalsIgnoreCase(airportCode)) {
//						airportName=airportNamesArr[i];
//					}
//				}
//			}
//			
//			System.out.println(airportName);

	}

}
