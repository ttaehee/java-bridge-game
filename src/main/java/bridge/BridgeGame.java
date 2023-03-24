package bridge;

import bridge.model.BridgeGameAnswer;
import bridge.model.BridgeGameRound;
import bridge.model.BridgeGamePlayer;

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
}
