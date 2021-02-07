package org.digitalcrafting.theOne.gateway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.digitalcrafting.theOne.gateway.utils.IOUtils;
import org.digitalcrafting.theOne.gateway.utils.ProxyRequestCreator;
import org.digitalcrafting.theOne.gateway.utils.URIUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class GatewayControllerService {

    private final ProxyRequestCreator creator;

    private HttpClient httpClient;

    @PostConstruct
    public void init() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
    }

    public ResponseEntity<String> proxyRequest(HttpServletRequest request) {
        HttpUriRequest proxyRequest = creator.createFromServletRequest(request);
        try {
            HttpResponse proxyResponse = httpClient.execute(proxyRequest);
            return new ResponseEntity(
                    IOUtils.read(proxyResponse.getEntity().getContent()),
                    URIUtils.makeResponseHeaders(proxyResponse),
                    HttpStatus.valueOf(proxyResponse.getStatusLine().getStatusCode())
            );
        } catch (IOException e) {
            log.error("Error while executing proxy request");
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
