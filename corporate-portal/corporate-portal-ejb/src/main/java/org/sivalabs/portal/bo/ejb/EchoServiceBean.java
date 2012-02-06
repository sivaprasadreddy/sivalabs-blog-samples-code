/**
 * 
 */
package org.sivalabs.portal.bo.ejb;

import javax.ejb.Stateless;

import org.sivalabs.portal.bo.IEchoService;

/**
 * @author skatam
 *
 */
@Stateless
public class EchoServiceBean implements IEchoService
{

	@Override
	public String echo(String name) {
		return name+"..."+name;
	}

}
