package formes;

import exceptions.FormeException;

/**
 * Cette classe permet de créer des cercles et faire différentes opérations sur
 * ceux-ci. Date de création : 27 janvier 2020
 * 
 * @see java.lang.Object
 * @author Étienne
 * @version 2
 *
 */
public class Cercle extends Forme
{
	/**
	 * Le rayon
	 */
	private int rayon;

	/**
	 * Si le rayon est valide, on assigne sa valeur. S’il est invalide on lève
	 * une exception de type FormeException.
	 * 
	 * @param pRayon Rayon qu'aura le cercle s'il est valide
	 * @throws FormeException Si le rayon reçu en parametre n'est pas valide
	 */
	public Cercle(int pRayon) throws FormeException
	{

		super("Cercle");
		if (validerRayon(pRayon))
		{
			rayon = pRayon;
		}
		else
			throw new FormeException("Rayon invalide");
	}

	/**
	 * Retourne le rayon
	 * 
	 * @return Le rayon
	 */
	public int getRayon()
	{
		return rayon;
	}

	/**
	 * Valide que le rayon est valide puis le règle
	 * 
	 * @param pRayon Le rayon voulu
	 */
	public void setRayon(int pRayon)
	{
		if (validerRayon(pRayon))
			rayon = pRayon;
	}

	/**
	 * Valide que le rayon est entre les valeurs maximum et minimum
	 * 
	 * @param pRayon rayon
	 * @return Vrai si le rayon est valide,, faux sinon
	 */
	private static boolean validerRayon(int pRayon)
	{
		return pRayon >= MIN_VAL && pRayon <= MAX_VAL;
	}

	/**
	 * Cette méthode calcule la surface du cercle
	 * 
	 * @return La partie entière de la surface du cercle
	 */
	@Override
	public int calculerSurface()
	{
		return (int) (Math.PI * rayon * rayon);
	}

	/**
	 * Cette méthode calcule le périmetre du cercle
	 * 
	 * @return La partie entière du périmetre du cercle
	 */
	@Override
	public int calculerPerimetre()
	{
		return (int) (Math.PI * rayon * 2);
	}

	/**
	 * retourne l’information de l’objet sous cette forme :nom couleur rayon ex
	 * : Cercle orange 20
	 * 
	 * @return L’information de l’objet sous cette forme Cercle orange 20
	 */
	@Override
	public String toString()
	{
		return super.toString() + " " + rayon;
	}

}
