package tests_conformites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ CouleurConformeTest.class, TypeTriangleConformeTest.class,
		FormeConformeTest.class, CercleConformeTest.class,
		RectangleConformeTest.class, TriangleConformeTest.class })
public class AllTestsConformites
{

}
