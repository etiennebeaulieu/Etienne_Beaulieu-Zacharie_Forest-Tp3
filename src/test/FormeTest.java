package test;

import static org.junit.Assert.*;

import org.junit.*;
import formes.*;
import exceptions.*;

//Étienne Beaulieu
public class FormeTest
{
	private Forme t1, t2, t5, r1, r2, r5, c1, c2;

	@Before
	public void testForme() throws FormeException
	{
		t1 = new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL);
		t2 = new Triangle(15, 15, 15);
		t5 = new Triangle(3, 4, 5);
		r1 = new Rectangle(Rectangle.MIN_VAL, 15);
		r2 = new Rectangle(Rectangle.MAX_VAL, 15);
		r5 = new Rectangle(15, 15);
		c1 = new Cercle(10);
		c2 = new Cercle(Forme.MIN_VAL);
	}

	@Test
	public void testGetNom()
	{
		assertEquals(t1.getNom(), "Triangle");
		assertEquals(t2.getNom(), "Triangle");
		assertEquals(t5.getNom(), "Triangle");
		assertEquals(r1.getNom(), "Rectangle");
		assertEquals(r2.getNom(), "Rectangle");
		assertEquals(r5.getNom(), "Rectangle");
		assertEquals(c1.getNom(), "Cercle");
		assertEquals(c2.getNom(), "Cercle");
	}

	@Test
	public void testGetCouleur()
	{
		assertEquals(t1.getCouleur(), Couleur.ROUGE);
		assertEquals(t2.getCouleur(), Couleur.ROUGE);
		assertEquals(t5.getCouleur(), Couleur.ROUGE);
		assertEquals(r1.getCouleur(), Couleur.ROUGE);
		assertEquals(r2.getCouleur(), Couleur.ROUGE);
		assertEquals(r5.getCouleur(), Couleur.ROUGE);
		assertEquals(c1.getCouleur(), Couleur.ROUGE);
		assertEquals(c2.getCouleur(), Couleur.ROUGE);
	}

	@Test
	public void testSetCouleur()
	{
		// Set réussi
		t1.setCouleur(Couleur.ROUGE);
		assertTrue(t1.getCouleur().equals(Couleur.ROUGE));
		t1.setCouleur(Couleur.VERT);
		assertTrue(t1.getCouleur().equals(Couleur.VERT));
		t1.setCouleur(Couleur.BLEU);
		assertTrue(t1.getCouleur().equals(Couleur.BLEU));
		t1.setCouleur(Couleur.JAUNE);
		assertTrue(t1.getCouleur().equals(Couleur.JAUNE));
		t1.setCouleur(Couleur.NOIR);
		assertTrue(t1.getCouleur().equals(Couleur.NOIR));
		t1.setCouleur(Couleur.ORANGE);
		assertTrue(t1.getCouleur().equals(Couleur.ORANGE));

		// Set échoué
		t2.setCouleur(null);
		assertEquals(t2.getCouleur(), Couleur.ROUGE);
	}

	@Test
	public void testCompareTo() throws FormeException
	{
		t5.setCouleur(Couleur.BLEU);

		// Même nom, même couleur
		assertTrue(t1.compareTo(t2) == 0);
		assertTrue(r1.compareTo(r2) == 0);
		assertTrue(c1.compareTo(c2) == 0);

		// Même nom, pas même couleur
		assertTrue(t1.compareTo(t5) > 0);
		assertTrue(t5.compareTo(t1) < 0);

		// Pas même nom, même couleur
		assertTrue(t1.compareTo(new Rectangle(3, 4)) >= 0);
		assertTrue(t1.compareTo(new Cercle(3)) >= 0);
		assertTrue(r1.compareTo(new Triangle(3, 4, 5)) <= 0);
		assertTrue(r1.compareTo(new Cercle(3)) >= 0);
		assertTrue(c1.compareTo(new Rectangle(3, 4)) <= 0);
		assertTrue(c1.compareTo(new Triangle(3, 4, 5)) <= 0);

		// Pas même nom, pas même couleur
		assertTrue(t2.compareTo(c1) > 0);

	}

	@Test
	public void testEqualsObject() throws FormeException
	{

		// Même nom, même surface, même couleur
		assertTrue(t2.equals(new Triangle(15, 15, 15)));
		assertTrue(c1.equals(new Cercle(10)));
		assertTrue(r5.equals(new Rectangle(15, 15)));

		// Même nom, même surface, pas même couleur
		t2.setCouleur(Couleur.BLEU);
		assertFalse(t2.equals(new Triangle(15, 15, 15)));

		// Même nom, pas même surface, même couleur
		assertFalse(r1.equals(r2));
		assertFalse(c1.equals(c2));

		// Pas même nom, même surface, même couleur
		assertFalse(new Cercle(2).equals(new Rectangle(3, 4)));
		assertFalse(t5.equals(new Rectangle(2, 3)));

		// null
		assertFalse(t1.equals(null));
		assertFalse(r1.equals(null));
		assertFalse(c1.equals(null));
		// Pas forme
		assertFalse(t1.equals(new Integer(3)));
		assertFalse(r1.equals(new Integer(3)));
		assertFalse(c1.equals(new Integer(3)));
	}

	@Test
	public void testToString()
	{
		assertEquals(c1.toString(), "Cercle rouge 10");
		assertEquals(c2.toString(), "Cercle rouge 1");
		assertEquals(r1.toString(), "Rectangle rouge 1, 15");
		assertEquals(r2.toString(), "Rectangle rouge 30, 15");
		assertEquals(r5.toString(), "Rectangle rouge 15, 15");
		assertEquals(t1.toString(), "Triangle rouge équilatéral 1, 1, 1");
		assertEquals(t2.toString(), "Triangle rouge équilatéral 15, 15, 15");
		assertEquals(t5.toString(), "Triangle rouge rectangle 3, 4, 5");
	}

}
