package bridge.model;

import static bridge.model.BridgeGameStatus.CONTINUE;
import static bridge.model.BridgeGameStatus.FAIL;
import static bridge.model.BridgeGameStatus.SUCCESS;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

public class BridgeGameAnswer {

	private final List<BridgeMoveType> bridgeAnswer;

	public BridgeGameAnswer() {
		this.bridgeAnswer = new ArrayList<>();
	}

	public void setUpAnswer(int bridgeSize) {
		new BridgeMaker(new BridgeNumberGenerator())
				.makeBridge(bridgeSize)
				.stream()
				.map(BridgeMoveType::of)
				.forEach(bridgeAnswer::add);
	}

	public BridgeGameStatus compareWith(BridgeGamePlayer bridgeGamePlayer) {
		if (bridgeGamePlayer.compareMoveType(bridgeAnswer)) {
			return FAIL;
		}
		if (bridgeGamePlayer.isReached(bridgeAnswer)) {
			return SUCCESS;
		}
		return CONTINUE;
	}
}
