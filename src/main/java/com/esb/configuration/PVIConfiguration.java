package com.esb.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "insurance.pvi")
public class PVIConfiguration {
    private String cpId;
    private String keyCP;
    private String program;
    private String endpoint;

    public String getCpId() {
        return cpId;
    }

    public void setCpId(String cpId) {
        this.cpId = cpId;
    }

    public String getKeyCP() {
        return keyCP;
    }

    public void setKeyCP(String keyCP) {
        this.keyCP = keyCP;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
