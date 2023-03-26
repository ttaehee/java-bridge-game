package bridge.model;

import java.util.List;

public class BridgeGameHistory {

	private final BridgeGamePlayer bridgeGamePlayer;
	private final BridgeGameAnswer bridgeGameAnswer;
	private final BridgeGameRound bridgeGameRound;

	public BridgeGameHistory(BridgeGamePlayer bridgeGamePlayer, BridgeGameAnswer bridgeGameAnswer, BridgeGameRound bridgeGameRound) {
		this.bridgeGamePlayer = bridgeGamePlayer;
		this.bridgeGameAnswer = bridgeGameAnswer;
		this.bridgeGameRound = bridgeGameRound;
	}

	public List<BridgeMoveType> getPlayerRoute() {
		return bridgeGamePlayer.getMoveHistory();
	}

	public List<BridgeMoveType> getGameAnswer() {
		return bridgeGameAnswer.getBridgeGameAnswer();
	}

	public BridgeGameStatus getGameResult() {
		return bridgeGameAnswer.compareWith(bridgeGamePlayer);
	}

	public int getGameRound() {
		return bridgeGameRound.getRound();
	}
}
