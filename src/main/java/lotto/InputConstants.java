package lotto;

public enum InputConstants {
    ENTER_MONEY("구입 금액을 입력해주세요."),
    ENTER_LOTTO_NUMBERS("당첨 번호를 입력해주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해주세요."),
    TOTAL_LOTTO_TICKETS("개를 구매했습니다.");
    private final String message;

    InputConstants(String messeage) {
        this.message = messeage;
    }

    public String getMessage() {
        return message;
    }
}
