package calculator.common.error;

public enum InputErrorMessage {
    IS_BLANK("입력은 공백잀 수 없습니다."),
    ;

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
