package bridge.model;

public enum BridgeGameStatus {
	START,
	CONTINUE,
	SUCCESS,
	FAIL;

	public boolean isContinue() {
		return this == CONTINUE;
	}

	public boolean isWin() {
		return this == SUCCESS;
	}

	public boolean isLose() {
		return this == FAIL;
	}

	public boolean isGaming() {
		return this == START || this == CONTINUE;
	}

	public boolean isEnd() {
		return this == SUCCESS || this == FAIL;
	}
}
