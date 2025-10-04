package org.example.DAO;

import org.example.Config.Constants;
import org.example.Config.DynamoDBConfig;
import org.example.Model.LeaveRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class LeaveRequestDAO {
    private final DynamoDbClient dynamoDbClient;

    public LeaveRequestDAO() {
        this.dynamoDbClient = DynamoDBConfig.getDynamoDbClient();
    }

    public void createLeaveRequest(LeaveRequest leaveRequest) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("empId", AttributeValue.builder().s(leaveRequest.getEmpId()).build());
        item.put("requestId", AttributeValue.builder().s(leaveRequest.getRequestId()).build());
        item.put("startDate", AttributeValue.builder().s(leaveRequest.getStartDate()).build());
        item.put("endDate", AttributeValue.builder().s(leaveRequest.getEndDate()).build());
        item.put("reason", AttributeValue.builder().s(leaveRequest.getReason()).build());
        item.put("status", AttributeValue.builder().s(leaveRequest.getStatus()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(Constants.LEAVE_REQUEST_TABLE)
                .item(item)
                .build();

        try {
            dynamoDbClient.putItem(request);
        } catch (DynamoDbException e) {
            System.err.println("Error creating leave request: " + e.getMessage());
            throw e;
        }
    }

    public LeaveRequest getLeaveRequest(String empId, String requestId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("empId", AttributeValue.builder().s(empId).build());
        key.put("requestId", AttributeValue.builder().s(requestId).build());

        GetItemRequest request = GetItemRequest.builder()
                .tableName(Constants.LEAVE_REQUEST_TABLE)
                .key(key)
                .build();

        try {
            GetItemResponse response = dynamoDbClient.getItem(request);
            if (response.hasItem()) {
                return mapToLeaveRequest(response.item());
            }
            return null;
        } catch (DynamoDbException e) {
            System.err.println("Error retrieving leave request: " + e.getMessage());
            throw e;
        }
    }

    public List<LeaveRequest> getEmployeeLeaveRequests(String empId) {
        Map<String, AttributeValue> expressionValues = new HashMap<>();
        expressionValues.put(":empId", AttributeValue.builder().s(empId).build());

        QueryRequest request = QueryRequest.builder()
                .tableName(Constants.LEAVE_REQUEST_TABLE)
                .keyConditionExpression("empId = :empId")
                .expressionAttributeValues(expressionValues)
                .build();

        try {
            QueryResponse response = dynamoDbClient.query(request);
            List<LeaveRequest> leaveRequests = new ArrayList<>();
            response.items().forEach(item -> leaveRequests.add(mapToLeaveRequest(item)));
            return leaveRequests;
        } catch (DynamoDbException e) {
            System.err.println("Error retrieving leave requests: " + e.getMessage());
            throw e;
        }
    }

    public void updateLeaveRequestStatus(String empId, String requestId, String status) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("empId", AttributeValue.builder().s(empId).build());
        key.put("requestId", AttributeValue.builder().s(requestId).build());

        Map<String, AttributeValueUpdate> updates = new HashMap<>();
        updates.put("status", AttributeValueUpdate.builder()
                .value(AttributeValue.builder().s(status).build())
                .action(AttributeAction.PUT)
                .build());

        UpdateItemRequest request = UpdateItemRequest.builder()
                .tableName(Constants.LEAVE_REQUEST_TABLE)
                .key(key)
                .attributeUpdates(updates)
                .build();

        try {
            dynamoDbClient.updateItem(request);
        } catch (DynamoDbException e) {
            System.err.println("Error updating leave request status: " + e.getMessage());
            throw e;
        }
    }

    private LeaveRequest mapToLeaveRequest(Map<String, AttributeValue> item) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmpId(item.get("empId").s());
        leaveRequest.setRequestId(item.get("requestId").s());
        leaveRequest.setStartDate(item.get("startDate").s());
        leaveRequest.setEndDate(item.get("endDate").s());
        leaveRequest.setReason(item.get("reason").s());
        leaveRequest.setStatus(item.get("status").s());
        return leaveRequest;
    }
}
