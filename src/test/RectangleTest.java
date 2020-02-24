package test;

import static org.junit.Assert.*;

import org.junit.*;

import exceptions.FormeException;
import formes.*;

//Étienne Beaulieu
public class RectangleTest
{
	private Rectangle r1, r2, r3, r4, r5;

	@Before
	public void testRectangle() throws FormeException
	{
		r1 = new Rectangle(Rectangle.MIN_VAL, 15);
		r2 = new Rectangle(Rectangle.MAX_VAL, 15);
		r3 = new Rectangle(15, Rectangle.MIN_VAL);
		r4 = new Rectangle(15, Rectangle.MAX_VAL);
		r5 = new Rectangle(15, 15);

	}

	@Test
	public void testRectangleInvalide()
	{
		try
		{
			new Rectangle(Rectangle.MIN_VAL - 1, 15);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Rectangle(Rectangle.MAX_VAL + 1, 15);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Rectangle(15, Rectangle.MIN_VAL - 1);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Rectangle(15, Rectangle.MAX_VAL + 1);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}

	}

	@Test
	public void testGetHauteur()
	{
		assertTrue(r1.getHauteur() == Rectangle.MIN_VAL);
		assertTrue(r2.getHauteur() == Rectangle.MAX_VAL);
		assertTrue(r3.getHauteur() == 15);
		assertTrue(r4.getHauteur() == 15);
		assertTrue(r5.getHauteur() == 15);
	}

	@Test
	public void testSetHauteur()
	{
		// Set réussi
		r1.setHauteur(Rectangle.MIN_VAL);
		assertTrue(r1.getHauteur() == Rectangle.MIN_VAL);
		r1.setHauteur(Rectangle.MAX_VAL);
		assertTrue(r1.getHauteur() == Rectangle.MAX_VAL);
		r1.setHauteur(Rectangle.MIN_VAL + 1);
		assertTrue(r1.getHauteur() == Rectangle.MIN_VAL + 1);
		r1.setHauteur(Rectangle.MAX_VAL - 1);
		assertTrue(r1.getHauteur() == Rectangle.MAX_VAL - 1);
		r1.setHauteur(15);
		assertTrue(r1.getHauteur() == 15);

		// Set échoués
		r1.setHauteur(Rectangle.MIN_VAL - 1);
		assertEquals(r1.getHauteur(), 15);
		r1.setHauteur(Rectangle.MAX_VAL + 1);
		assertEquals(r1.getHauteur(), 15);
		r1.setHauteur(40);
		assertEquals(r1.getHauteur(), 15);
	}

	@Test
	public void testGetLargeur()
	{
		assertTrue(r1.getLargeur() == 15);
		assertTrue(r2.getLargeur() == 15);
		assertTrue(r3.getLargeur() == Rectangle.MIN_VAL);
		assertTrue(r4.getLargeur() == Rectangle.MAX_VAL);
		assertTrue(r5.getLargeur() == 15);
	}

	@Test
	public void testSetLargeur()
	{
		// Set réussi
		r1.setLargeur(Rectangle.MIN_VAL);
		assertTrue(r1.getLargeur() == Rectangle.MIN_VAL);
		r1.setLargeur(Rectangle.MAX_VAL);
		assertTrue(r1.getLargeur() == Rectangle.MAX_VAL);
		r1.setLargeur(Rectangle.MIN_VAL + 1);
		assertTrue(r1.getLargeur() == Rectangle.MIN_VAL + 1);
		r1.setLargeur(Rectangle.MAX_VAL - 1);
		assertTrue(r1.getLargeur() == Rectangle.MAX_VAL - 1);
		r1.setLargeur(15);
		assertTrue(r1.getLargeur() == 15);

		// Set échoués
		r1.setLargeur(Rectangle.MIN_VAL - 1);
		assertEquals(r1.getLargeur(), 15);
		r1.setLargeur(Rectangle.MAX_VAL + 1);
		assertEquals(r1.getLargeur(), 15);
		r1.setLargeur(40);
		assertEquals(r1.getLargeur(), 15);
	}

	@Test
	public void testCalculerSurface()
	{
		for (int i = 0; i < 1000; i++)
		{
			int x = (int) (Math.random()
					* (Rectangle.MAX_VAL - Rectangle.MIN_VAL + 1)
					+ Rectangle.MIN_VAL);
			int y = (int) (Math.random()
					* (Rectangle.MAX_VAL - Rectangle.MIN_VAL + 1)
					+ Rectangle.MIN_VAL);
			r1.setLargeur(x);
			r1.setHauteur(y);
			assertEquals(r1.calculerSurface(), x * y);
		}
	}

	@Test
	public void testCalculerPerimetre()
	{
		for (int i = 0; i < 1000; i++)
		{
			int x = (int) (Math.random()
					* (Rectangle.MAX_VAL - Rectangle.MIN_VAL + 1)
					+ Rectangle.MIN_VAL);
			int y = (int) (Math.random()
					* (Rectangle.MAX_VAL - Rectangle.MIN_VAL + 1)
					+ Rectangle.MIN_VAL);
			r1.setLargeur(x);
			r1.setHauteur(y);
			assertEquals(r1.calculerPerimetre(), 2 * x + 2 * y);
		}
	}

	@Test
	public void testToString()
	{
		assertEquals(r1.toString(), "Rectangle rouge 1, 15");
		assertEquals(r2.toString(), "Rectangle rouge 30, 15");
		assertEquals(r3.toString(), "Rectangle rouge 15, 1");
		assertEquals(r4.toString(), "Rectangle rouge 15, 30");
		assertEquals(r5.toString(), "Rectangle rouge 15, 15");
	}

}
