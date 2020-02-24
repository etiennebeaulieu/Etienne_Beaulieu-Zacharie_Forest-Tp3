﻿package utilitaires;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jocelyn -- Cégep Limoilou
 * @version 2013
 */
public class Output
{

	/**
	 * Permet d'afficher un message.
	 *
	 * @param message
	 */
	public static void afficherMessage(String message)
	{
		// Boîte de dialogue d'affichage
		Output.afficherMessage(message, "Information");
	}

	/**
	 * Permet d'afficher un message.
	 *
	 * @param message
	 */
	public static void afficherMessage(String message, String titre)
	{
		// Boîte de dialogue d'affichage
		JOptionPane.showMessageDialog(null, message, titre,
				JOptionPane.INFORMATION_MESSAGE);
	}
}
