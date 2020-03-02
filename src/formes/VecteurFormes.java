package formes;

import java.util.ArrayList;

import exceptions.FormeException;
import jeu.*;

public class VecteurFormes implements ManipulerVecteur
{

	private ArrayList<Forme> vecteur = null;

	public VecteurFormes()
	{
		vecteur = new ArrayList<Forme>(36);
	}

	private static boolean validerNbrFormes(int pNbrFormes)
	{
		return pNbrFormes >= 0;
	}

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

	@Override
	public ArrayList<Forme> getVecteur()
	{
		return vecteur;
	}

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

	@Override
	public void trier()
	{
		boolean flag = false;
		int courant = (vecteur.size() - 2);
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

	private void permuter(int pInd1, int pInd2)
	{
		Forme temp = vecteur.set(pInd1, vecteur.get(pInd2));
		vecteur.set(pInd2, temp);
	}
}
