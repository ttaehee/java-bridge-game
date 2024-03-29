package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.model.BridgeMoveType;

public class BridgeMaker {
	private final BridgeNumberGenerator bridgeNumberGenerator;

	public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
		this.bridgeNumberGenerator = bridgeNumberGenerator;
	}

	/**
	 * @param size 다리의 길이
	 * @return 입력받은 길이에 해당하는 다리 모양 (위 칸이면 "U", 아래 칸이면 "D"로 표현)
	 */
	public List<String> makeBridge(int size) {
		List<String> bridge = new ArrayList<>();
		while (bridge.size() != size) {
			bridge.add(BridgeMoveType.of(bridgeNumberGenerator.generate()));
		}
		return bridge;
	}
}
