package org.digitalcrafting.theOne.gateway.utils;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class URIUtilsTest {

    @Test
    public void shouldExtractServiceName() {
        String uri = "/api/user/v1/65482";
        String serviceName = URIUtils.extractServiceName(uri);

        Assertions.assertThat(serviceName).isNotNull();
        Assertions.assertThat(serviceName).isNotBlank();
        Assertions.assertThat(serviceName).isEqualTo("user");
    }
}