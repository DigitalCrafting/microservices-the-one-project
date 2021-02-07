package org.digitalcrafting.theOne.gateway.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.digitalcrafting.theOne.gateway.services.ServiceModel;
import org.digitalcrafting.theOne.gateway.services.ServicesDepot;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProxyRequestCreator {

    private final ServicesDepot servicesDepot;

    public HttpUriRequest createFromServletRequest(HttpServletRequest request) {
        RequestBuilder requestBuilder = RequestBuilder.create(request.getMethod());
        try {
            createURL(requestBuilder, request);
            createHeader(requestBuilder, request);
            createContent(requestBuilder, request);
        } catch (IOException | URISyntaxException e ) {
            log.error("Error while reading request");
        }
        return requestBuilder.build();
    }

    private void createURL(RequestBuilder rb, HttpServletRequest request) throws URISyntaxException {
        String requestURI = request.getRequestURI();
        URI uri;
        if (request.getQueryString() != null && !request.getQueryString().isEmpty()) {
            uri = new URI(getServiceUrl(requestURI) + "?" + request.getQueryString());
        } else {
            uri = new URI(getServiceUrl(requestURI));
        }
        rb.setUri(uri);
    }

    private String getServiceUrl(String requestUri) {
        ServiceModel discoveredService = servicesDepot.discoverService(URIUtils.extractServiceName(requestUri));
        if (discoveredService != null) {
            String location = discoveredService.getLocation();
            return "http://" + location + requestUri.replace("/api", "");
        }
        return "";
    }

    private void createHeader(RequestBuilder rb, HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            if (headerName.equals("x-access-token")) {
                rb.addHeader(headerName, headerValue);
            }
        }
    }

    private void createContent(RequestBuilder rb, HttpServletRequest request) throws IOException {
        String requestContent = request.getReader().lines().collect(Collectors.joining(""));
        if (!requestContent.isEmpty()) {
            StringEntity entity = new StringEntity(requestContent, ContentType.APPLICATION_JSON);
            rb.setEntity(entity);
        }
    }
}
