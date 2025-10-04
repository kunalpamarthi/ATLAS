package org.example.DAO;

import org.example.Config.Constants;
import org.example.Config.DynamoDBConfig;
import org.example.Model.Salary;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.HashMap;
import java.util.Map;

public class SalaryDAO {
    private final DynamoDbClient dynamoDbClient;

    public SalaryDAO() {
        this.dynamoDbClient = DynamoDBConfig.getDynamoDbClient();
    }

    public void createSalary(Salary salary) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("empId", AttributeValue.builder().s(salary.getEmpId()).build());
        item.put("month", AttributeValue.builder().s(salary.getMonth()).build());
        item.put("basic", AttributeValue.builder().n(String.valueOf(salary.getBasic())).build());
        item.put("pfContribution", AttributeValue.builder().n(String.valueOf(salary.getPfContribution())).build());
        item.put("hra", AttributeValue.builder().n(String.valueOf(salary.getHra())).build());
        item.put("netPay", AttributeValue.builder().n(String.valueOf(salary.getNetPay())).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(Constants.SALARY_TABLE)
                .item(item)
                .build();

        try {
            dynamoDbClient.putItem(request);
        } catch (DynamoDbException e) {
            System.err.println("Error creating salary record: " + e.getMessage());
            throw e;
        }
    }

    public Salary getSalary(String empId, String month) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("empId", AttributeValue.builder().s(empId).build());
        key.put("month", AttributeValue.builder().s(month).build());

        GetItemRequest request = GetItemRequest.builder()
                .tableName(Constants.SALARY_TABLE)
                .key(key)
                .build();

        try {
            GetItemResponse response = dynamoDbClient.getItem(request);
            if (response.hasItem()) {
                return mapToSalary(response.item());
            }
            return null;
        } catch (DynamoDbException e) {
            System.err.println("Error retrieving salary: " + e.getMessage());
            throw e;
        }
    }

    private Salary mapToSalary(Map<String, AttributeValue> item) {
        Salary salary = new Salary();
        salary.setEmpId(item.get("empId").s());
        salary.setMonth(item.get("month").s());
        salary.setBasic(Double.parseDouble(item.get("basic").n()));
        salary.setPfContribution(Double.parseDouble(item.get("pfContribution").n()));
        salary.setHra(Double.parseDouble(item.get("hra").n()));
        salary.setNetPay(Double.parseDouble(item.get("netPay").n()));
        return salary;
    }
}
