package bridge;

import java.util.Random;

public class BridgeNumberGenerator {

	private static final Random random = new Random();

	public int generate() {
		return random.nextInt(2);
	}
}
