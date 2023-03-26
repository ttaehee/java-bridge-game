package bridge;

import bridge.model.BridgeGameAnswer;
import bridge.model.BridgeGameHistory;
import bridge.model.BridgeGameRound;
import bridge.model.BridgeGamePlayer;
import bridge.model.BridgeGameStatus;
import bridge.model.BridgeMoveType;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final BridgeGameRound bridgeRound;
	private final BridgeGamePlayer bridgeGamePlayer;
	private final BridgeGameAnswer bridgeGameAnswer;

	public BridgeGame(BridgeGameRound bridgeGameRound, BridgeGamePlayer bridgeGamePlayer, BridgeGameAnswer bridgeGameAnswer) {
		this.bridgeRound = bridgeGameRound;
		this.bridgeGamePlayer = bridgeGamePlayer;
		this.bridgeGameAnswer = bridgeGameAnswer;
	}

	public void startGame(int bridgeSize) {
		bridgeGameAnswer.setUpAnswer(bridgeSize);
	}

	public BridgeGameStatus moveAndCheckAnswer(BridgeMoveType bridgeMoveType) {
		bridgeGamePlayer.move(bridgeMoveType);
		return bridgeGameAnswer.compareWith(bridgeGamePlayer);
	}

	public BridgeGameHistory getHistory() {
		return new BridgeGameHistory(bridgeGamePlayer, bridgeGameAnswer, bridgeRound);
	}
}
