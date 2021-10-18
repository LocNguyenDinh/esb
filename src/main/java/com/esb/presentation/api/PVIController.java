package com.esb.presentation.api;

import com.esb.integration.model.PVIRequest;
import com.esb.integration.model.PVIResponse;
import com.esb.presentation.service.PVIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PVIController {
    @Autowired
    private PVIService pviService;
    @PostMapping("/pvi")
    public HttpEntity<Object> postPVI(@RequestBody PVIRequest pviRequest){
        Object object = pviService.postPVI(pviRequest);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
//
//    @GetMapping("/mic")
//    public String postMIC(){
//        return pviService.postMIC();
//    }
}
