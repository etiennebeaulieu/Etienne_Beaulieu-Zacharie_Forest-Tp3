package tests_conformites;

import static org.junit.Assert.*;

import java.lang.reflect.Modifier;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import exceptions.FormeException;

/**
 * Tests de conformité pour la classe Rectangle Tp2 420-202-LI Hiver 2015
 *
 * @author Jocelyn.Goulet
 *
 */
public class CouleurConformeTest
{

	private static UtilTest ut = new UtilTest("CouleurConformeTest");

	@Before
	public void testCercle() throws FormeException
	{
		ut.addCas();
	}

	@AfterClass
	public static void tearDownAfterClass()
	{
		ut.affStat();
	}

	@Test
	public void testCouleurConforme() throws ClassNotFoundException, Exception
	{
		ut.affDebut();
		ut.addTotal(1);

		// Package et nom de la classe
		Class c = Class.forName("formes.Couleur");

		// Constructeurs
		assertTrue(c.isEnum());

		// Attributs
		assertTrue(c.getDeclaredField("nom").getType() == String.class);

		// Méthodes
		assertTrue(c.getMethod("getNom", new Class[]
		{}).getReturnType() == String.class);
		assertTrue((c.getDeclaredMethod("setNom", new Class[]
		{ String.class }).getModifiers()
				& Modifier.PRIVATE) == Modifier.PRIVATE);
		assertTrue(c.getDeclaredMethod("setNom", new Class[]
		{ String.class }).getReturnType() == void.class);
		assertTrue(c.getMethod("toString", new Class[]
		{}).getReturnType() == String.class);
		ut.addCumul(1);

		ut.affFin();
	}
}
