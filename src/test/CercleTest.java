package test;

import static org.junit.Assert.*;

import org.junit.*;
import exceptions.*;
import formes.*;

//Étienne Beaulieu et Zacharie Forest
public class CercleTest
{
	private static final int MIN_VAL = 1;
	private static final int MAX_VAL = 30;
	private static final int RAYON_DEFAUT = 10;

	private Cercle c1, c2, c3, c4, c5;

	@Before
	public void testCercleInt() throws FormeException
	{
		c1 = new Cercle(RAYON_DEFAUT);
		c2 = new Cercle(MIN_VAL);
		c3 = new Cercle(5);
		c4 = new Cercle(15);
		c5 = new Cercle(MAX_VAL);
	}

	@Test
	public void testCercleIntInvalide()
	{
		try
		{
			new Cercle(MIN_VAL - 1);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Cercle(MAX_VAL + 1);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
	}

	@Test
	public void testGetRayon()
	{
		assertTrue(c1.getRayon() == 10);
		assertTrue(c2.getRayon() == 1);
		assertTrue(c3.getRayon() == 5);
		assertTrue(c4.getRayon() == 15);
		assertTrue(c5.getRayon() == 30);
	}

	@Test
	public void testSetRayon()
	{
		// Set réussis
		c1.setRayon(MIN_VAL);
		assertTrue(c1.getRayon() == MIN_VAL);
		c1.setRayon(MAX_VAL);
		assertTrue(c1.getRayon() == MAX_VAL);
		c1.setRayon(MIN_VAL + 1);
		assertTrue(c1.getRayon() == MIN_VAL + 1);
		c1.setRayon(MAX_VAL - 1);
		assertTrue(c1.getRayon() == MAX_VAL - 1);
		c1.setRayon(15);
		assertTrue(c1.getRayon() == 15);

		// Set échoués
		c1.setRayon(MIN_VAL - 1);
		assertEquals(c1.getRayon(), 15);
		c1.setRayon(MAX_VAL + 1);
		assertEquals(c1.getRayon(), 15);
		c1.setRayon(40);
		assertEquals(c1.getRayon(), 15);
	}

	@Test
	public void testCalculerSurface()
	{
		for (int i = 0; i < 1000; i++)
		{
			int r = (int) (Math.random() * (MAX_VAL - MIN_VAL + 1) + MIN_VAL);
			c1.setRayon(r);
			assertEquals(c1.calculerSurface(), (int) (Math.PI * r * r));
		}

	}

	@Test
	public void testCalculerPerimetre()
	{
		for (int i = 0; i < 1000; i++)
		{
			int r = (int) (Math.random() * (MAX_VAL - MIN_VAL + 1) + MIN_VAL);
			c1.setRayon(r);
			assertEquals(c1.calculerPerimetre(), (int) (Math.PI * r * 2));
		}
	}

	@Test
	public void testToString()
	{
		assertEquals(c1.toString(), "Cercle rouge 10");
		assertEquals(c2.toString(), "Cercle rouge 1");
		assertEquals(c3.toString(), "Cercle rouge 5");
		assertEquals(c4.toString(), "Cercle rouge 15");
		assertEquals(c5.toString(), "Cercle rouge 30");
	}

}
