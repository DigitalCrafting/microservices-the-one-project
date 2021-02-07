package org.digitalcrafting.theOne.gateway.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public final class IOUtils {

    private IOUtils() {
    }

    public static String read(InputStream is) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        }
    }
}
