package formes;

/**
 * Cette classe abstraite permet de faire différentes opérations sur des formes.
 * Date de création : 15 février 2020
 * 
 * @see java.lang.Object
 * @author Étienne
 * @version 1
 *
 */
public abstract class Forme implements Comparable<Forme>
{
	/**
	 * Valeur minimum
	 */
	public static final int MIN_VAL = 1;

	/**
	 * Valeur maximum
	 */
	public static final int MAX_VAL = 30;

	/**
	 * Couleur par défaut
	 */
	public static final Couleur COULEUR_DEFAUT = Couleur.ROUGE;

	/**
	 * Nom de la forme
	 */
	private String nom = null;

	/**
	 * Couleur de la forme
	 */
	private Couleur couleur = null;

	/**
	 * Assigne le nom et la couleur par défaut à une forme.
	 * 
	 * @param pNom Le nom souhaité
	 */
	public Forme(String pNom)
	{
		nom = pNom;
		couleur = COULEUR_DEFAUT;
	}

	/**
	 * Retourne le nom
	 * 
	 * @return Le nom
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Retourne la couleur
	 * 
	 * @return La couleur
	 */
	public Couleur getCouleur()
	{
		return couleur;
	}

	/**
	 * Vérifie que la couleur est valide puis l'assigne
	 * 
	 * @param pCouleur La couleur souhaité
	 */
	public void setCouleur(Couleur pCouleur)
	{
		if (pCouleur != null)
		{
			couleur = pCouleur;
		}
	}

	/**
	 * L'aire de la forme
	 * 
	 * @return La surface
	 */
	public abstract int calculerSurface();

	/**
	 * Le périmètre de la forme
	 * 
	 * @return Le périmètre
	 */
	public abstract int calculerPerimetre();

	/**
	 * Retourne une String des infos de la forme sous la forme Forme rouge.
	 * 
	 * @return Les infos de la forme sous la forme Forme rouge.
	 */
	@Override
	public String toString()
	{
		return this.getNom() + " " + this.getCouleur().toString();
	}
	
	/**
	 * Retourne une String des infos de la forme sous la forme Forme rouge.
	 * 
	 * @return Les infos de la forme sous la forme Forme rouge.
	 */
	public String toStringCourt()
	{
		return this.getNom() + " " + this.getCouleur().toString();
	}

	/**
	 * Compare deux formes par rapport à leur nom puis leur couleur
	 * 
	 * @return Un nombre plus petit que 0, égal à 0 ou plus grand que 0 selon
	 *         que l'objet auquel elle est appliquée précède, est égal ou suit
	 *         obj.
	 */
	@Override
	public int compareTo(Forme obj)
	{
		return (this.nom + this.couleur)
				.compareToIgnoreCase(obj.nom + obj.couleur);

	}

	/**
	 * Compare deux objets selon leur nom, couleur et surface et vérifie s'ils
	 * sont égaux.
	 * 
	 * @return Vrai si les objets comparés ont le même nom, la même couleur et
	 *         la même surface, faux sinon
	 */
	@Override
	public boolean equals(Object obj)
	{
		return (obj instanceof Forme
				&& this.getNom().equals(((Forme) obj).getNom())
				&& this.calculerSurface() == ((Forme) obj).calculerSurface()
				&& this.getCouleur().equals(((Forme) obj).getCouleur()));
	}

}
