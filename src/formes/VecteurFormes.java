package formes;

import java.util.ArrayList;

import exceptions.FormeException;

public class VecteurFormes implements ManipulerVecteur
{

	private ArrayList<Forme> vecteur = null;

	public VecteurFormes()
	{

	}

	private static boolean validerNbrFormes(int pNbrFormes)
	{
		return pNbrFormes = JeuMemoire.NBR_ELEMENTS_GRILLE;
	}

	public void remplir(int pNbrFormes) throws FormeException
	{
		int i = 0;
		int couleur = 0;
		while (i <= pNbrFormes)
		{
			vecteur.add(i, new Cercle(10));
			vecteur.get(i).setCouleur(Couleur.values()[couleur]);
			i++;

			if (i <= pNbrFormes)
			{
				vecteur.add(i, new Rectangle(10, 10));
				vecteur.get(i).setCouleur(Couleur.values()[couleur]);
				i++;
			}
			if (i <= pNbrFormes)
			{
				vecteur.add(i, new Triangle(10, 10, 10));
				vecteur.get(i).setCouleur(Couleur.values()[couleur]);
				i++;
			}

			couleur++;
			if (couleur > Couleur.values().length)
				couleur = 0;
		}
	}

	public ArrayList<Forme> getVecteur()
	{
		return vecteur;
	}

	public String toString()
	{
		String string = null;
		for(int i = 0; i < vecteur.size(); i++)
		{
			string += vecteur.get(i).getNom() + " " + vecteur.get(i).getCouleur();
		}
		return string;
	}

	public void trier()
	{

	}

	public void melanger()
	{
		for(int i = 0; i < 1000000; i++)
		{
			int x = Math.random()*
		}
	}

	private void permuter(int pInd1, int pInd2)
	{

	}
}
