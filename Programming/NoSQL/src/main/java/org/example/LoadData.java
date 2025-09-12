// Task004: Load/insert data to the table.

package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoadData {
    public static void main(String[] args) throws Exception{
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000")).build();
        String table = "Employees01";
        System.out.println("Connection established..");
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = LoadData.class.getClassLoader().getResourceAsStream("EmployeesData.json");
        JsonNode jsonNode = objectMapper.readTree(inputStream);
        System.out.println("JSON data in the input stream...");
        Iterator<JsonNode> jsonNodeIterator = jsonNode.elements();

        while (jsonNodeIterator.hasNext()){
            JsonNode node = jsonNodeIterator.next();
            Map<String, AttributeValue> item = new HashMap<>();
            item.put("ID", AttributeValue.builder().s(node.get("ID").asText()).build());
            item.put("Name", AttributeValue.builder().s(node.get("Name").asText()).build());
            item.put("Address", AttributeValue.builder().s(node.get("Address").asText()).build());

            PutItemRequest request = PutItemRequest.builder().tableName(table).item(item).build();
            dynamoDbClient.putItem(request);
            System.out.println("Loading data to the table..");
        }
        dynamoDbClient.close();
        System.out.println("Successfully loaded data to the table.!!");
    }
}
