/**
 * 
 */
package com.sivalabs.core.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author skatam
 *
 */
public class StringUtilsTest {

	@Test
	public void test_isNullOrBlank()
	{
		Assert.assertTrue(StringUtils.isNullOrBlank(null));
		Assert.assertTrue(StringUtils.isNullOrBlank(""));
		Assert.assertTrue(StringUtils.isNullOrBlank(" "));
		Assert.assertFalse(StringUtils.isNullOrBlank("1"));		
	}
	
	@Test
	public void test_split()
	{
		Assert.assertEquals(0, StringUtils.split(null).size());
		Assert.assertEquals(1, StringUtils.split("").size());
		Assert.assertEquals(3, StringUtils.split("a,b,c").size());
		
	}
}
