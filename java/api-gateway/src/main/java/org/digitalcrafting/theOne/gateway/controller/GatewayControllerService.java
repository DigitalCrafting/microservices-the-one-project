package org.digitalcrafting.theOne.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Service
public class GatewayControllerService {
    private final String discoveryIp;
    private final String discoveryPort;
    private RestTemplate restTemplate;

    public GatewayControllerService(@Value("${the-one.discovery.ip}") String discoveryIp, @Value("${the-one.discovery.port}") String discoveryPort) {
        this.discoveryIp = discoveryIp;
        this.discoveryPort = discoveryPort;
    }

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
    }

    public ResponseEntity<String> proxyRequest(HttpServletRequest request) {
        String discoveryUrl = "http://" + this.discoveryIp + ":" + this.discoveryPort + "/discovery/api/v1/";
        return restTemplate.getForEntity(discoveryUrl, String.class);
    }
}
