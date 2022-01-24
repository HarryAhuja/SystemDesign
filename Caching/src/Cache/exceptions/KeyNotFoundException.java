package Cache.exceptions;

public class KeyNotFoundException extends RuntimeException
{
	public KeyNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}
}
