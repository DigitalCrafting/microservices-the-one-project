package org.digitalcrafting.theOne.serviceDiscovery.controller;

import org.digitalcrafting.theOne.serviceDiscovery.objects.models.ServiceModel;
import org.digitalcrafting.theOne.serviceDiscovery.objects.request.RegisterServiceRequest;
import org.digitalcrafting.theOne.serviceDiscovery.objects.response.GetServiceInfoResponse;

public class ServiceDiscoveryConverter {
    private ServiceDiscoveryConverter() {
    }

    public static ServiceModel convert(RegisterServiceRequest request) {
        ServiceModel model = new ServiceModel();
        model.setServiceName(request.getServiceName());
        model.setServiceIp(request.getServiceIp());
        model.setServicePort(request.getServicePort());
        return model;
    }

    public static GetServiceInfoResponse convert(ServiceModel model) {
        GetServiceInfoResponse response = new GetServiceInfoResponse();
        if (model == null) {
            response.setAlive(false);
        } else {
            response.setAlive(true);
            response.setServiceName(model.getServiceName());
            response.setServiceIp(model.getServiceIp());
            response.setServicePort(model.getServicePort());
        }

        return response;
    }
}
