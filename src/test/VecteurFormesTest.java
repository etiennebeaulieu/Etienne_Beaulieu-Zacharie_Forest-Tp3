package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import exceptions.FormeException;
import formes.*;

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
		assertTrue(v1.getVecteur().size() == 36);
	}

	@Test
	public void testGetVecteur()
	{
		assertTrue(v1.getVecteur().size() == 36);
	}

	@Test
	public void testToString()
	{
		for(Forme f: v2.getVecteur())
		{
			assertFalse(v2.toString().indexOf(f.toStringCourt()) == -1);
		}
	}

	@Test
	public void testTrier()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testMelanger()
	{
		fail("Not yet implemented");
	}

}
