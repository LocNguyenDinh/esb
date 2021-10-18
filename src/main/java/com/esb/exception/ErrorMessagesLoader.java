package com.esb.exception;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
public class ErrorMessagesLoader {
    private static Map<String, ErrorMessages> errorMessagesMap;

    public ErrorMessagesLoader(){
        try{
            System.out.println("Loader===============");
            Charset charset = StandardCharsets.UTF_8;
            Properties enMessage = new Properties();
            enMessage.load(new InputStreamReader(getClass().getResourceAsStream("/en_error.properties"), charset));

            Properties vnMessage = new Properties();
            vnMessage.load(new InputStreamReader(getClass().getResourceAsStream("/vn_error.properties"), charset));

            errorMessagesMap = enMessage.entrySet().stream().collect(
                    Collectors.toMap(
                            e -> e.getKey().toString(),
                            e -> {
                                ErrorMessages errorMessages = new ErrorMessages();
                                errorMessages.setEn(e.getValue().toString());
                                errorMessages.setVn(vnMessage.getProperty(e.getKey().toString()));
                                return errorMessages;
                            }

                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static  ErrorMessages getMessage(String errorCode){
        ErrorMessages errorMessages = errorMessagesMap.get(errorCode);
        if(errorMessages == null){
            return errorMessagesMap.get(ErrorCode.INTERNAL_SERVER_ERROR);
        }
        return errorMessages;
    }
}
