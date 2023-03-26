package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeGamePlayer {

	private final List<BridgeMoveType> playerRoute;

	public BridgeGamePlayer() {
		this.playerRoute = new ArrayList<>();
	}

	/**
	 * 플레이어가 칸을 이동할 때 사용하는 메서드
	 */
	public void move(BridgeMoveType bridgeMoveType) {
		playerRoute.add(bridgeMoveType);
	}
}
