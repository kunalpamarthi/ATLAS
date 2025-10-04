package org.example.DAO;

import org.example.Config.Constants;
import org.example.Config.DynamoDBConfig;
import org.example.Model.Attendance;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
    private final DynamoDbClient dynamoDbClient;

    public AttendanceDAO() {
        this.dynamoDbClient = DynamoDBConfig.getDynamoDbClient();
    }

    public void markAttendance(Attendance attendance) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("empId", AttributeValue.builder().s(attendance.getEmpId()).build());
        item.put("date", AttributeValue.builder().s(attendance.getDate()).build());
        item.put("attendanceValue", AttributeValue.builder().n(String.valueOf(attendance.getAttendanceValue())).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(Constants.ATTENDANCE_TABLE)
                .item(item)
                .build();

        try {
            dynamoDbClient.putItem(request);
        } catch (DynamoDbException e) {
            System.err.println("Error marking attendance: " + e.getMessage());
            throw e;
        }
    }

    public Attendance getAttendance(String empId, String date) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("empId", AttributeValue.builder().s(empId).build());
        key.put("date", AttributeValue.builder().s(date).build());

        GetItemRequest request = GetItemRequest.builder()
                .tableName(Constants.ATTENDANCE_TABLE)
                .key(key)
                .build();

        try {
            GetItemResponse response = dynamoDbClient.getItem(request);
            if (response.hasItem()) {
                return mapToAttendance(response.item());
            }
            return null;
        } catch (DynamoDbException e) {
            System.err.println("Error retrieving attendance: " + e.getMessage());
            throw e;
        }
    }

    public List<Attendance> getMonthlyAttendance(String empId, String yearMonth) {
        Map<String, AttributeValue> expressionValues = new HashMap<>();
        expressionValues.put(":empId", AttributeValue.builder().s(empId).build());
        expressionValues.put(":yearMonth", AttributeValue.builder().s(yearMonth).build());

        QueryRequest request = QueryRequest.builder()
                .tableName(Constants.ATTENDANCE_TABLE)
                .keyConditionExpression("empId = :empId AND begins_with(date, :yearMonth)")
                .expressionAttributeValues(expressionValues)
                .build();

        try {
            QueryResponse response = dynamoDbClient.query(request);
            List<Attendance> attendanceList = new ArrayList<>();
            response.items().forEach(item -> attendanceList.add(mapToAttendance(item)));
            return attendanceList;
        } catch (DynamoDbException e) {
            System.err.println("Error retrieving monthly attendance: " + e.getMessage());
            throw e;
        }
    }

    private Attendance mapToAttendance(Map<String, AttributeValue> item) {
        Attendance attendance = new Attendance();
        attendance.setEmpId(item.get("empId").s());
        attendance.setDate(item.get("date").s());
        attendance.setAttendanceValue(Double.parseDouble(item.get("attendanceValue").n()));
        return attendance;
    }
}
