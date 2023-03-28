package bridge.model;

public enum BridgeGameStatus {
	START("시작"),
	CONTINUE("진행 중"),
	SUCCESS("성공"),
	FAIL("실패");

	private final String status;

	BridgeGameStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public boolean isContinue() {
		return this == CONTINUE;
	}

	public boolean isSuccess() {
		return this == SUCCESS;
	}

	public boolean isFail() {
		return this == FAIL;
	}

	public boolean isGaming() {
		return this == START || this == CONTINUE;
	}

	public boolean isEnd() {
		return this == SUCCESS || this == FAIL;
	}
}
