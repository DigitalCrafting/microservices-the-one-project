package org.digitalcrafting.theOne.serviceDiscovery.controller;

import org.digitalcrafting.theOne.serviceDiscovery.objects.models.ServiceModel;
import org.digitalcrafting.theOne.serviceDiscovery.objects.request.RegisterServiceRequest;
import org.digitalcrafting.theOne.serviceDiscovery.objects.response.GetServiceInfoResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceDiscoveryConverterTest {

    private RegisterServiceRequest originalReq;
    private ServiceModel originalModel;
    private GetServiceInfoResponse originalResp;

    @Before
    public void setUp() throws Exception {
        originalReq = new RegisterServiceRequest();
        originalReq.setServiceName("test");
        originalReq.setServiceIp("localhost");
        originalReq.setServicePort("8888");

        originalModel = new ServiceModel();
        originalModel.setServiceName("test");
        originalModel.setServiceIp("localhost");
        originalModel.setServicePort("8888");

        originalResp = new GetServiceInfoResponse();
        originalResp.setServiceName("test");
        originalResp.setServiceIp("localhost");
        originalResp.setServicePort("8888");
        originalResp.setAlive(true);
    }

    @Test
    public void testConvertingRequest() {
        ServiceModel converted = ServiceDiscoveryConverter.convert(originalReq);
        assertEquals(originalModel, converted);
    }

    @Test
    public void testConvertingModel() {
        GetServiceInfoResponse converted = ServiceDiscoveryConverter.convert((ServiceModel) null);
        assertEquals(converted.getAlive(), false);
        
        converted = ServiceDiscoveryConverter.convert(originalModel);
        assertEquals(converted, originalResp);
    }
}