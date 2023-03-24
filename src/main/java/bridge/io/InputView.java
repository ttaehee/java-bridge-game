package bridge.io;

import static bridge.exception.ExceptionMessage.BRIDGE_SIZE_NOT_DIGIT_EXCEPTION;
import static bridge.exception.ExceptionMessage.BRIDGE_SIZE_RANGE_OVER_EXCEPTION;

import java.util.Scanner;

import bridge.model.BridgeMoveType;

/**
 * 사용자로부터 입력을 받는 역할을 한다
 */
public class InputView {

	private final Scanner scanner = new Scanner(System.in);

	/**
	 * 다리의 길이를 입력받는다
	 */
	public int readBridgeSize() {
		String input = scanner.nextLine();
		validateDigit(input);
		int bridgeSize = Integer.parseInt(input);
		checkSizeRange(bridgeSize);
		return scanner.nextInt();
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public BridgeMoveType readMoving() {
		String direction = scanner.nextLine();
		return BridgeMoveType.of(direction);
	}

	private void validateDigit(String input) {
		if (!input.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(BRIDGE_SIZE_NOT_DIGIT_EXCEPTION.getMessage());
		}
	}

	private void checkSizeRange(int bridgeSize) {
		if (bridgeSize < 3 || bridgeSize > 20) {
			throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_OVER_EXCEPTION.getMessage());
		}
	}
}
