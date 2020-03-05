package test;

import static org.junit.Assert.*;

import org.junit.*;
import exceptions.FormeException;
import formes.*;

//Étienne Beaulieu et Zacharie Forest
public class TriangleTest
{
	private Triangle t1, t2, t3, t4, t5, t6;

	@Before
	public void testTriangle() throws FormeException
	{
		t1 = new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL);
		t2 = new Triangle(15, 15, 15);
		t3 = new Triangle(Forme.MAX_VAL, Forme.MAX_VAL, Forme.MAX_VAL);
		t4 = new Triangle(15, 15, 10);
		t5 = new Triangle(3, 4, 5);
		t6 = new Triangle(3, 4, 6);

	}

	@Test
	public void testTriangleInvalide()
	{
		try
		{
			new Triangle(Forme.MIN_VAL - 1, 15, 15);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Triangle(15, Forme.MIN_VAL - 1, 15);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Triangle(15, 15, Forme.MIN_VAL - 1);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Triangle(Forme.MAX_VAL + 1, 15, 15);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Triangle(15, Forme.MAX_VAL + 1, 15);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Triangle(15, 15, Forme.MAX_VAL + 1);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
		try
		{
			new Triangle(1, 1, 29);
			fail("Constructeur invalide");
		}
		catch (FormeException e)
		{
		}
	}

	@Test
	public void testCalculerSurface() throws FormeException
	{
		for (int i = 0; i < 1000; i++)
		{
			int x = (int) (Math.random() * (Forme.MAX_VAL - Forme.MIN_VAL + 1)
					+ Forme.MIN_VAL);
			int y = (int) (Math.random() * (Forme.MAX_VAL - Forme.MIN_VAL + 1)
					+ Forme.MIN_VAL);
			int z = (int) (Math.random() * (Forme.MAX_VAL - Forme.MIN_VAL + 1)
					+ Forme.MIN_VAL);
			if (x < y + z && y < x + z && z < x + y)
			{
				t1 = new Triangle(x, y, z);
				assertEquals(t1.calculerSurface(),
						(int) (Math.sqrt((x + y + z) / 2 * ((x + y + z) / 2 - x)
								* ((x + y + z) / 2 - y)
								* ((x + y + z) / 2 - z))));
			}
		}
	}

	@Test
	public void testCalculerPerimetre() throws FormeException
	{
		for (int i = 0; i < 1000; i++)
		{
			int x = (int) (Math.random() * (Forme.MAX_VAL - Forme.MIN_VAL + 1)
					+ Forme.MIN_VAL);
			int y = (int) (Math.random() * (Forme.MAX_VAL - Forme.MIN_VAL + 1)
					+ Forme.MIN_VAL);
			int z = (int) (Math.random() * (Forme.MAX_VAL - Forme.MIN_VAL + 1)
					+ Forme.MIN_VAL);
			if (x < y + z && y < x + z && z < x + y)
			{
				t1 = new Triangle(x, y, z);
				assertEquals(t1.calculerPerimetre(), x + y + z);
			}
		}
	}

	@Test
	public void testToString()
	{
		assertEquals(t1.toString(), "Triangle rouge équilatéral 1, 1, 1");
		assertEquals(t2.toString(), "Triangle rouge équilatéral 15, 15, 15");
		assertEquals(t3.toString(), "Triangle rouge équilatéral 30, 30, 30");
		assertEquals(t4.toString(), "Triangle rouge isocèle 10, 15, 15");
		assertEquals(t5.toString(), "Triangle rouge rectangle 3, 4, 5");
		assertEquals(t6.toString(), "Triangle rouge scalène 3, 4, 6");

	}

	@Test
	public void testGetCoteA()
	{
		assertTrue(t1.getCoteA() == 1);
		assertTrue(t2.getCoteA() == 15);
		assertTrue(t3.getCoteA() == 30);
		assertTrue(t4.getCoteA() == 15);
		assertTrue(t5.getCoteA() == 3);
		assertTrue(t6.getCoteA() == 3);

	}

	@Test
	public void testGetCoteB()
	{
		assertTrue(t1.getCoteB() == 1);
		assertTrue(t2.getCoteB() == 15);
		assertTrue(t3.getCoteB() == 30);
		assertTrue(t4.getCoteB() == 15);
		assertTrue(t5.getCoteB() == 4);
		assertTrue(t6.getCoteB() == 4);
	}

	@Test
	public void testGetCoteC()
	{
		assertTrue(t1.getCoteC() == 1);
		assertTrue(t2.getCoteC() == 15);
		assertTrue(t3.getCoteC() == 30);
		assertTrue(t4.getCoteC() == 10);
		assertTrue(t5.getCoteC() == 5);
		assertTrue(t6.getCoteC() == 6);
	}

	@Test
	public void testGetType()
	{
		assertEquals(t1.getType(), TypeTriangle.EQUILATERAL);
		assertEquals(t2.getType(), TypeTriangle.EQUILATERAL);
		assertEquals(t3.getType(), TypeTriangle.EQUILATERAL);
		assertEquals(t4.getType(), TypeTriangle.ISOCELE);
		assertEquals(t5.getType(), TypeTriangle.RECTANGLE);
		assertEquals(t6.getType(), TypeTriangle.SCALENE);
	}

}
