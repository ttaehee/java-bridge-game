package bridge.io;

public enum GameUnitMessage {
	LEFT_BRACKET("[ "),
	RIGHT_BRACKET(" ]"),
	VERTICAL_BAR(" | "),
	SPACING_EXPRESSION(" "),
	CORRECT_EXPRESSION("O"),
	NOT_CORRECT_EXPRESSION("X"),
	ENTER("\n");

	private final String unit;

	GameUnitMessage(String unit) {
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}
}
