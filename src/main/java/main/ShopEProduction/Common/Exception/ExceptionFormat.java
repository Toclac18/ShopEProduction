package main.ShopEProduction.Common.Exception;

import main.ShopEProduction.Common.Error.ErrorHandler;

public class ExceptionFormat extends RuntimeException {
    public ExceptionFormat(ErrorHandler errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    private  ErrorHandler errorCode;

    public ErrorHandler getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorHandler errorCode) {
        this.errorCode = errorCode;
    }
}
