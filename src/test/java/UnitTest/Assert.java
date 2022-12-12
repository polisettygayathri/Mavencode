package UnitTest;

public class Assert {

	// TODO Auto-generated constructor stub
	public void AssertEqual(String actual, String expected) {

		// System.out.println(actual.equals(expected));

		if (actual.equals(expected)) {

			System.out.println("validation pass");

		} else {

			System.out.println("validation failed, actual value:" + actual);

		}

	}

	public void AssertEqual(String actual, String expected, String errorMessage) {

		if (actual.equals(expected)) {

			System.out.println("validation pass");

		} else {

			System.out.println("validation failed, actual value:" + actual);

			System.out.println("error message: " + errorMessage);

		}

	}
}
