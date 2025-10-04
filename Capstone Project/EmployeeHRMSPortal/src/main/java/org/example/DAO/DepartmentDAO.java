package org.example.DAO;

import org.example.Config.Constants;
import org.example.Config.DynamoDBConfig;
import org.example.Model.Department;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.HashMap;
import java.util.Map;

public class DepartmentDAO {
    private final DynamoDbClient dynamoDbClient;

    public DepartmentDAO() {
        this.dynamoDbClient = DynamoDBConfig.getDynamoDbClient();
    }

    public void createDepartment(Department department) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("empId", AttributeValue.builder().s(department.getEmpId()).build());
        item.put("department", AttributeValue.builder().s(department.getDepartment()).build());
        item.put("designation", AttributeValue.builder().s(department.getDesignation()).build());
        item.put("dayWage", AttributeValue.builder().n(String.valueOf(department.getDayWage())).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(Constants.DEPARTMENT_TABLE)
                .item(item)
                .build();

        try {
            dynamoDbClient.putItem(request);
        } catch (DynamoDbException e) {
            System.err.println("Error creating department record: " + e.getMessage());
            throw e;
        }
    }

    public Department getDepartment(String empId) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("empId", AttributeValue.builder().s(empId).build());

        GetItemRequest request = GetItemRequest.builder()
                .tableName(Constants.DEPARTMENT_TABLE)
                .key(key)
                .build();

        try {
            GetItemResponse response = dynamoDbClient.getItem(request);
            if (response.hasItem()) {
                return mapToDepartment(response.item());
            }
            return null;
        } catch (DynamoDbException e) {
            System.err.println("Error retrieving department: " + e.getMessage());
            throw e;
        }
    }

    private Department mapToDepartment(Map<String, AttributeValue> item) {
        Department department = new Department();
        department.setEmpId(item.get("empId").s());
        department.setDepartment(item.get("department").s());
        department.setDesignation(item.get("designation").s());
        department.setDayWage(Double.parseDouble(item.get("dayWage").n()));
        return department;
    }
}
