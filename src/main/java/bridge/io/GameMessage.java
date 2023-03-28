package bridge.io;

/**
 * 게임 진행에 필요한 메시지들을 관리한다
 */
public enum GameMessage {
	START("다리 건너기 게임을 시작합니다.\n다리의 길이를 입력해주세요."),
	REQUEST_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
	RESTART_OR_EXIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

	private final String message;

	GameMessage(String message) {
		this.message = message;
	}
}
