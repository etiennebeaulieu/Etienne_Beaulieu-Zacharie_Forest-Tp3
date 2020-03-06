package formes;

import java.util.ArrayList;

import exceptions.FormeException;

/**
 * Cette classe est un contenant pour manipuler des formes. Date de création :
 * 29 février 2020
 * 
 * @see java.lang.Object
 * @author Étienne Beaulieu
 * @author Zacharie Forest
 * @version 1
 */
public class VecteurFormes implements ManipulerVecteur
{

	/**
	 * Vecteur dynamique de formes
	 */
	private ArrayList<Forme> vecteur = null;

	/**
	 * Construit un objet de type VecteurFormes et y instancie un vecteur
	 * dynamique de formes.
	 */
	public VecteurFormes()
	{
		vecteur = new ArrayList<Forme>(36);
	}

	/**
	 * Valide le nombre de formes.
	 * 
	 * @param pNbrFormes Le nombre de forme à vérifier.
	 * @return Vrai si le nombre de forme est positif, faux sinon
	 */
	private static boolean validerNbrFormes(int pNbrFormes)
	{
		return pNbrFormes >= 0;
	}

	/**
	 * Remplit le vecteur d'un nombre déterminé de formes.
	 * 
	 * @param pNbrFormes Le nombre de formes à mettre dans le vecteur.
	 * @throws FormeException Lance une exception si on tente de créer quelque
	 *             chose d'invalide
	 */
	@Override
	public void remplir(int pNbrFormes) throws FormeException
	{
		if (validerNbrFormes(pNbrFormes))
		{
			int i = 0;
			int couleur = 0;
			while (i < pNbrFormes)
			{
				vecteur.add(i, new Cercle(10));
				vecteur.get(i).setCouleur(Couleur.values()[couleur]);
				i++;

				if (i < pNbrFormes)
				{
					vecteur.add(i, new Rectangle(10, 10));
					vecteur.get(i).setCouleur(Couleur.values()[couleur]);
					i++;
				}
				if (i < pNbrFormes)
				{
					vecteur.add(i, new Triangle(10, 10, 10));
					vecteur.get(i).setCouleur(Couleur.values()[couleur]);
					i++;
				}

				couleur++;
				if (couleur >= Couleur.values().length)
					couleur = 0;
			}
		}
	}

	/**
	 * Une méthode permettant d’obtenir une référence sur le vecteur de formes.
	 * 
	 * @return Le vecteur dynamique de formes.
	 */
	@Override
	public ArrayList<Forme> getVecteur()
	{
		return vecteur;
	}

	/**
	 * Permet de visualiser le contenu complet du vecteur de formes (une par
	 * ligne, nom et couleur seulement).
	 * 
	 * @return Une string sous le format : Cercle bleu
	 */
	@Override
	public String toString()
	{
		String string = null;
		for (int i = 0; i < vecteur.size(); i++)
		{
			string += "\n" + vecteur.get(i).getNom() + " "
					+ vecteur.get(i).getCouleur();
		}
		return string;
	}

	/**
	 * Tri les éléments du vecteur par forme et par couleur
	 */
	@Override
	public void trier()
	{
		boolean flag = false;
		int courant = (vecteur.size() - 2);
		// Tri à bulle amélioré
		do
		{
			flag = false;
			for (int position = 0; position <= courant; position++)
			{
				if (vecteur.get(position)
						.compareTo(vecteur.get(position + 1)) > 0)
				{

					permuter(position, position + 1);
					flag = true;
				}
			}
			courant--;
		}
		while (flag);
	}

	/**
	 * Mélange aléatoirement le contenu du vecteur de formes.
	 */
	@Override
	public void melanger()
	{
		int ind1;
		int ind2;
		for (int i = 0; i < 1000000; i++)
		{
			ind1 = (int) (Math.random() * vecteur.size());
			ind2 = (int) (Math.random() * vecteur.size());
			permuter(ind1, ind2);
		}
	}

	/**
	 * Intervertit deux la position de deux formes dans le vecteur de formes.
	 * 
	 * @param pInd1 Indice de la première forme
	 * @param pInd2 Indice de la deuxième forme
	 */
	private void permuter(int pInd1, int pInd2)
	{
		Forme temp = vecteur.set(pInd1, vecteur.get(pInd2));
		vecteur.set(pInd2, temp);
	}
}
