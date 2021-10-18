package com.esb.presentation.service.Impl;

import com.esb.exception.ErrorCode;
import com.esb.exception.GlobalSafeException;
import com.esb.integration.model.PVIRequest;
import com.esb.integration.model.PVIResponse;
import com.esb.integration.service.IntegrationService;
import com.esb.presentation.service.PVIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jnlp.PersistenceService;

@Service
public class PVIServiceImpl implements PVIService {

    @Autowired
    private IntegrationService integrationService;

    @Override
    public PVIResponse postPVI(PVIRequest pviRequest) {
        try {
            return integrationService.postPVIMoto(pviRequest);
        } catch (Exception e){
            throw  new GlobalSafeException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @Override
//    public String postMIC() {
//      return   integrationService.postMIC();
//    }
}
