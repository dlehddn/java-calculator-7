package calculator.common.error;

public enum NumberErrorMessage {
    IS_NOT_NUMBER("올바르지 않은 숫자 형식입니다."),
    ;

    private final String message;

    NumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
