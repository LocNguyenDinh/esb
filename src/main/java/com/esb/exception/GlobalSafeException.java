package com.esb.exception;

public class GlobalSafeException extends RuntimeException {
    private Response response;

    public GlobalSafeException(String errorCode){
        super(errorCode);
        setResponse(ErrorHelper.buildResponse(errorCode));
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
