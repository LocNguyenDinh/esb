package com.esb.exception;

public class ErrorHelper {
    public static Response buildResponse( String errorCode){
        return buildResponses(errorCode);
    }
    private static  Response buildResponses(String errorCode){
        Response response = new Response();
        ErrorObject errorObject = new ErrorObject();
        errorObject.setErrorCode(errorCode);
        errorObject.setMessages(ErrorMessagesLoader.getMessage(errorCode));
        response.setStatus(errorObject);
        return response;
    }
}
