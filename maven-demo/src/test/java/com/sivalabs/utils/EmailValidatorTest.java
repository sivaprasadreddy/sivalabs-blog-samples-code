package com.sivalabs.utils;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmailValidatorTest {

	private static EmailValidator validator;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		validator = new EmailValidator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		validator = null;
	}

	@Test
	public final void testValidate() {
		boolean valid = validator.validate("siva@gmail.com");
		assertTrue(valid);
	}

}
