package org.digitalcrafting.theOne.serviceDiscovery.objects.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceModel {
    private String serviceName;
    private String serviceIp;
    private String servicePort;
}
