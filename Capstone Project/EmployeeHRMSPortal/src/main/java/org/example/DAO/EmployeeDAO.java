package org.example.DAO;

import org.example.Config.Constants;
import org.example.Config.DynamoDBConfig;
import org.example.Model.Employee;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAO {
    private final DynamoDbClient dynamoDbClient;

    public EmployeeDAO() {
        this.dynamoDbClient = DynamoDBConfig.getDynamoDbClient();
    }

    public List<Employee> getAllActiveEmployees() {
        try {
            // Create a scan request with a filter for active status
            Map<String, String> expressionAttributeNames = new HashMap<>();
            expressionAttributeNames.put("#s", "status");

            Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
            expressionAttributeValues.put(":statusValue", AttributeValue.builder().s("ACTIVE").build());

            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(Constants.EMPLOYEE_TABLE)
                    .filterExpression("#s = :statusValue")
                    .expressionAttributeNames(expressionAttributeNames)
                    .expressionAttributeValues(expressionAttributeValues)
                    .build();

            ScanResponse response = dynamoDbClient.scan(scanRequest);
            List<Employee> activeEmployees = new ArrayList<>();

            // Process the results
            for (Map<String, AttributeValue> item : response.items()) {
                activeEmployees.add(mapToEmployee(item));
            }

            // Handle pagination if there are more results
            while (response.hasLastEvaluatedKey()) {
                scanRequest = scanRequest.toBuilder()
                        .exclusiveStartKey(response.lastEvaluatedKey())
                        .build();
                response = dynamoDbClient.scan(scanRequest);
                for (Map<String, AttributeValue> item : response.items()) {
                    activeEmployees.add(mapToEmployee(item));
                }
            }

            System.out.println("Retrieved " + activeEmployees.size() + " active employees");
            return activeEmployees;

        } catch (DynamoDbException e) {
            System.err.println("Error retrieving active employees: " + e.getMessage());
            throw e;
        }
    }

    public void createEmployee(Employee employee) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("empId", AttributeValue.builder().s(employee.getEmpId()).build());
        item.put("empName", AttributeValue.builder().s(employee.getEmpName()).build());
        item.put("mobileNum", AttributeValue.builder().s(employee.getMobileNum()).build());
        item.put("emailId", AttributeValue.builder().s(employee.getEmailId()).build());
        item.put("status", AttributeValue.builder().s("ACTIVE").build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(Constants.EMPLOYEE_TABLE)
                .item(item)
                .build();

        try {
            dynamoDbClient.putItem(request);
        } catch (DynamoDbException e) {
            System.err.println("Error creating employee: " + e.getMessage());
            throw e;
        }
    }

    public Employee getEmployee(String empId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("empId", AttributeValue.builder().s(empId).build());

        GetItemRequest request = GetItemRequest.builder()
                .tableName(Constants.EMPLOYEE_TABLE)
                .key(key)
                .build();

        try {
            GetItemResponse response = dynamoDbClient.getItem(request);
            if (response.hasItem()) {
                return mapToEmployee(response.item());
            }
            return null;
        } catch (DynamoDbException e) {
            System.err.println("Error retrieving employee: " + e.getMessage());
            throw e;
        }
    }

    public void updateEmployee(Employee employee) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("empId", AttributeValue.builder().s(employee.getEmpId()).build());

        Map<String, AttributeValueUpdate> updates = new HashMap<>();
        updates.put("empName", AttributeValueUpdate.builder()
                .value(AttributeValue.builder().s(employee.getEmpName()).build())
                .action(AttributeAction.PUT)
                .build());
        updates.put("mobileNum", AttributeValueUpdate.builder()
                .value(AttributeValue.builder().s(employee.getMobileNum()).build())
                .action(AttributeAction.PUT)
                .build());
        updates.put("emailId", AttributeValueUpdate.builder()
                .value(AttributeValue.builder().s(employee.getEmailId()).build())
                .action(AttributeAction.PUT)
                .build());

        UpdateItemRequest request = UpdateItemRequest.builder()
                .tableName(Constants.EMPLOYEE_TABLE)
                .key(key)
                .attributeUpdates(updates)
                .build();

        try {
            dynamoDbClient.updateItem(request);
        } catch (DynamoDbException e) {
            System.err.println("Error updating employee: " + e.getMessage());
            throw e;
        }
    }

    public void deleteEmployee(String empId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("empId", AttributeValue.builder().s(empId).build());

        DeleteItemRequest request = DeleteItemRequest.builder()
                .tableName(Constants.EMPLOYEE_TABLE)
                .key(key)
                .build();

        try {
            dynamoDbClient.deleteItem(request);
        } catch (DynamoDbException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
            throw e;
        }
    }

    private Employee mapToEmployee(Map<String, AttributeValue> item) {
        Employee employee = new Employee();
        employee.setEmpId(item.get("empId").s());
        employee.setEmpName(item.get("empName").s());
        employee.setMobileNum(item.get("mobileNum").s());
        employee.setEmailId(item.get("emailId").s());
        employee.setStatus(item.containsKey("status") ? item.get("status").s() : "ACTIVE");
        return employee;
    }

//    public void updateEmployeeStatus(String empId, String status) {
//        Map<String, AttributeValue> key = new HashMap<>();
//        key.put("empId", AttributeValue.builder().s(empId).build());
//
//        Map<String, AttributeValueUpdate> updates = new HashMap<>();
//        updates.put("status", AttributeValueUpdate.builder()
//                .value(AttributeValue.builder().s(status).build())
//                .action(AttributeAction.PUT)
//                .build());
//
//        UpdateItemRequest request = UpdateItemRequest.builder()
//                .tableName(Constants.EMPLOYEE_TABLE)
//                .key(key)
//                .attributeUpdates(updates)
//                .build();
//
//        try {
//            dynamoDbClient.updateItem(request);
//            System.out.println("Updated status for employee " + empId + " to " + status);
//        } catch (DynamoDbException e) {
//            System.err.println("Error updating employee status: " + e.getMessage());
//            throw e;
//        }
//    }

}
