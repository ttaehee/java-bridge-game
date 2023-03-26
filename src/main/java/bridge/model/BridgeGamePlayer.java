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

	/**
	 * 플레이어의 입력값과 실제 다리의 값을 비교하는 메서드
	 */
	public boolean compareMoveType(List<BridgeMoveType> bridgeGameAnswer) {
		int currentLocation = playerRoute.size() - 1;
		return playerRoute.get(currentLocation) != bridgeGameAnswer.get(currentLocation);
	}

	/**
	 * 플레이어가 다리를 끝까지 건넜는지 여부를 반환하는 메서드
	 */
	public boolean isReached(List<BridgeMoveType> bridgeGameAnswer) {
		return playerRoute.size() == bridgeGameAnswer.size();
	}
}
