package UnitTest;

import org.testng.annotations.Test;

public class TestAssert {
	@Test
	public void verifyAssert() {

		String actualTitle = "iphone 14: amazon";

		String expectedTitle = "iphone 14 pro: amazon";

		AssertExample.AssertEqual(actualTitle, expectedTitle);
	}

}
