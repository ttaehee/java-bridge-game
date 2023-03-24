package bridge.model;

public enum BridgeGameStatus {
	START,
	CONTINUE,
	WIN,
	LOSE;

	public boolean isContinue() {
		return this == CONTINUE;
	}

	public boolean isWin() {
		return this == WIN;
	}

	public boolean isLose() {
		return this == LOSE;
	}

	public boolean isGaming() {
		return this == START || this == CONTINUE;
	}

	public boolean isEnd() {
		return this == WIN || this == LOSE;
	}
}
