package materialgdx.utilities;

public class Random {

	private static java.util.Random random = new java.util.Random();

	public static int randomInteger(int minimum, int maximum) {
		return random.nextInt(maximum + 1 - minimum) + minimum;
	}

	public static int randomInteger(int maximum) {
		return random.nextInt(maximum);
	}

	public static int randomInteger() {
		return random.nextInt();
	}

}