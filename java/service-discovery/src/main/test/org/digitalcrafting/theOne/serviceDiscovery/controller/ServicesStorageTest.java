package org.digitalcrafting.theOne.serviceDiscovery.controller;

import org.digitalcrafting.theOne.serviceDiscovery.objects.models.ServiceModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServicesStorageTest {

    public static final String SERVICE_NAME = "test";
    private ServicesStorage storage;

    @Before
    public void setUp() throws Exception {
        storage = new ServicesStorage();
    }

    @Test
    public void testStorage() {
        ServiceModel testModel = new ServiceModel(
                SERVICE_NAME,
                "localhost",
                "8888"
        );

        storage.register(testModel);

        ServiceModel retrieved = storage.getServiceByName(SERVICE_NAME);
        assertNotNull(retrieved);
        assertEquals(retrieved, testModel);
    }
}