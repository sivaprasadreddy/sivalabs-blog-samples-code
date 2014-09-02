/**
 * 
 */
package com.sivalabs.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author skatam
 *
 */
public final class StringUtils 
{
	public static boolean isNullOrBlank(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	public static List<String> split(String str) {
		if(str == null){
			return new ArrayList<String>();
		}
		String[] strings = str.split(",");
		return Arrays.asList(strings);
	}
}
