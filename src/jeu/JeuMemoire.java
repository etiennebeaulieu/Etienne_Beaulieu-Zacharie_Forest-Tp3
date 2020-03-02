package jeu;

import java.awt.Point;
import java.util.ArrayList;

import exceptions.FormeException;
import formes.*;

public class JeuMemoire implements Memorisable
{
	public static final int LIGNE = 6;
	public static final int COLONNE = 6;
	public static final int NBR_ELEMENTS_GRILLE = LIGNE * COLONNE;
	public static final int LONGUEUR_CHAINE = 17;
	private ArrayList<Point> vecteurPoints = null;
	private int niveau = 0;
	private VecteurFormes vecteurFormes = null;
	private Forme[][] grilleDeJeu = null;

	public JeuMemoire()
	{
		try 
		{
			preparerVecteurFormes();
			preparerGrilleDeJeu();
		}
		catch(FormeException e)
		{
			new FormeException("");
		}
		
		

	}

	private void preparerVecteurFormes() throws FormeException
	{
		try
		{
			vecteurFormes = new VecteurFormes();
			vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
		}
		catch(FormeException e)
		{
			new FormeException("Nbr d'élément");
		}
		vecteurFormes.melanger();
	}

	private void preparerGrilleDeJeu() throws FormeException
	{
		grilleDeJeu = new Forme[LIGNE][COLONNE];
		for (int i = 0; i < LIGNE; i++)
		{
			for (int j = 0; j < COLONNE; j++)
			{
				for (Forme f : vecteurFormes.getVecteur())
					grilleDeJeu[i][j] = f;
			}
		}
	}

	@Override
	public String toString()
	{
		String s = "";
		for (int i = 0; i < LIGNE; i++)
		{
			for (int j = 0; j < COLONNE; j++)
			{
				s += ajouterEspaces(grilleDeJeu[i][j].toStringCourt().length(),
						grilleDeJeu[i][j].toStringCourt());
			}
			s += "\n";
		}
		return s;
	}

	private String ajouterEspaces(int longueurChaine, String pChaine)
	{
		for (int i = longueurChaine; i <= LONGUEUR_CHAINE; i++)
			pChaine += " ";
		return pChaine;
	}

	private Point choisirForme()
	{
		return new Point((int) (Math.random() * LIGNE),
				(int) (Math.random() * COLONNE));
	}

	@Override
	public int getNiveau()
	{
		return niveau;
	}

	@Override
	public void setNiveauPlusUn()
	{
		if (niveau < NIVEAU_MAX)
			niveau++;

	}

	@Override
	public ArrayList<Point> jouerOrdi()
	{
		ArrayList<Point> liste = new ArrayList<Point>();
		int i = 0;
		do
		{
			Point temp = choisirForme();
			if (!liste.contains(temp))
			{
				liste.add(temp);
				i++;
			}
		}
		while (i < niveau + 2);
		return liste;
	}

	@Override
	public boolean jouerHumain(int x, int y)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNomForme(int x, int y)
	{
		return (grilleDeJeu[x][y].getNom()
				+ grilleDeJeu[x][y].getCouleur().getNom());
	}

	public VecteurFormes getVecteur()
	{
		return vecteurFormes;
	}

	public Forme[][] getGrille()
	{
		return grilleDeJeu;
	}
}
