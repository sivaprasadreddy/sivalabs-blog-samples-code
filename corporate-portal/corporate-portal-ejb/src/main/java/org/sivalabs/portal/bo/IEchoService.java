/**
 * 
 */
package org.sivalabs.portal.bo;

import javax.ejb.Remote;

/**
 * @author skatam
 *
 */
@Remote
public interface IEchoService 
{
	public String echo(String name);
}
