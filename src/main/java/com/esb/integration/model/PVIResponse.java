package com.esb.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PVIResponse {
    @JsonProperty("Status")
    private String status;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Sign")
    private String sign;
}
