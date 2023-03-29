package bridge;

import bridge.model.BridgeGameAnswer;
import bridge.model.BridgeGamePlayer;

public class Application {
	public static void main(String[] args) {
		BridgeGamePlayer bridgePlayer = new BridgeGamePlayer();
		BridgeGameAnswer bridgeAnswer = new BridgeGameAnswer();
		BridgeGame bridgeGame = new BridgeGame(bridgePlayer, bridgeAnswer);

		BridgeGameManager bridgeGameManager = new BridgeGameManager(bridgeGame);
		bridgeGameManager.playGame();
	}
}
