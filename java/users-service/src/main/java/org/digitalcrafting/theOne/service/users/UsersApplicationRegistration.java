package org.digitalcrafting.theOne.service.users;

import lombok.RequiredArgsConstructor;
import org.digitalcrafting.theOne.service.users.dataaccess.discovery.DiscoveryClient;
import org.digitalcrafting.theOne.service.users.dataaccess.discovery.DiscoveryRegisterServiceRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersApplicationRegistration {
    private final DiscoveryClient client;

    @Value("${application.server.ip}")
    private String appIp;

    @Value("${server.port}")
    private String appPort;

    @EventListener(ApplicationReadyEvent.class)
    public void registerWithDiscovery() {
        DiscoveryRegisterServiceRequest request = new DiscoveryRegisterServiceRequest();
        request.setServiceName("users");
        request.setServiceIp(appIp);
        request.setServicePort(appPort);

        client.registerService(request);
    }
}
