/**
 * 
 */
package com.sivalabs.cxfdemo;

import org.springframework.stereotype.Component;

/**
 * @author Siva
 *
 */
@Component
public class HelloBO {
	public String sayHello(String name) {
		return "Hello "+name;
	}
}
