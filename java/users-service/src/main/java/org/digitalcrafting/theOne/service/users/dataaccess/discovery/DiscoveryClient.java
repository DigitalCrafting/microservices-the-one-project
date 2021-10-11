package org.digitalcrafting.theOne.service.users.dataaccess.discovery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "DiscoveryClient", url = "${the-one.discovery.url}")
public interface DiscoveryClient {
    @PostMapping("/discovery/v1/")
    void registerService(DiscoveryRegisterServiceRequest request);
}
