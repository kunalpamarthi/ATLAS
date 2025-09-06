// Task001: Connecting DynamoDB

package org.example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Arrays;

public class DynamoConnect {
    public static void main(String[] args) {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
                .withEndpoint("http://localhost:8000"); // corrected endpoint URL

        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "Customer";

        try {
            System.out.println("Creating Customer table...");
            Table table = dynamoDB.createTable(
                    tableName,
                    Arrays.asList(
                            new KeySchemaElement("ID", KeyType.HASH),
                            new KeySchemaElement("No", KeyType.RANGE)
                    ),
                    Arrays.asList(
                            new AttributeDefinition("ID", ScalarAttributeType.S), // corrected attribute type
                            new AttributeDefinition("No", ScalarAttributeType.S)
                    ),
                    new ProvisionedThroughput(5L, 5L)
            );
            table.waitForActive();
            System.out.println("Table created and active. Status: " + table.getDescription().getTableStatus());
        } catch (Exception ex) {
            System.err.println("Error creating table: " + ex.getMessage()); // using err for error messages
        }
    }
}
