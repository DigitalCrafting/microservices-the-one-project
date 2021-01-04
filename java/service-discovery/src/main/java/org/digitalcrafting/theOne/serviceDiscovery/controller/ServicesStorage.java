package org.digitalcrafting.theOne.serviceDiscovery.controller;

import org.digitalcrafting.theOne.serviceDiscovery.objects.models.ServiceModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ServicesStorage {
    private final Map<String, ServiceModel> servicesMap = new HashMap<>();

    public void register(ServiceModel serviceModel) {
        this.servicesMap.put(serviceModel.getServiceName(), serviceModel);
    }

    public Map<String, ServiceModel> getServicesMap() {
        return new HashMap<>(servicesMap);
    }
}
