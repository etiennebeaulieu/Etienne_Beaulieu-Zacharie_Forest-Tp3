package formes;

/**
 * Permet de gérer les couleurs possible d'une forme
 * 
 * @author Étienne Beaulieu
 * @author Zacharie Forest
 * @version 1
 *
 */
public enum Couleur
{
	ROUGE("rouge"), VERT("vert"), BLEU("bleu"), JAUNE("jaune"), NOIR(
			"noir"), ORANGE("orange");

	/**
	 * Le nom
	 */
	private String nom = null;

	/**
	 * Assigne le nom à la couleur
	 * 
	 * @param pNom La couleur
	 */
	private Couleur(String pNom)
	{
		setNom(pNom);
	}

	/**
	 * Retourne la couleur
	 * 
	 * @return La couleur
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Assigne la couleur
	 * 
	 * @param pNom La couleur
	 */
	private void setNom(String pNom)
	{
		nom = pNom;
	}

	/**
	 * Retourne la couleur sous la forme d'une string
	 */
	@Override
	public String toString()
	{
		return getNom();
	}
}
