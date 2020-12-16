package org.digitalcrafting.serviceDiscovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/discovery/api/proxy/v1")
public class ServiceDiscoveryController {

    @GetMapping("/")
    public String test() {
        return "ServiceDiscovery is alive!";
    }
}
