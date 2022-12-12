package UnitTest;

public class AssertExample {
	public static void AssertEqual(String actual, String expected) {

		// System.out.println(actual.equals(expected));

		if (actual.equals(expected)) {

			System.out.println("validation pass");

		} else {

			System.out.println("validation failed, actual value:" + actual);

		}

	}

	public static void AssertEqual(String actual, String expected, String errorMessage) {

		if (actual.equals(expected)) {

			System.out.println("validation pass");

		} else {

			System.out.println("validation failed, actual value:" + actual);

			System.out.println("error message: " + errorMessage);

		}

	}

}
