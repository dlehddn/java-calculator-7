package calculator.common.error;

public enum DelimiterErrorMessage {
    INVALID_FORMAT("올바르지 않은 커스텀 구분자 지정 형식입니다."),
    ;

    private final String message;

    DelimiterErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
