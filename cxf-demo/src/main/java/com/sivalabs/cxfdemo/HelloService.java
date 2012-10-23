/**
 * 
 */
package com.sivalabs.cxfdemo;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Siva
 *
 */
@WebService(endpointInterface="com.sivalabs.cxfdemo.IHelloService")
@Component("helloService")
public class HelloService implements IHelloService
{
	@Autowired
	private HelloBO helloBO;
	
	@Override
	public String sayHello(String name) {
		return helloBO.sayHello(name);
	}

}
