package exceptions;

/**
 * @see java.lang.Exception
 * @author Étienne
 * @version 1
 *
 */
public class FormeException extends Exception
{
	/**
	 * Instancie une exception de type FormeException sans paramètre
	 */
	public FormeException()
	{
		super();
	}

	/**
	 * Instancie une exception de type FormeException
	 * 
	 * @param message Explique l'erreur
	 */
	public FormeException(String message)
	{
		super(message);
	}
}
