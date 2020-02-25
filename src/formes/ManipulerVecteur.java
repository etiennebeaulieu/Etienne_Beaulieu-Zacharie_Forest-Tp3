package formes;

import java.util.ArrayList;

import exceptions.FormeException;

public interface ManipulerVecteur
{
	public ArrayList<Forme> getVecteur();
	
	public void remplir(int pNbrFormes) throws FormeException;
	
	public void trier();
	
	public void melanger();
}
