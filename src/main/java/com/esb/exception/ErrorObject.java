package com.esb.exception;

public class ErrorObject {
    private String errorCode;
    private ErrorMessages messages;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorMessages getMessages() {
        return messages;
    }

    public void setMessages(ErrorMessages messages) {
        this.messages = messages;
    }
}
