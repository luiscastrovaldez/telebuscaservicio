package com.pacifico.telebusca.util;

import java.sql.Timestamp;
import java.util.Calendar;

public final class Util {

	public static Timestamp getDate(){
		return new Timestamp(Calendar.getInstance().getTime().getTime());
	}
}
