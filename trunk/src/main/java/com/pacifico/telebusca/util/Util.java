package com.pacifico.telebusca.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public final class Util {

	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static Timestamp getDateTimeStamp(){
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	
	public static Date getDate(){
		return new Date(Calendar.getInstance().getTimeInMillis());
	}
	
	public static Long inicioProceso(){
		return System.currentTimeMillis();
	}
	
	public static Long finProceso(){
		return System.currentTimeMillis();
	}
	
	public static boolean isWindows() {		 
		return (OS.indexOf("win") >= 0); 
	}
}
