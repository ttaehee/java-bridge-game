package bridge.io;

import static bridge.exception.ExceptionMessage.BRIDGE_SIZE_NOT_DIGIT_EXCEPTION;
import static bridge.exception.ExceptionMessage.BRIDGE_SIZE_RANGE_OVER_EXCEPTION;

import java.util.Scanner;

import bridge.model.BridgeGameEndType;
import bridge.model.BridgeMoveType;

public class InputView {

	private final Scanner scanner = new Scanner(System.in);

	public int readBridgeSize() {
		String input = scanner.nextLine();
		validateDigit(input);
		int bridgeSize = Integer.parseInt(input);
		checkSizeRange(bridgeSize);
		return bridgeSize;
	}

	public BridgeMoveType readMoving() {
		String direction = scanner.nextLine();
		return BridgeMoveType.of(direction);
	}

	public BridgeGameEndType readGameEndCommand() {
		String readGameEndType = scanner.nextLine();
		return BridgeGameEndType.of(readGameEndType);
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
