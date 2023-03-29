package bridge;

import static bridge.model.BridgeGameStatus.FAIL;
import static bridge.model.BridgeGameStatus.START;
import static bridge.model.BridgeGameStatus.SUCCESS;

import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.model.BridgeGameEndType;
import bridge.model.BridgeGameStatus;
import bridge.model.BridgeMoveType;

public class BridgeGameManager {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private final BridgeGame bridgeGame;

	public BridgeGameManager(BridgeGame bridgeGame) {
		this.bridgeGame = bridgeGame;
	}

	public void playGame() {
		bridgeGame.startGame(getBridgeSize());
		BridgeGameStatus bridgeGameStatus = START;

		while (bridgeGameStatus.isGaming()) {
			bridgeGameStatus = handlePlayerMove();
			outputView.printMap(bridgeGame.getHistory());
			bridgeGameStatus = checkGameStatus(bridgeGameStatus);
		}

		outputView.printResult(bridgeGame.getHistory());
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

	private BridgeGameStatus handlePlayerMove() {
		while (true) {
			try {
				return bridgeGame.moveAndCheckAnswer(getMoveType());
			} catch (IllegalArgumentException e) {
				outputView.printException(e.getMessage());
			}
		}
	}

	private BridgeMoveType getMoveType() {
		while (true) {
			try {
				outputView.printMoveMessage();
				return inputView.readMoving();
			} catch (IllegalArgumentException e) {
				outputView.printException(e.getMessage());
			}
		}
	}

	private BridgeGameStatus checkGameStatus(BridgeGameStatus bridgeGameStatus) {
		if (bridgeGameStatus.isSuccess()) {
			return SUCCESS;
		}

		if (bridgeGameStatus.isFail()) {
			return checkGameEndType();
		}

		return bridgeGameStatus;
	}

	private BridgeGameStatus checkGameEndType() {
		BridgeGameEndType bridgeGameEndType = getGameEndCommand();

		if (bridgeGameEndType.isEnd()) {
			return FAIL;
		}

		bridgeGame.retry();
		return START;
	}

	private BridgeGameEndType getGameEndCommand() {
		while (true) {
			try {
				outputView.printGameEndCommandMessage();
				return inputView.readGameEndCommand();
			} catch (IllegalArgumentException e) {
				outputView.printException(e.getMessage());
			}
		}
	}
}
