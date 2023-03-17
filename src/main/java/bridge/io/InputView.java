package bridge.io;

import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다
 */
public class InputView {

	private final Scanner scanner = new Scanner(System.in);

	/**
	 * 다리의 길이를 입력받는다
	 */
	public int readBridgeSize() {
		return scanner.nextInt();
	}
}
