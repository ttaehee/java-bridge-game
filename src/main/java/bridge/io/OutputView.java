package bridge.io;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다
 */
public class OutputView {

	/**
	 * 게임 진행과 관련된 메시지를 출력한다
	 */
	public void printMessage(GameMessage gameMessage) {
		System.out.println(gameMessage);
	}
}
