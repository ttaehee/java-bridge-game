package bridge.io;

import static bridge.io.GameUnitMessage.ENTER;

/**
 * 게임 진행에 필요한 메시지들을 관리한다
 */
public enum GameMessage {
	START("다리 건너기 게임을 시작합니다." + ENTER.getUnit() + "다리의 길이를 입력해주세요." + ENTER.getUnit()),
	REQUEST_DIRECTION("이동할 칸을 선택해주세요. (위: U, 아래: D)" + ENTER.getUnit()),
	RESTART_OR_EXIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
	FINAL_RESULT("최종 게임 결과" + ENTER.getUnit()),
	WIN_RESULT("게임 성공 여부: {0}" + ENTER.getUnit()),
	TOTAL_ROUND("총 시도한 횟수: {0}");

	private final String message;

	GameMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
