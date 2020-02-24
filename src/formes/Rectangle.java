package formes;

import exceptions.FormeException;

/**
 * Cette classe permet de créer des rectangles et faire différentes opérations
 * sur ceux-ci. Date de création : 27 janvier 2020
 * 
 * @see java.lang.Object
 * @author Étienne
 * @version 2
 *
 */
public class Rectangle extends Forme
{

	/**
	 * La hauteur
	 */
	private int hauteur;

	/**
	 * La largeur
	 */
	private int largeur;

	/**
	 * Si les paramètres sont valides, on les assigne. Si une des valeurs est
	 * invalide on lève une exception de type FormeException.
	 * 
	 * @param pHauteur Hauteur qu'aura le rectangle
	 * @param pLargeur Largeur qu'aura le rectangle
	 * @throws FormeException Si la hauteur ou la largeur n'est pas valide
	 */
	public Rectangle(int pHauteur, int pLargeur) throws FormeException
	{
		super("Rectangle");
		if (validerHauteur(pHauteur) && validerLargeur(pLargeur))
		{
			hauteur = pHauteur;
			largeur = pLargeur;
		}
		else
			throw new FormeException("Côté invalide");
	}

	/**
	 * Retourne la hauteur
	 * 
	 * @return La hauteur
	 */
	public int getHauteur()
	{
		return hauteur;
	}

	/**
	 * Valide que la hauteur respecte les mesures puis la règle.
	 * 
	 * @param pHauteur La hauteur voulue
	 */
	public void setHauteur(int pHauteur)
	{
		if (validerHauteur(pHauteur))
			hauteur = pHauteur;
	}

	/**
	 * Retourne la largeur
	 * 
	 * @return La largeur
	 */
	public int getLargeur()
	{
		return largeur;
	}

	/**
	 * Valide que la largeur respecte les mesures puis la règle.
	 * 
	 * @param pLargeur La largeur voulue
	 */
	public void setLargeur(int pLargeur)
	{
		if (validerLargeur(pLargeur))
			largeur = pLargeur;
	}

	/**
	 * Valide que la hauteur est entre les valeurs maximum et minimum
	 * 
	 * @param pHauteur hauteur
	 * @return Vrai si la hauteur est valide,, faux sinon
	 */
	private static boolean validerHauteur(int pHauteur)
	{
		return pHauteur >= MIN_VAL && pHauteur <= MAX_VAL;
	}

	/**
	 * Valide que la largeur est entre les valeurs maximum et minimum
	 * 
	 * @param pLargeur largeur
	 * @return Vrai si la largeur est valide,, faux sinon
	 */
	private static boolean validerLargeur(int pLargeur)
	{
		return pLargeur >= MIN_VAL && pLargeur <= MAX_VAL;
	}

	/**
	 * Cette méthode calcule la surface du rectangle et la retourne
	 * 
	 * @return La surface du rectangle
	 */
	@Override
	public int calculerSurface()
	{
		return hauteur * largeur;
	}

	/**
	 * Cette méthode calcule le périmetre du rectangle et le retourne
	 * 
	 * @return Le périmetre du rectangle
	 */
	@Override
	public int calculerPerimetre()
	{
		return 2 * hauteur + 2 * largeur;
	}

	/**
	 * Retourne l’information de l’objet sous cette forme : nom couleur hauteur,
	 * largeur (dans l’ordre) : ex : Rectangle rouge 3, 4
	 * 
	 * @return L’information de l’objet sous cette forme Rectangle rouge 3, 4
	 */
	@Override
	public String toString()
	{
		return super.toString() + " " + hauteur + ", " + largeur;
	}

}
