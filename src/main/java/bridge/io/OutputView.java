package bridge.io;

import static bridge.io.GameMessage.FINAL_RESULT;
import static bridge.io.GameMessage.REQUEST_DIRECTION;
import static bridge.io.GameMessage.START;
import static bridge.io.GameMessage.WIN_RESULT;
import static bridge.io.GameMessage.TOTAL_ROUND;
import static bridge.io.GameUnitMessage.CORRECT_EXPRESSION;
import static bridge.io.GameUnitMessage.ENTER;
import static bridge.io.GameUnitMessage.LEFT_BRACKET;
import static bridge.io.GameUnitMessage.NOT_CORRECT_EXPRESSION;
import static bridge.io.GameUnitMessage.RIGHT_BRACKET;
import static bridge.io.GameUnitMessage.SPACING_EXPRESSION;
import static bridge.io.GameUnitMessage.VERTICAL_BAR;
import static bridge.model.BridgeMoveType.DOWN;
import static bridge.model.BridgeMoveType.UP;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import bridge.model.BridgeGameHistory;
import bridge.model.BridgeMoveType;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다
 */
public class OutputView {

	/**
	 * 게임 시작 메시지를 출력한다
	 */
	public void printStartMessage() {
		System.out.print(START.getMessage());
	}

	public void printMoveMessage() {
		System.out.print(REQUEST_DIRECTION.getMessage());
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다
	 */
	public void printMap(BridgeGameHistory bridgeGameHistory) {
		List<BridgeMoveType> playerMoveHistory = bridgeGameHistory.getPlayerRoute();
		List<BridgeMoveType> bridgeAnswerHistory = bridgeGameHistory.getGameAnswer();

		String bridgeUpHistory = createHistory(playerMoveHistory, bridgeAnswerHistory, UP);
		String bridgeDownHistory = createHistory(playerMoveHistory, bridgeAnswerHistory, DOWN);

		System.out.print(
				MessageFormat.format("{0}{1}{2}{3}{4}",
						bridgeUpHistory, ENTER.getUnit(), bridgeDownHistory, ENTER.getUnit(), ENTER.getUnit())
		);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 */
	public void printResult(BridgeGameHistory bridgeGameHistory) {
		System.out.print(FINAL_RESULT.getMessage());
		printMap(bridgeGameHistory);
		System.out.print(MessageFormat.format(WIN_RESULT.getMessage(), bridgeGameHistory.getGameResult().getStatus()));
		System.out.print(MessageFormat.format(TOTAL_ROUND.getMessage(), bridgeGameHistory.getGameRound()));
	}

	public void printException(String message) {
		System.out.println(message);
	}

	private String createHistory(
			List<BridgeMoveType> playerMoveHistory, List<BridgeMoveType> bridgeAnswerHistory, BridgeMoveType bridgeMoveType) {

		return LEFT_BRACKET.getUnit() +
				IntStream.range(0, playerMoveHistory.size())
						.mapToObj(currentLocation -> {
							BridgeMoveType answerMoveType = bridgeAnswerHistory.get(currentLocation);
							BridgeMoveType playerMoveType = playerMoveHistory.get(currentLocation);
							return convertToHistory(bridgeMoveType, answerMoveType, playerMoveType);
						})
						.collect(Collectors.joining(VERTICAL_BAR.getUnit()))
				+ RIGHT_BRACKET.getUnit();
	}

	private String convertToHistory(
			BridgeMoveType bridgeMoveType, BridgeMoveType answerMoveType, BridgeMoveType playerMoveType) {

		if (answerMoveType.isSame(bridgeMoveType)) {
			if (answerMoveType.isSame(playerMoveType)) {
				return CORRECT_EXPRESSION.getUnit();
			}
			return SPACING_EXPRESSION.getUnit();
		}

		if (answerMoveType.isNotSame(playerMoveType)) {
			return NOT_CORRECT_EXPRESSION.getUnit();
		}

		return SPACING_EXPRESSION.getUnit();
	}
}
