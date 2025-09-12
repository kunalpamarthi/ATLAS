// Task005: Scan/read data from the table.

package org.example;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

import java.net.URI;

public class ScanData {
    public static void main(String[] args) {
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000")).build();
        String table = "Employees01";
        ScanRequest scanRequest = ScanRequest.builder().tableName(table).build();
        ScanResponse response = dynamoDbClient.scan(scanRequest);
        System.out.println("\t\t\tEmployees\n");
        System.out.println(" | ID<HASH> | Name<RANGE> | Address");
        System.out.println("--------------------------------------");
        response.items().forEach(item -> {
            System.out.print(" | "+item.get("ID").s());
            System.out.print("\t\t|\t"+item.get("Name").s());
            System.out.print("\t  |\t"+item.get("Address").s()+"\n");
        });
        dynamoDbClient.close();
    }
}
