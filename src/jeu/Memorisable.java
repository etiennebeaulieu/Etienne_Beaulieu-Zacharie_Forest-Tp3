package jeu;

import java.awt.Point;
import java.util.ArrayList;

//Étienne Beaulieu et Zacharie Forest
public interface Memorisable
{
	public static final int NIVEAU_MAX = 6;
	
	public ArrayList<Point> jouerOrdi();
	
	public boolean jouerHumain(int x, int y);
	
	public String getNomForme(int x, int y);
	
	public int getNiveau();
	
	public void setNiveauPlusUn();

}
