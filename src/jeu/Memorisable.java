package jeu;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Interface à implémenter dans un jeu de mémoire
 * 
 * @see java.lang.Object
 * @author Étienne
 * @author Zacharie Forest
 * @version 1
 */
public interface Memorisable
{
	/**
	 * Niveau maximum
	 */
	public static final int NIVEAU_MAX = 6;
	
	/**
	 * Crée et retourne une Arraylist de points tous différents au nombre de
	 * niveau plus deux
	 * 
	 * @return Une Arraylist de points tous différents
	 */
	public ArrayList<Point> jouerOrdi();
	
	/**
	 * Retourne vrai si le point sélectionné est valide
	 * 
	 * @param x Coordonnée en x du point sélectionné
	 * @param y Coordonnée en y du point sélectionné
	 * @return true si le point sélectionné est valide
	 */
	public boolean jouerHumain(int x, int y);
	
	/**
	 * Retourne le nom de la forme  et la couleur sous la forme: Cerclebleu
	 * 
	 * @param x Coordonnée en x du point sélectionné
	 * @param y Coordonnée en y du point sélectionné
	 * @return Le nom de la forme  et la couleur sous la forme: Cerclebleu
	 * 
	 */
	public String getNomForme(int x, int y);
	
	/**
	 * Retourne le niveau
	 * 
	 * @return Le niveau
	 */
	public int getNiveau();
	
	/**
	 * Incrémente le niveau si il est plus petit que le niveau max
	 */
	public void setNiveauPlusUn();

}
