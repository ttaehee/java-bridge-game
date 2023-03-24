package bridge.exception;

public enum ExceptionMessage {
	BRIDGE_SIZE_NOT_DIGIT_EXCEPTION("다리 길이의 입력값은 숫자여야 합니다."),
	BRIDGE_SIZE_RANGE_OVER_EXCEPTION("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
	WRONG_BRIDGE_TYPE_EXCEPTION("잘못된 다리 칸 입력입니다.");

	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
