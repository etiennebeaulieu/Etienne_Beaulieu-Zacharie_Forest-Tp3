package jeu;

import java.awt.Point;
import java.util.ArrayList;

import formes.*;

public class JeuMemoire implements Memorisable
{
	public static final int LIGNE = 6;
	public static final int COLONNE = 6;
	public static final int NBR_ELEMENTS_GRILLE = LIGNE*COLONNE;
	public static final int LONGUEUR_CHAINE = 17;
	private ArrayList<Point> vecteurPoints = null;
	private int niveau = 0;
	private VecteurFormes vecteurFormes = null;
	private Forme[][] grilleDeJeu = null;
	
	
	public JeuMemoire()
	{
		// TODO
	}
	
	private void preparerVecteurFormes()
	{
		// TODO
	}
	
	private void preparerGrilleDeJeu()
	{
		// TODO
	}
	
	@Override
	public String toString()
	{
		// TODO
		return null;
	}
	
	private String ajouterEspaces(int LONGUEUR_CHAINE, String pChaine)
	{
		// TODO
		return null;
	}
	
	
	private Point choisirForme()
	{
		// TODO
		return null;
	}
	

	@Override
	public int getNiveau()
	{
		return niveau;
	}

	@Override
	public void setNiveauPlusUn()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Point> jouerOrdi()
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		//TODO
	}
}
