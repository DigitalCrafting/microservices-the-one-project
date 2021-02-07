package org.digitalcrafting.theOne.gateway.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
class ServicesDepotImpl implements ServicesDepot {

    private final String discoveryIp;
    private final String discoveryPort;
    private RestTemplate restTemplate;

    public ServicesDepotImpl(@Value("${the-one.discovery.ip}") String discoveryIp, @Value("${the-one.discovery.port}") String discoveryPort) {
        this.discoveryIp = discoveryIp;
        this.discoveryPort = discoveryPort;
    }

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
    }


    @Override
    public ServiceModel discoverService(String serviceName) {
        String discoveryUrl = "http://" + this.discoveryIp + ":" + this.discoveryPort + "/discovery/v1/" + serviceName;
        return restTemplate.getForEntity(discoveryUrl, ServiceModel.class).getBody();
    }
}
