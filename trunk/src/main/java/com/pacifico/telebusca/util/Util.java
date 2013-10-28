package com.pacifico.telebusca.util;

import java.sql.Timestamp;
import java.util.Calendar;

public final class Util {

	public static Timestamp getDate(){
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	
	public static Long inicioProceso(){
		return System.currentTimeMillis();
	}
	
	public static Long finProceso(){
		return System.currentTimeMillis();
	}
}
