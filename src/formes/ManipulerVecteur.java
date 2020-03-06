package formes;

import java.util.ArrayList;

import exceptions.FormeException;

/**
 * Interface à implémenter dans VecteurFormes
 * 
 * @see java.lang.Object
 * @author Étienne Beaulieu
 * @author Zacharie Forest
 * @version 1
 */
public interface ManipulerVecteur
{
	
	/**
	 * Une méthode permettant d’obtenir une référence sur le vecteur de formes.
	 * 
	 * @return Le vecteur dynamique de formes.
	 */
	public ArrayList<Forme> getVecteur();
	
	/**
	 * Remplit le vecteur d'un nombre déterminé de formes.
	 * 
	 * @param pNbrFormes Le nombre de formes à mettre dans le vecteur.
	 * @throws Lance une exception si un objet invalide tente d'être créé.
	 */
	public void remplir(int pNbrFormes) throws FormeException;
	
	/**
	 * Tri les éléments du vecteur par forme et par couleur
	 */
	public void trier();
	
	/**
	 * Mélange aléatoirement le contenu du vecteur de formes.
	 */
	public void melanger();
}
