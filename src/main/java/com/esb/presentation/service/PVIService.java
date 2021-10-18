package com.esb.presentation.service;

import com.esb.integration.model.PVIRequest;
import com.esb.integration.model.PVIResponse;

public interface PVIService {
    PVIResponse postPVI(PVIRequest request);

//    String postMIC();
}
