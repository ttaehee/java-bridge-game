package bridge.model;

import java.util.List;

public class BridgeGamePlayer {

	private final List<BridgeMoveType> playerRoute;

	public BridgeGamePlayer(List<BridgeMoveType> playerRoute) {
		this.playerRoute = playerRoute;
	}

	/**
	 * 플레이어가 칸을 이동할 때 사용하는 메서드
	 */
	public void move(BridgeMoveType bridgeMoveType) {
		playerRoute.add(bridgeMoveType);
	}
}
