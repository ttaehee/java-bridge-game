package bridge.model;

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
}
