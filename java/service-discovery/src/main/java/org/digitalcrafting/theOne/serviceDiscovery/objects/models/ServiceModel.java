package org.digitalcrafting.theOne.serviceDiscovery.objects.models;

import lombok.Data;

@Data
public class ServiceModel {
    private String serviceName;
    private String serviceIp;
    private String servicePort;
}
