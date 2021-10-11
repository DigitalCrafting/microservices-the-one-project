package org.digitalcrafting.theOne.service.users.dataaccess.discovery;

import lombok.Data;

@Data
public class DiscoveryRegisterServiceRequest {
    private String serviceName;
    private String serviceIp;
    private String servicePort;
}
