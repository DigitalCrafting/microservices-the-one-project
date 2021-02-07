package org.digitalcrafting.theOne.gateway.utils;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpHeaders;

public final class URIUtils {

    private URIUtils() {};

    public static String extractServiceName(String uri) {
        String[] elements = uri.replace("/api/", "").split("/");
        return elements[0];
    }

    public static HttpHeaders makeResponseHeaders(HttpResponse response) {
        HttpHeaders result = new HttpHeaders();
        Header h = response.getFirstHeader("Content-Type");
        result.set(h.getName(), h.getValue());
        return result;
    }
}
