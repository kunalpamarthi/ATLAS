// There is some issue with the code.

//package org.example;
//
//import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.dax.DaxClient;
//import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
//import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
//import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
//import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
//import java.net.URI;
//import java.util.HashMap;
//import java.util.Map;
//
//public class AcceleratorDAX {
//    public static void main(String[] args) {
//        // DAX endpoint
//        String daxEndpoint = " ";
//
//        // Create DAX client
//        DaxClient daxClient = DaxClient.builder()
//                .endpointOverride(URI.create(daxEndpoint))
//                .region(Region.AP_SOUTH_1)
//                .credentialsProvider(DefaultCredentialsProvider.create())
//                .build();
//
//        String tableName = "Employees01";
//        String keyName = "ID";
//        String keyValue = "10001";
//
//        try {
//            // Put item
//            Map<String, AttributeValue> item = new HashMap<>();
//            item.put(keyName, AttributeValue.builder().s(keyValue).build());
//            item.put("msg", AttributeValue.builder().s("we are creating DAX ").build());
//
//            PutItemRequest putItemRequest = PutItemRequest.builder()
//                    .tableName(tableName)
//                    .item(item)
//                    .build();
//
//            daxClient.putItem(putItemRequest);
//
//            // Get item
//            Map<String, AttributeValue> getItemKey = new HashMap<>();
//            getItemKey.put(keyName, AttributeValue.builder().s(keyValue).build());
//
//            GetItemRequest getItemRequest = GetItemRequest.builder()
//                    .tableName(tableName)
//                    .key(getItemKey)
//                    .build();
//
//            GetItemResponse response = daxClient.getItem(getItemRequest);
//
//            if (response.hasItem()) {
//                System.out.println("Item retrieved: " + response.item());
//            } else {
//                System.out.println("Item not found");
//            }
//
//            System.out.println("DAX working..");
//        } catch (Exception e) {
//            System.err.println("Error occurred: " + e.getMessage());
//        } finally {
//            daxClient.close();
//        }
//    }
//}
