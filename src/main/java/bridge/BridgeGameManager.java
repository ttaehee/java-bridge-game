package bridge;

import bridge.io.InputView;
import bridge.io.OutputView;

public class BridgeGameManager {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private final BridgeGame bridgeGame;

	public BridgeGameManager(BridgeGame bridgeGame) {
		this.bridgeGame = bridgeGame;
	}

	private int getBridgeSize() {
		while (true) {
			try {
				outputView.printStartMessage();
				return inputView.readBridgeSize();
			} catch (IllegalArgumentException e) {
				outputView.printException(e.getMessage());
			}
		}
	}
}
