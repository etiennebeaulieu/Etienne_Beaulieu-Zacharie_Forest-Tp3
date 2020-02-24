package formes;

/**
 * Permet de gérer les types de triangle possible pour un triangle
 * 
 * @author Étienne Beaulieu
 * @version 1
 *
 */
public enum TypeTriangle
{
	ISOCELE("isocèle"), EQUILATERAL("équilatéral"), RECTANGLE(
			"rectangle"), SCALENE("scalène");

	/**
	 * Le type
	 */
	private String type = null;

	/**
	 * Assigne le type
	 * 
	 * @param pType Le type
	 */
	private TypeTriangle(String pType)
	{
		setType(pType);
	}

	/**
	 * Retourne le type
	 * 
	 * @return Le type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Assigne le type
	 * 
	 * @param pType Le type
	 */
	private void setType(String pType)
	{
		type = pType;
	}

	/**
	 * Retourne le type sous la forme d'une string
	 * 
	 * @return Le type
	 */
	@Override
	public String toString()
	{
		return getType();
	}

}
