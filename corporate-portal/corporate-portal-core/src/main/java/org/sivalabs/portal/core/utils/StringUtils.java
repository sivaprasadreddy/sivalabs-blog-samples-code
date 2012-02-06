/**
 * 
 */
package org.sivalabs.portal.core.utils;

/**
 * @author skatam
 *
 */
public class StringUtils 
{
	private StringUtils() {
	}
	
	public static boolean isEmpty(String string)
	{
		return string==null || string.trim().length()==0;
	}
}
