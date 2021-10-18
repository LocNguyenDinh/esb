package com.esb.integration.model;

import lombok.Data;

@Data
public class PVIRequest {
    private String requestId;
    private String customerPhone;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String customerIdNumber;
    private String ownerName;
    private String ownerAddress;
    private Integer capacity;
    private String licenseNumber;
    private String engineNumber;
    private String chassisNumber;
    private String fromDate;
    private String toDate;
    private Integer amount;
    private String note;
    private String cpId;
    private String program;
    private String sign;


}
