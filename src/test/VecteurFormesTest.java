package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import exceptions.FormeException;
import formes.*;

//Étienne Beaulieu et Zacharie Forest
public class VecteurFormesTest
{
	VecteurFormes v1, v2;

	@Before
	public void testVecteurFormes() throws FormeException
	{
		v1 = new VecteurFormes();
		v2 = new VecteurFormes();
		v2.remplir(36);
	}

	@Test
	public void testRemplir() throws FormeException
	{
		v1.remplir(36);
		int rectangle = 0;
		int triangle = 0;
		int cercle = 0;
		int rouge = 0;
		int vert = 0;
		int bleu = 0;
		int jaune = 0;
		int noir = 0;
		int orange = 0;
		for (Forme f : v1.getVecteur())
		{
			switch (f.getNom())
			{
				case ("Rectangle"):
					rectangle++;
					break;
				case ("Triangle"):
					triangle++;
					break;
				case ("Cercle"):
					cercle++;
			}
			switch (f.getCouleur().getNom())
			{
				case ("rouge"):
					rouge++;
					break;
				case ("vert"):
					vert++;
					break;
				case ("bleu"):
					bleu++;
					break;
				case ("jaune"):
					jaune++;
					break;
				case ("noir"):
					noir++;
					break;
				case ("orange"):
					orange++;
					break;
			}

		}
		assertEquals(v1.getVecteur().size(), 36);
		assertEquals(rectangle, 12);
		assertEquals(triangle, 12);
		assertEquals(cercle, 12);
		assertEquals(rouge, 6);
		assertEquals(vert, 6);
		assertEquals(bleu, 6);
		assertEquals(jaune, 6);
		assertEquals(noir, 6);
		assertEquals(orange, 6);
		

		v1.getVecteur().clear();
		v1.remplir(16);
		 rectangle = 0;
		 triangle = 0;
		 cercle = 0;
		 rouge = 0;
		 vert = 0;
		 bleu = 0;
		 jaune = 0;
		 noir = 0;
		 orange = 0;
		for (Forme f : v1.getVecteur())
		{
			switch (f.getNom())
			{
				case ("Rectangle"):
					rectangle++;
					break;
				case ("Triangle"):
					triangle++;
					break;
				case ("Cercle"):
					cercle++;
			}
			switch (f.getCouleur().getNom())
			{
				case ("rouge"):
					rouge++;
					break;
				case ("vert"):
					vert++;
					break;
				case ("bleu"):
					bleu++;
					break;
				case ("jaune"):
					jaune++;
					break;
				case ("noir"):
					noir++;
					break;
				case ("orange"):
					orange++;
					break;
			}

		}
		assertEquals(v1.getVecteur().size(), 16);
		assertEquals(rectangle, 5);
		assertEquals(triangle, 5);
		assertEquals(cercle, 6);
		assertEquals(rouge, 3);
		assertEquals(vert, 3);
		assertEquals(bleu, 3);
		assertEquals(jaune, 3);
		assertEquals(noir, 3);
		assertEquals(orange, 1);
		
		
		v1.getVecteur().clear();
		v1.remplir(-2);
		rectangle = 0;
		 triangle = 0;
		 cercle = 0;
		 rouge = 0;
		 vert = 0;
		 bleu = 0;
		 jaune = 0;
		 noir = 0;
		 orange = 0;
		for (Forme f : v1.getVecteur())
		{
			switch (f.getNom())
			{
				case ("Rectangle"):
					rectangle++;
					break;
				case ("Triangle"):
					triangle++;
					break;
				case ("Cercle"):
					cercle++;
			}
			switch (f.getCouleur().getNom())
			{
				case ("rouge"):
					rouge++;
					break;
				case ("vert"):
					vert++;
					break;
				case ("bleu"):
					bleu++;
					break;
				case ("jaune"):
					jaune++;
					break;
				case ("noir"):
					noir++;
					break;
				case ("orange"):
					orange++;
					break;
			}

		}
		assertEquals(v1.getVecteur().size(), 0);
		assertEquals(rectangle, 0);
		assertEquals(triangle, 0);
		assertEquals(cercle, 0);
		assertEquals(rouge, 0);
		assertEquals(vert, 0);
		assertEquals(bleu, 0);
		assertEquals(jaune, 0);
		assertEquals(noir, 0);
		assertEquals(orange, 0);
		
		v1.getVecteur().clear();
		v1.remplir(216);
		rectangle = 0;
		 triangle = 0;
		 cercle = 0;
		 rouge = 0;
		 vert = 0;
		 bleu = 0;
		 jaune = 0;
		 noir = 0;
		 orange = 0;
		for (Forme f : v1.getVecteur())
		{
			switch (f.getNom())
			{
				case ("Rectangle"):
					rectangle++;
					break;
				case ("Triangle"):
					triangle++;
					break;
				case ("Cercle"):
					cercle++;
			}
			switch (f.getCouleur().getNom())
			{
				case ("rouge"):
					rouge++;
					break;
				case ("vert"):
					vert++;
					break;
				case ("bleu"):
					bleu++;
					break;
				case ("jaune"):
					jaune++;
					break;
				case ("noir"):
					noir++;
					break;
				case ("orange"):
					orange++;
					break;
			}

		}
		assertEquals(v1.getVecteur().size(), 216);
		assertEquals(rectangle, 72);
		assertEquals(triangle, 72);
		assertEquals(cercle, 72);
		assertEquals(rouge, 36);
		assertEquals(vert, 36);
		assertEquals(bleu, 36);
		assertEquals(jaune, 36);
		assertEquals(noir, 36);
		assertEquals(orange, 36);
	}

	@Test
	public void testGetVecteur()
	{
		assertTrue(v2.getVecteur().size() == 36);
	}

	@Test
	public void testToString()
	{
		for (Forme f : v2.getVecteur())
		{
			assertFalse(v2.toString().indexOf(f.toStringCourt()) == -1);
		}
	}

	@Test
	public void testTrier()
	{
		v2.trier();
		for (int i = 0; i < v2.getVecteur().size() - 1; i++)
		{
			assertTrue(v2.getVecteur().get(i).toStringCourt().compareTo(
					v2.getVecteur().get(i + 1).toStringCourt()) <= 0);
		}
	}

	@Test
	public void testMelanger() throws FormeException
	{
		v2.melanger();
		v1.remplir(36);

		assertFalse(v2.toString().equals(v1.toString()));

	}

}
