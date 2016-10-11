package metacube.testng.utiltest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.metacube.testng.FrameworkHelper.Utilities;

public class utilitiesTest {

	
	@Test
	public void GivenTwoUniqueRandomStringsWhenComparedShouldFailedTheTest() {
		
		String expectedTitle =Utilities.getUniqueName("Metacube");
		String actualTitle =Utilities.getUniqueName("Metacube");
			Assert.assertEquals(actualTitle, expectedTitle);
			}
}
