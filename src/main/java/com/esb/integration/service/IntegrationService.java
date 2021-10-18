package com.esb.integration.service;

import com.esb.integration.model.PVIRequest;
import com.esb.integration.model.PVIResponse;

public interface IntegrationService {
    PVIResponse postPVIMoto(PVIRequest request);
//    String postMIC();
}
