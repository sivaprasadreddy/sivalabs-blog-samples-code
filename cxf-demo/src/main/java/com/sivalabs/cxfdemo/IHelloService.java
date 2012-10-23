/**
 * 
 */
package com.sivalabs.cxfdemo;

import javax.jws.WebService;

/**
 * @author Siva
 *
 */
@WebService
public interface IHelloService {

	public String sayHello(String name);
}
