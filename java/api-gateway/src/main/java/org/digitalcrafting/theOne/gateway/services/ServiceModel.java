package org.digitalcrafting.theOne.gateway.services;

import lombok.Data;

@Data
public class ServiceModel {
    private String serviceName;
    private String serviceIp;
    private String servicePort;

    public String getLocation() {
        return serviceIp + ":" + servicePort;
    }
}
