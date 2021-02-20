package org.digitalcrafting.theOne.serviceDiscovery.controller;

import lombok.RequiredArgsConstructor;
import org.digitalcrafting.theOne.serviceDiscovery.objects.models.ServiceModel;
import org.digitalcrafting.theOne.serviceDiscovery.objects.request.RegisterServiceRequest;
import org.digitalcrafting.theOne.serviceDiscovery.objects.response.GetServiceInfoResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceDiscoveryControllerService {

    private final ServicesStorage storage;

    public void registerService(RegisterServiceRequest request) {
        ServiceModel model = ServiceDiscoveryConverter.convert(request);
        storage.register(model);
    }

    public GetServiceInfoResponse getServiceInfoIfAlive(String serviceName) {
        ServiceModel model = storage.getServiceByName(serviceName);
        return ServiceDiscoveryConverter.convert(model);
    }
}
