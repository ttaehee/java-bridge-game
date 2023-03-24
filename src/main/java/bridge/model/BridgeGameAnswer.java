package bridge.model;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;

public class BridgeGameAnswer {

	private final List<BridgeMoveType> bridgeAnswer;

	public BridgeGameAnswer(List<BridgeMoveType> bridgeAnswer) {
		this.bridgeAnswer = bridgeAnswer;
	}

	public void setUpAnswer(int bridgeSize) {
		new BridgeMaker(new BridgeNumberGenerator())
				.makeBridge(bridgeSize)
				.stream()
				.map(BridgeMoveType::of)
				.forEach(bridgeAnswer::add);
	}
}
