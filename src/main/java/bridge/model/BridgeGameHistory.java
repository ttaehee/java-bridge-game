package bridge.model;

import java.util.List;

public class BridgeGameHistory {

	private final BridgeGamePlayer playerBridgeHistory;
	private final BridgeGameAnswer bridgeGameAnswer;
	private final BridgeGameRound bridgeGameRound;

	public BridgeGameHistory(BridgeGamePlayer playerBridgeHistory, BridgeGameAnswer bridgeGameAnswer, BridgeGameRound bridgeGameRound) {
		this.playerBridgeHistory = playerBridgeHistory;
		this.bridgeGameAnswer = bridgeGameAnswer;
		this.bridgeGameRound = bridgeGameRound;
	}

	public List<BridgeMoveType> getPlayerRoute() {
		return playerBridgeHistory.getMoveHistory();
	}

	public List<BridgeMoveType> getBridgeGameAnswer() {
		return bridgeGameAnswer.getBridgeGameAnswer();
	}
}
