package bridge.model;

import static bridge.exception.ExceptionMessage.WRONG_BRIDGE_TYPE_EXCEPTION;

import java.util.Arrays;

public enum BridgeMoveType {
	UP(0, "U"),
	DOWN(1, "D");

	private final int code;
	private final String direction;

	BridgeMoveType(int code, String direction) {
		this.code = code;
		this.direction = direction;
	}

	public int getCode() {
		return code;
	}

	public String getDirection() {
		return direction;
	}

	public static String of(int bridgeCode) {
		return Arrays.stream(BridgeMoveType.values())
				.filter(bridge -> bridge.code == bridgeCode)
				.findFirst()
				.orElseThrow(()-> new IllegalArgumentException(WRONG_BRIDGE_TYPE_EXCEPTION.getMessage()))
				.direction;
	}

	public static BridgeMoveType of(String bridgeDirection) {
		return Arrays.stream(BridgeMoveType.values())
				.filter(bridge -> bridge.direction.equals(bridgeDirection))
				.findFirst()
				.orElseThrow(()-> new IllegalArgumentException(WRONG_BRIDGE_TYPE_EXCEPTION.getMessage()));
	}
}
