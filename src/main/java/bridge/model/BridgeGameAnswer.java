package bridge.model;

import static bridge.model.BridgeGameStatus.CONTINUE;
import static bridge.model.BridgeGameStatus.FAIL;
import static bridge.model.BridgeGameStatus.SUCCESS;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

public class BridgeGameAnswer {

	private final List<BridgeMoveType> bridgeGameAnswer;

	public BridgeGameAnswer() {
		this.bridgeGameAnswer = new ArrayList<>();
	}

	public void setUpAnswer(int bridgeSize) {
		new BridgeMaker(new BridgeNumberGenerator())
				.makeBridge(bridgeSize)
				.stream()
				.map(BridgeMoveType::of)
				.forEach(bridgeGameAnswer::add);
	}

	public BridgeGameStatus compareWith(BridgeGamePlayer bridgeGamePlayer) {
		if (bridgeGamePlayer.compareMoveType(bridgeGameAnswer)) {
			return FAIL;
		}
		if (bridgeGamePlayer.isReached(bridgeGameAnswer)) {
			return SUCCESS;
		}
		return CONTINUE;
	}

	public List<BridgeMoveType> getBridgeGameAnswer() {
		return new ArrayList<>(bridgeGameAnswer);
	}
}
