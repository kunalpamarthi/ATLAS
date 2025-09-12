// Task001: Connecting DynamoDB

package org.example;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.waiters.DynamoDbWaiter;

import java.net.URI;

public class DynamoConnect {
    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000"))
                .build();

        String tableName = "Employees01";

        try {
            System.out.println("Creating Customer table...");

            CreateTableRequest createTableRequest = CreateTableRequest.builder()
                    .tableName(tableName)
                    .keySchema(
                            KeySchemaElement.builder().attributeName("ID").keyType(KeyType.HASH).build(),
                            KeySchemaElement.builder().attributeName("Name").keyType(KeyType.RANGE).build()
                    )
                    .attributeDefinitions(
                            AttributeDefinition.builder().attributeName("ID").attributeType(ScalarAttributeType.S).build(),
                            AttributeDefinition.builder().attributeName("Name").attributeType(ScalarAttributeType.S).build(),
                            AttributeDefinition.builder().attributeName("Address").attributeType(ScalarAttributeType.S).build()
                    )
                    .provisionedThroughput(ProvisionedThroughput.builder()
                            .readCapacityUnits(5L)
                            .writeCapacityUnits(5L)
                            .build())
                    .build();

            dynamoDbClient.createTable(createTableRequest);

            DynamoDbWaiter dynamoDbWaiter = dynamoDbClient.waiter();
            DescribeTableRequest describeTableRequest = DescribeTableRequest.builder()
                    .tableName(tableName)
                    .build();

            dynamoDbWaiter.waitUntilTableExists(describeTableRequest);

            System.out.println("Table created and active.");
        } catch (Exception ex) {
            System.err.println("Error creating table: " + ex.getMessage());
        } finally {
            dynamoDbClient.close();
        }
    }
}