package test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import jeu.JeuMemoire;

public class JeuMemoireTest
{

	JeuMemoire j1;

	@Before
	public void testJeuMemoire()
	{
		j1 = new JeuMemoire();
	}

	@Test
	public void testToString()
	{
		//Test visuel
		System.out.println(j1.toString());
	}

	@Test
	public void testGetNiveau()
	{
		assertTrue(j1.getNiveau() == 1);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 2);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 3);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 4);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 5);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 6);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 6);
	}

	@Test
	public void testSetNiveauPlusUn()
	{
		assertTrue(j1.getNiveau() == 1);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 2);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 3);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 4);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 5);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 6);
		j1.setNiveauPlusUn();
		assertTrue(j1.getNiveau() == 6);
	}

	@Test
	public void testJouerOrdi()
	{
		ArrayList<Point> points = new ArrayList<Point>();

		// Niveau 1
		points = j1.jouerOrdi();
		assertTrue(points.size() == 3);
		assertEquals(points.get(0).equals(points.get(1)), false);
		assertEquals(points.get(0).equals(points.get(2)), false);
		assertEquals(points.get(1).equals(points.get(2)), false);

		// Niveau 2
		j1.setNiveauPlusUn();
		points = j1.jouerOrdi();
		assertTrue(points.size() == 4);
		assertEquals(points.get(0).equals(points.get(1)), false);
		assertEquals(points.get(0).equals(points.get(2)), false);
		assertEquals(points.get(0).equals(points.get(3)), false);
		assertEquals(points.get(1).equals(points.get(2)), false);
		assertEquals(points.get(1).equals(points.get(3)), false);
		assertEquals(points.get(2).equals(points.get(3)), false);

		// Niveau 3
		j1.setNiveauPlusUn();
		points = j1.jouerOrdi();
		assertTrue(points.size() == 5);
		assertEquals(points.get(0).equals(points.get(1)), false);
		assertEquals(points.get(0).equals(points.get(2)), false);
		assertEquals(points.get(0).equals(points.get(3)), false);
		assertEquals(points.get(0).equals(points.get(4)), false);
		assertEquals(points.get(1).equals(points.get(2)), false);
		assertEquals(points.get(1).equals(points.get(3)), false);
		assertEquals(points.get(1).equals(points.get(4)), false);
		assertEquals(points.get(2).equals(points.get(3)), false);
		assertEquals(points.get(2).equals(points.get(4)), false);
		assertEquals(points.get(3).equals(points.get(4)), false);

		// Niveau 4
		j1.setNiveauPlusUn();
		points = j1.jouerOrdi();
		assertTrue(points.size() == 6);
		assertEquals(points.get(0).equals(points.get(1)), false);
		assertEquals(points.get(0).equals(points.get(2)), false);
		assertEquals(points.get(0).equals(points.get(3)), false);
		assertEquals(points.get(0).equals(points.get(4)), false);
		assertEquals(points.get(0).equals(points.get(5)), false);
		assertEquals(points.get(1).equals(points.get(2)), false);
		assertEquals(points.get(1).equals(points.get(3)), false);
		assertEquals(points.get(1).equals(points.get(4)), false);
		assertEquals(points.get(1).equals(points.get(5)), false);
		assertEquals(points.get(2).equals(points.get(3)), false);
		assertEquals(points.get(2).equals(points.get(4)), false);
		assertEquals(points.get(2).equals(points.get(5)), false);
		assertEquals(points.get(3).equals(points.get(4)), false);
		assertEquals(points.get(3).equals(points.get(5)), false);
		assertEquals(points.get(4).equals(points.get(5)), false);

		// Niveau 5
		j1.setNiveauPlusUn();
		points = j1.jouerOrdi();
		assertTrue(points.size() == 7);
		assertEquals(points.get(0).equals(points.get(1)), false);
		assertEquals(points.get(0).equals(points.get(2)), false);
		assertEquals(points.get(0).equals(points.get(3)), false);
		assertEquals(points.get(0).equals(points.get(4)), false);
		assertEquals(points.get(0).equals(points.get(5)), false);
		assertEquals(points.get(0).equals(points.get(6)), false);
		assertEquals(points.get(1).equals(points.get(2)), false);
		assertEquals(points.get(1).equals(points.get(3)), false);
		assertEquals(points.get(1).equals(points.get(4)), false);
		assertEquals(points.get(1).equals(points.get(5)), false);
		assertEquals(points.get(1).equals(points.get(6)), false);
		assertEquals(points.get(2).equals(points.get(3)), false);
		assertEquals(points.get(2).equals(points.get(4)), false);
		assertEquals(points.get(2).equals(points.get(5)), false);
		assertEquals(points.get(2).equals(points.get(6)), false);
		assertEquals(points.get(3).equals(points.get(4)), false);
		assertEquals(points.get(3).equals(points.get(5)), false);
		assertEquals(points.get(3).equals(points.get(6)), false);
		assertEquals(points.get(4).equals(points.get(5)), false);
		assertEquals(points.get(4).equals(points.get(6)), false);
		assertEquals(points.get(5).equals(points.get(6)), false);

		// Niveau 6
		j1.setNiveauPlusUn();
		points = j1.jouerOrdi();
		assertTrue(points.size() == 8);
		assertEquals(points.get(0).equals(points.get(1)), false);
		assertEquals(points.get(0).equals(points.get(2)), false);
		assertEquals(points.get(0).equals(points.get(3)), false);
		assertEquals(points.get(0).equals(points.get(4)), false);
		assertEquals(points.get(0).equals(points.get(5)), false);
		assertEquals(points.get(0).equals(points.get(6)), false);
		assertEquals(points.get(0).equals(points.get(7)), false);
		assertEquals(points.get(1).equals(points.get(2)), false);
		assertEquals(points.get(1).equals(points.get(3)), false);
		assertEquals(points.get(1).equals(points.get(4)), false);
		assertEquals(points.get(1).equals(points.get(5)), false);
		assertEquals(points.get(1).equals(points.get(6)), false);
		assertEquals(points.get(1).equals(points.get(7)), false);
		assertEquals(points.get(2).equals(points.get(3)), false);
		assertEquals(points.get(2).equals(points.get(4)), false);
		assertEquals(points.get(2).equals(points.get(5)), false);
		assertEquals(points.get(2).equals(points.get(6)), false);
		assertEquals(points.get(2).equals(points.get(7)), false);
		assertEquals(points.get(3).equals(points.get(4)), false);
		assertEquals(points.get(3).equals(points.get(5)), false);
		assertEquals(points.get(3).equals(points.get(6)), false);
		assertEquals(points.get(3).equals(points.get(7)), false);
		assertEquals(points.get(4).equals(points.get(5)), false);
		assertEquals(points.get(4).equals(points.get(6)), false);
		assertEquals(points.get(4).equals(points.get(7)), false);
		assertEquals(points.get(5).equals(points.get(6)), false);
		assertEquals(points.get(5).equals(points.get(7)), false);
		assertEquals(points.get(6).equals(points.get(7)), false);
	}

	@Test
	public void testJouerHumain()
	{
		ArrayList<Point> points = new ArrayList<Point>();
		points = j1.jouerOrdi();

		int x = (int) (points.get(0).getX());
		int y = (int) (points.get(0).getY());
		assertEquals(j1.jouerHumain(x, y), true);

		x = (int) (points.get(0).getX());
		y = (int) (points.get(0).getY());
		assertEquals(j1.jouerHumain(x, y), true);

		x = (int) (points.get(0).getX());
		y = (int) (points.get(0).getY());
		assertEquals(j1.jouerHumain(x, y), true);

	}

	@Test
	public void testGetNomForme()
	{
		for (int i = 0; i < JeuMemoire.LIGNE; i++)
		{
			for (int j = 0; j < JeuMemoire.COLONNE; j++)
			{
				assertEquals(j1.getNomForme(i, j),
						j1.getGrille()[i][j].getNom() + j1.getGrille()[i][j].getCouleur());
			}
		}
	}

	@Test
	public void testGetVecteur()
	{
		assertTrue(j1.getVecteur().getVecteur().size() == 36);
	}

	@Test
	public void testGetGrille()
	{
		assertEquals(j1.getGrille().length, 6);
	}

}
