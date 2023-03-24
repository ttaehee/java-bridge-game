package bridge.model;

import static bridge.exception.ExceptionMessage.WRONG_BRIDGE_GAME_END_TYPE_EXCEPTION;

import java.util.Arrays;

public enum BridgeGameEndType {
	END("Q"),
	RESTART("R");

	private final String type;

	BridgeGameEndType(String type) {
		this.type = type;
	}

	public static BridgeGameEndType of(String endType) {
		return Arrays.stream(BridgeGameEndType.values())
				.filter(gameEndType -> gameEndType.type.equals(endType))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(WRONG_BRIDGE_GAME_END_TYPE_EXCEPTION.getMessage()));
	}

	public boolean isEnd() {
		return this == END;
	}

	public boolean isRestart() {
		return this == RESTART;
	}
}
