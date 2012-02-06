/**
 * 
 */
package org.sivalabs.portal.core.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author skatam
 *
 */
public class JNDIUtils 
{
	private JNDIUtils() {
	}
	
	public static <T> T lookup(String jndiName, Class<T> clazz) 
	{
		try {
			Context context = new InitialContext();
			return clazz.cast(context.lookup(jndiName));
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
