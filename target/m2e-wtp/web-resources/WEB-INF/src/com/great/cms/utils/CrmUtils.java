/**
 * 
 */
package com.great.cms.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Sknabil
 *
 */
public class CrmUtils {

	public static String generateUUID(){		
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static String getSysDate(String format){	
		DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }
}
