#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * 
 */
package ${package};

/**
 * @author Siva
 *
 */
public class LinkshareException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public LinkshareException()
	{
	}

	public LinkshareException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public LinkshareException(String message)
	{
		super(message);
	}

	public LinkshareException(Throwable cause)
	{
		super(cause);
	}

}
