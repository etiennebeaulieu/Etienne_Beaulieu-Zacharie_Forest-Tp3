package formes;

import java.util.Arrays;

import exceptions.FormeException;

/**
 * Cette classe permet de créer des triangles et faire différentes opérations
 * sur ceux-ci. Date de création : 15 février 2020
 * 
 * @see java.lang.Object
 * @author Étienne
 * @version 1
 *
 */
public class Triangle extends Forme
{
	/**
	 * Côté A
	 */
	private int coteA;

	/**
	 * Côté B
	 */
	private int coteB;

	/**
	 * Côté C
	 */
	private int coteC;

	/**
	 * Si les paramètres sont valides, on les assigne. Si une des valeurs est
	 * invalide on lève une exception de type FormeException.
	 * 
	 * @param pCoteA Mesure du premier côté
	 * @param pCoteB Mesure du second côté
	 * @param pCoteC Mesure du troisième côté
	 * @throws FormeException Si un des côtés n'est pas valide ou si les 3 côtés
	 *             ne forment pas un triangle
	 */
	public Triangle(int pCoteA, int pCoteB, int pCoteC) throws FormeException
	{
		super("Triangle");
		if (validerCote(pCoteA) && validerCote(pCoteB) && validerCote(pCoteC))
		{
			if (estTriangle(pCoteA, pCoteB, pCoteC))
			{
				coteA = pCoteA;
				coteB = pCoteB;
				coteC = pCoteC;
			}
			else
				throw new FormeException("N'est pas un triangle");
		}
		else
			throw new FormeException("Un côté n'est pas valide");

	}

	/**
	 * Retourne le côté A
	 * 
	 * @return Le côté A
	 */
	public int getCoteA()
	{
		return coteA;
	}

	/**
	 * Retourne le côté B
	 * 
	 * @return Le côté B
	 */
	public int getCoteB()
	{
		return coteB;
	}

	/**
	 * Retourne le côté C
	 * 
	 * @return Le côté C
	 */
	public int getCoteC()
	{
		return coteC;
	}

	/**
	 * Vérifie si le côté respecte les valeurs minimum et maximum.
	 * 
	 * @param pCote Le côté à valider
	 * @return Vrai si le côté est valide faux sinon.
	 */
	private static boolean validerCote(int pCote)
	{
		return pCote >= MIN_VAL && pCote <= MAX_VAL;
	}

	/**
	 * Calcule la surface du triangle et l'arrondie à l'unité.
	 * 
	 * @return La surface
	 */
	@Override
	public int calculerSurface()
	{
		float p = this.calculerPerimetre() / 2;

		return (int) (Math.sqrt(p * (p - coteA) * (p - coteB) * (p - coteC)));
	}

	/**
	 * Calcule le périmètre du triangle.
	 * 
	 * @return Le périmètre
	 */
	@Override
	public int calculerPerimetre()
	{
		return coteA + coteB + coteC;
	}

	/**
	 * Retourne une String des infos du triangle sous la forme "Cercle bleu 3,
	 * 4, 5"
	 * 
	 * @return Les infos du triangle sous la forme "Cercle bleu 3, 4, 5"
	 */
	@Override
	public String toString()
	{

		return super.toString() + " " + getType().toString() + " "
				+ getCotesTries()[0] + ", " + getCotesTries()[1] + ", "
				+ getCotesTries()[2];
	}

	/**
	 * Vérifie combien de côtés sont égaux
	 * 
	 * @return Le nombre de côtés égaux
	 */
	private int getNbrCoteEgaux()
	{
		int nbrCotesEgaux = 0;

		if (coteA == coteB || coteA == coteC || coteB == coteC)
			nbrCotesEgaux = 2;
		if (coteA == coteB && coteA == coteC)
			nbrCotesEgaux = 3;

		return nbrCotesEgaux;

	}

	/**
	 * Utilise la méthode une méthode de la classe Arrays pour classer les 3
	 * côtés en ordre croissant
	 * 
	 * @return Un vecteur des valeurs des côtés en ordre croissant
	 */
	private int[] getCotesTries()
	{
		int[] vec = new int[]
		{ coteA, coteB, coteC };
		Arrays.sort(vec);
		return vec;
	}

	/**
	 * Utilise la relation de pythagore pour vérifier si le triangle est
	 * rectangle.
	 * 
	 * @return Vrai si le triangle est rectangle, faux sinon.
	 */
	private boolean estRectangle()
	{
		int[] cotesTries = this.getCotesTries();
		return (Math.pow(cotesTries[2], 2) == Math.pow(cotesTries[0], 2)
				+ Math.pow(cotesTries[1], 2));
	}

	/**
	 * À l'aide de ses mesures, vérifie le type d'un triangle.
	 * 
	 * @return Le type du triangle
	 */
	public TypeTriangle getType()
	{
		TypeTriangle type = null;
		if (estRectangle())
			type = TypeTriangle.RECTANGLE;
		else
			if (getNbrCoteEgaux() == 3)
				type = TypeTriangle.EQUILATERAL;
			else
				if (getNbrCoteEgaux() == 2)
					type = TypeTriangle.ISOCELE;
				else
					type = TypeTriangle.SCALENE;

		return type;
	}

	/**
	 * Vérifie si le triangle est mathématiquement correct.
	 * 
	 * @param pCoteA Côté A
	 * @param pCoteB Côté B
	 * @param pCoteC Côté C
	 * @return Vrai si le triangle est valide, faux sinon
	 */
	private static boolean estTriangle(int pCoteA, int pCoteB, int pCoteC)
	{
		// Chaque côtés d'un triangle est plus petit que la somme des deux
		// autres
		return pCoteA < pCoteB + pCoteC && pCoteB < pCoteA + pCoteC
				&& pCoteC < pCoteA + pCoteB;
	}
}
