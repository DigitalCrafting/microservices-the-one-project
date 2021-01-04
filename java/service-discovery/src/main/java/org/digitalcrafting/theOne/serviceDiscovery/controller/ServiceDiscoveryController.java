package org.digitalcrafting.theOne.serviceDiscovery.controller;

import lombok.RequiredArgsConstructor;
import org.digitalcrafting.theOne.serviceDiscovery.objects.models.ServiceModel;
import org.digitalcrafting.theOne.serviceDiscovery.objects.request.RegisterServiceRequest;
import org.digitalcrafting.theOne.serviceDiscovery.objects.response.GetServiceInfoResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discovery/v1")
public class ServiceDiscoveryController {

    private final ServiceDiscoveryControllerService service;

    @GetMapping("/")
    public String healthCheck() {
        return "ServiceDiscovery is alive!";
    }

    @PostMapping("/")
    public void registerService(@RequestBody RegisterServiceRequest request) {
        service.registerService(request);
    }

    @GetMapping("/{serviceName}")
    public GetServiceInfoResponse getServiceInfoIfAlive(@PathVariable("serviceName") String serviceName) {
        return service.getServiceInfoIfAlive(serviceName);
    }
}
