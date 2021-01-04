package org.digitalcrafting.theOne.serviceDiscovery.objects.response;

import lombok.Data;

@Data
public class GetServiceInfoResponse {
    private Boolean alive;
    private String serviceName;
    private String serviceIp;
    private String servicePort;
}
