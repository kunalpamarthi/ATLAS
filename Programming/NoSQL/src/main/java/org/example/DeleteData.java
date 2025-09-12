// Task009: Delete a particular item from the table.

package org.example;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.net.URI;
import java.util.HashMap;
import java.util.Scanner;

public class DeleteData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000")).build();
        String table = "Employees01";
        ScanRequest scanRequest = ScanRequest.builder().tableName(table).build();
        ScanResponse response = dynamoDbClient.scan(scanRequest);
        System.out.println("\t\t\tEmployees\n");
        System.out.println(" | ID<HASH> | Name<RANGE> | Address");
        System.out.println("--------------------------------------");
        response.items().forEach(item -> {
            System.out.print(" | " + item.get("ID").s());
            System.out.print("\t\t|\t" + item.get("Name").s());
            System.out.print("\t  |\t" + item.get("Address").s() + "\n");
        });

        System.out.print("Enter ID of the employee you want to delete: ");
        String id = scanner.next();
        System.out.print("Enter name: ");
        String name = scanner.next();

        HashMap<String, AttributeValue> key = new HashMap<>();
        key.put("ID", AttributeValue.builder().s(id).build());
        key.put("Name", AttributeValue.builder().s(name).build());

        DeleteItemRequest deleteItemRequest = DeleteItemRequest.builder().tableName(table).key(key).build();
        dynamoDbClient.deleteItem(deleteItemRequest);

        ScanResponse scanResponse = dynamoDbClient.scan(scanRequest);
        System.out.println("\t\t\tEmployees\n");
        System.out.println(" | ID<HASH> | Name<RANGE> | Address");
        System.out.println("--------------------------------------");
        scanResponse.items().forEach(item -> {
            System.out.print(" | " + item.get("ID").s());
            System.out.print("\t\t|\t" + item.get("Name").s());
            System.out.print("\t  |\t" + item.get("Address").s() + "\n");
        });
        dynamoDbClient.close();
        scanner.close();
    }
}
