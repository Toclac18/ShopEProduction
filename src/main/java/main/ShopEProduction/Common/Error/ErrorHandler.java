package main.ShopEProduction.Common.Error;

public enum ErrorHandler {
    USER_NOT_FOUND(1001, "User not found"),
    USER_ALREADY_EXISTS(1002, "User already exists"),
    USERNAME_INVALID(1003, "Username must be between 3 and 20 characters"),
    PASSWORD_INVALID(1004, "Password must be between 3 and 20 characters"),
    INVALID_KEY(9998, "Invalid key"),
    UNCATEGORIED_ERROR(9999, "Uncategoried error"),
    ;
    private int errorCode;
    private String errorMessage;

    ErrorHandler(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
