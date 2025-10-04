package org.example.Util;

import org.example.Config.DynamoDBConfig;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

public class TableInitializer {
    private final DynamoDbClient dynamoDbClient;

    public TableInitializer() {
        this.dynamoDbClient = DynamoDBConfig.getDynamoDbClient();
    }

    public void initializeTables() {
        createEmployeeTable();
        createDepartmentTable();
        createAttendanceTable();
        createLeaveRequestTable();
        createSalaryTable();
        System.out.println("All tables initialized successfully!");
    }

    private void createEmployeeTable() {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName("Employee")
                .keySchema(
                        KeySchemaElement.builder().attributeName("empId").keyType(KeyType.HASH).build()
                )
                .attributeDefinitions(
                        AttributeDefinition.builder().attributeName("empId").attributeType(ScalarAttributeType.S).build()
                )
                .provisionedThroughput(
                        ProvisionedThroughput.builder().readCapacityUnits(5L).writeCapacityUnits(5L).build()
                )
                .build();

        createTable(request);
    }

    private void createDepartmentTable() {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName("Department")
                .keySchema(
                        KeySchemaElement.builder().attributeName("empId").keyType(KeyType.HASH).build()
                )
                .attributeDefinitions(
                        AttributeDefinition.builder().attributeName("empId").attributeType(ScalarAttributeType.S).build()
                )
                .provisionedThroughput(
                        ProvisionedThroughput.builder().readCapacityUnits(5L).writeCapacityUnits(5L).build()
                )
                .build();

        createTable(request);
    }

    private void createAttendanceTable() {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName("Attendance")
                .keySchema(
                        KeySchemaElement.builder().attributeName("empId").keyType(KeyType.HASH).build(),
                        KeySchemaElement.builder().attributeName("date").keyType(KeyType.RANGE).build()
                )
                .attributeDefinitions(
                        AttributeDefinition.builder().attributeName("empId").attributeType(ScalarAttributeType.S).build(),
                        AttributeDefinition.builder().attributeName("date").attributeType(ScalarAttributeType.S).build()
                )
                .provisionedThroughput(
                        ProvisionedThroughput.builder().readCapacityUnits(5L).writeCapacityUnits(5L).build()
                )
                .build();

        createTable(request);
    }

    private void createLeaveRequestTable() {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName("LeaveRequest")
                .keySchema(
                        KeySchemaElement.builder().attributeName("empId").keyType(KeyType.HASH).build(),
                        KeySchemaElement.builder().attributeName("requestId").keyType(KeyType.RANGE).build()
                )
                .attributeDefinitions(
                        AttributeDefinition.builder().attributeName("empId").attributeType(ScalarAttributeType.S).build(),
                        AttributeDefinition.builder().attributeName("requestId").attributeType(ScalarAttributeType.S).build()
                )
                .provisionedThroughput(
                        ProvisionedThroughput.builder().readCapacityUnits(5L).writeCapacityUnits(5L).build()
                )
                .build();

        createTable(request);
    }

    private void createSalaryTable() {
        CreateTableRequest request = CreateTableRequest.builder()
                .tableName("Salary")
                .keySchema(
                        KeySchemaElement.builder().attributeName("empId").keyType(KeyType.HASH).build(),
                        KeySchemaElement.builder().attributeName("month").keyType(KeyType.RANGE).build()
                )
                .attributeDefinitions(
                        AttributeDefinition.builder().attributeName("empId").attributeType(ScalarAttributeType.S).build(),
                        AttributeDefinition.builder().attributeName("month").attributeType(ScalarAttributeType.S).build()
                )
                .provisionedThroughput(
                        ProvisionedThroughput.builder().readCapacityUnits(5L).writeCapacityUnits(5L).build()
                )
                .build();

        createTable(request);
    }

    private void createTable(CreateTableRequest request) {
        try {
            dynamoDbClient.createTable(request);
            System.out.println("Created table: " + request.tableName());
        } catch (ResourceInUseException e) {
            System.out.println("Table already exists: " + request.tableName());
        } catch (Exception e) {
            System.err.println("Error creating table " + request.tableName() + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TableInitializer initializer = new TableInitializer();
        initializer.initializeTables();
    }
}
