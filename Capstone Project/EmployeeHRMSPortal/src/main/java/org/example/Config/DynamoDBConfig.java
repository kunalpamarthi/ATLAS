package org.example.Config;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import java.net.URI;

public class DynamoDBConfig {
    private static final String ENDPOINT = "http://localhost:8000";
    private static DynamoDbClient dynamoDbClient;

    public static DynamoDbClient getDynamoDbClient() {
        if (dynamoDbClient == null) {
            dynamoDbClient = DynamoDbClient.builder()
                    .endpointOverride(URI.create(ENDPOINT))
                    .build();
        }
        return dynamoDbClient;
    }
}