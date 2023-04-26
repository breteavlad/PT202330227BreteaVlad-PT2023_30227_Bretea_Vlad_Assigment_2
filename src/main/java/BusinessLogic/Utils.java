package BusinessLogic;

import java.util.Random;

public class Utils {

	private static Random random = new Random();

	private Utils() {
	}

	public static long getCurrentTime() {
		return System.currentTimeMillis();
	}

	public static int getRandomInt(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}
}
