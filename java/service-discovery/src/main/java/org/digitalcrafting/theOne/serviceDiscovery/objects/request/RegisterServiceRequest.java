package org.digitalcrafting.theOne.serviceDiscovery.objects.request;

import lombok.Data;

@Data
public class RegisterServiceRequest {
    private String serviceName;
    private String serviceIp;
    private String servicePort;
}
