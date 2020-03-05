package jeu;

import java.awt.Point;
import java.util.ArrayList;

import exceptions.FormeException;
import formes.*;

/**
 * Permet de définir tous les comportements nécessaires à la gestion du jeu de
 * mémoire « Souviens-toi … » Date de création : 29 février 2020
 * 
 * @see java.lang.Object
 * @author Étienne
 * @author Zacharie Forest
 * @version 1
 */
public class JeuMemoire implements Memorisable
{
	/**
	 * Le nombre de ligne que comptera la grille de jeu
	 */
	public static final int LIGNE = 6;

	/**
	 * Le nombre de colonne que comptera la grille de jeu
	 */
	public static final int COLONNE = 6;

	/**
	 * Le nombre de forme total de la grille de jeu
	 */
	public static final int NBR_ELEMENTS_GRILLE = LIGNE * COLONNE;

	/**
	 * La longueur d'une chaine de caractère
	 */
	public static final int LONGUEUR_CHAINE = 17;

	/**
	 * Un tableau dynamique de points
	 */
	private ArrayList<Point> vecteurPoints = null;

	/**
	 * Le niveau courant du jeu
	 */
	private int niveau = 0;

	/**
	 * La liste des formes
	 */
	private VecteurFormes vecteurFormes = null;

	/**
	 * La matrice des formes constituant le jeu
	 */
	private Forme[][] grilleDeJeu = null;

	/**
	 * Permet de remplir la matrice à partir d’un objet VecteurFormes
	 * préalablement rempli et mélangé.
	 */
	public JeuMemoire()
	{
		try
		{
			preparerVecteurFormes();
			preparerGrilleDeJeu();
		}
		catch (FormeException e)
		{
			new FormeException("Objet invalide");
		}
		niveau = 1;

	}

	/**
	 * Crée un vecteur de formes, le remplit puis le mélange.
	 * 
	 * @throws FormeException Lance une exception si un objet invalide tente
	 *             d'être créé.
	 */
	private void preparerVecteurFormes() throws FormeException
	{
		vecteurFormes = new VecteurFormes();
		vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);

		vecteurFormes.melanger();
	}

	/**
	 * 
	 * @throws FormeException
	 */
	private void preparerGrilleDeJeu() throws FormeException
	{
		grilleDeJeu = new Forme[LIGNE][COLONNE];
		int position = 0;
		for (int i = 0; i < LIGNE; i++)
		{
			for (int j = 0; j < COLONNE; j++)
			{
				grilleDeJeu[i][j] = vecteurFormes.getVecteur().get(position);
				position++;
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
						grilleDeJeu[i][j].toStringCourt()) + "| ";
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
		vecteurPoints = new ArrayList<Point>();
		int i = 0;
		do
		{
			Point temp = choisirForme();
			if (!vecteurPoints.contains(temp))
			{
				vecteurPoints.add(temp);
				i++;
			}
		}
		while (i < niveau + 2);
		return vecteurPoints;
	}

	@Override
	public boolean jouerHumain(int x, int y)
	{
		boolean estBon = false;
		Point point = new Point(x, y);
		if (this.vecteurPoints.size() != 0)
		{
			if (point.equals(this.vecteurPoints.remove(0)))
				estBon = true;
		}
		return estBon;
	}

	@Override
	public String getNomForme(int x, int y)
	{
		return (grilleDeJeu[x][y].toStringCourt());
	}

	public VecteurFormes getVecteur()
	{
		return vecteurFormes;
	}

	public Forme[][] getGrille()
	{
		return grilleDeJeu;
	}

	public static void main(String[] args)
	{
		// JeuMemoire jeu = new JeuMemoire();
		// System.out.println(jeu.toString());

	}
}
