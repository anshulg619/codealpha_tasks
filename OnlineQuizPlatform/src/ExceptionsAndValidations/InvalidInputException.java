package ExceptionsAndValidations;

@SuppressWarnings("serial")
public class InvalidInputException extends Exception
{
	public InvalidInputException(String message)
	{
		super(message);
	}
	public InvalidInputException()
	{
		super("Invaid Input");
	}


}
