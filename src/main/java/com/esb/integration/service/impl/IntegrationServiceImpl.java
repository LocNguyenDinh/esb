package com.esb.integration.service.impl;

import com.esb.configuration.PVIConfiguration;
import com.esb.integration.model.PVIRequest;
import com.esb.integration.model.PVIResponse;
import com.esb.integration.service.IntegrationService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IntegrationServiceImpl implements IntegrationService {
    private static Logger LOGGER = LoggerFactory.getLogger(IntegrationServiceImpl.class);
    @Autowired
    private RestTemplate template;
    @Autowired
    PVIConfiguration configuration;

    @Override
    public PVIResponse postPVIMoto(PVIRequest entity) {
        LOGGER.info("==========START PVIServiceImpl postPVIMoto entity {} ==========", entity);
        entity.setCpId(configuration.getCpId());
        entity.setProgram(configuration.getProgram());
        entity.setSign(DigestUtils.md5Hex(configuration.getKeyCP() + entity.getRequestId()));
        String url = configuration.getEndpoint();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PVIRequest> request = new HttpEntity<>(entity, headers);
        PVIResponse response = template.postForObject(url, request, PVIResponse.class);
        LOGGER.info("======body: {}======", response);
        return response;

    }

//    @Override
//    public String postMIC() {
//
//        LOGGER.info("==========START PVIServiceImpl postMIC==========");
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("SoapAction", "1.2");
//        headers.set("Content-Type", "text/xml;charset=UTF-8");
//        headers.set("Cookie","ASP.NET_SessionId=kk1mrvn1o3t14ozn30mpcqzs");
//        String url= "https://test-dly.mic.vn/Service/dly/ws_dly.asmx";
//        String body = "<soap:Envelope xmlns:soap=\\\"http://www.w3.org/2003/05/soap-envelope\\\" xmlns:tem=\\\"http://tempuri.org/\\\">\\r\\n   <soap:Header/>\\r\\n   <soap:Body>\\r\\n      <tem:ws_BPHI>\\r\\n         <!--Optional:-->\\r\\n         <tem:xmlinput>\\r\\n         <![CDATA[\\r\\n<XMLINPUT> \\r\\n\\t<MA_DVI>001_MYANGEL</MA_DVI>\\r\\n\\t<NSD>001_MYANGEL</NSD>\\r\\n\\t<PAS>bhqd2019</PAS>\\r\\n\\t<NV>XEL</NV> \\r\\n\\t<BIEN_XE>30A123123</BIEN_XE>\\r\\n\\t<SO_KHUNG>112233</SO_KHUNG>\\r\\n\\t<SO_MAY>09888888</SO_MAY>\\r\\n\\t<HANG_XE>HONDA</HANG_XE>\\r\\n\\t<HIEU_XE>CITY</HIEU_XE>\\r\\n\\t<NAM_SX>2018</NAM_SX>\\r\\n\\t<SO_CN>5</SO_CN>\\r\\n\\t<TTAI>0</TTAI> \\r\\n\\t<NGAY_HL>16/11/2020</NGAY_HL>\\r\\n\\t<NGAY_KT>16/11/2021</NGAY_KT>\\r\\n\\t<MDSDN>C</MDSDN>\\r\\n\\t\\t<XEN1>C</XEN1>\\t\\r\\n\\t\\t<XEN5>K</XEN5>\\r\\n\\t\\t<XEN4>K</XEN4>\\r\\n\\t\\t<XEN2>K</XEN2>\\r\\n\\t\\t<XEN3>K</XEN3>\\r\\n\\t\\t<XEN7>K</XEN7>\\r\\n\\t\\t<XEN6>K</XEN6>\\r\\n\\t<MDSDH>K</MDSDH>\\r\\n\\t\\t<XEH1>C</XEH1>\\t\\r\\n\\t\\t<XEH2>K</XEH2>\\r\\n\\t\\t<XEH3>K</XEH3>\\r\\n\\t\\t<XEH4>K</XEH4>\\r\\n\\t\\t<XEH5>K</XEH5> \\r\\n\\t\\t<XEH6>K</XEH6>\\r\\n\\t<MDSDT>K</MDSDT>\\r\\n\\t\\t<XET1>K</XET1>\\r\\n\\t\\t<XET2>K</XET2> \\r\\n\\t<BBTN>C</BBTN>\\r\\n</XMLINPUT>\\r\\n]]>\\r\\n         </tem:xmlinput>\\r\\n      </tem:ws_BPHI>\\r\\n   </soap:Body>\\r\\n</soap:Envelope>";
//
//        HttpEntity<String> request = new HttpEntity<>(body,headers);
//        LOGGER.info("Request: {}", request);
//        String result = template.postForObject(url, request ,String.class);
//        System.out.println(result);
//        return result;
//    }
//
//    private PVIRequest buildPVIRequest(PVIEntity entity){
//        PVIRequest pviRequest = new PVIRequest();
//        pviRequest.setRequestId(Random.generateRandom());
//        pviRequest.setCustomerPhone(entity.getCustomerPhone());
//        pviRequest.setCustomerName(entity.getCustomerName());
//        pviRequest.setCustomerEmail(entity.getCustomerEmail());
//        pviRequest.setCustomerIdNumber(entity.getCustomerIdNumber());
//        pviRequest.setOwnerName(entity.getOwnerName());
//        pviRequest.setOwnerAddress(entity.getOwnerAddress());
//        pviRequest.setCapacity(entity.getCapacity());
//        if(entity.getLicenseNumber() != null){
//            pviRequest.setLicenseNumber(entity.getLicenseNumber());
//        }
//        if(entity.getEngineNumber() != null && entity.getChassisNumber() != null){
//            pviRequest.setEngineNumber(entity.getEngineNumber());
//            pviRequest.setChassisNumber(entity.getChassisNumber());
//        }
//        pviRequest.setFromDate(DateUtil.convertDate(entity.getFromDateTime()));
//        pviRequest.setToDate(DateUtil.convertDate(entity.getToDateTime()));
//        pviRequest.setAmount(Integer.parseInt(entity.getAmount()));
//        pviRequest.setNote(entity.getNote());
//        pviRequest.setCpId(configuration.getCpId());
//        pviRequest.setProgram(configuration.getProgram());
//        pviRequest.setSign(DigestUtils.md5Hex(configuration.getKeyCP() + pviRequest.getRequestId()));
//        return  pviRequest;
//
//    }
//


}
