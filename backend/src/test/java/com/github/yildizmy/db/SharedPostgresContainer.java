package com.github.yildizmy.db;

import org.testcontainers.containers.PostgreSQLContainer;

public class SharedPostgresContainer extends PostgreSQLContainer<SharedPostgresContainer> {
    private static final String IMAGE = "postgres:15";
    private static SharedPostgresContainer container;

    private SharedPostgresContainer() {
        super(IMAGE);
        withDatabaseName("e_wallet");
        withUsername("postgres");
        withPassword("pass");
    }

    public static SharedPostgresContainer getInstance() {
        if (container == null) {
            container = new SharedPostgresContainer();
            container.start(); // start only once
        }
        return container;
    }
}
