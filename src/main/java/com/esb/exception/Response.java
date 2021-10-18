package com.esb.exception;

public class Response {
    private ErrorObject status;

    public ErrorObject getStatus() {
        return status;
    }

    public void setStatus(ErrorObject status) {
        this.status = status;
    }
}
