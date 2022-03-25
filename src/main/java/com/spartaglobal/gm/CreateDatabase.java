package com.spartaglobal.gm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateDatabase {

    public static void createDatabase(String[] largeEmployeeRecordData, String csvPath, boolean isCorrupted){
        Connection connection = ConnectionManager.getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        if (csvPath.equals("src/main/resources/EmployeeRecords.csv")){
            if(isCorrupted) {
                String fileName = "employeerecordscorrupted";
                deleteFromEmployeeRecords(fileName);
                insertINTOEmployeeRecords(Integer.parseInt(largeEmployeeRecordData[0]), largeEmployeeRecordData[1], largeEmployeeRecordData[2], largeEmployeeRecordData[3], largeEmployeeRecordData[4], largeEmployeeRecordData[5], largeEmployeeRecordData[6], largeEmployeeRecordData[7], largeEmployeeRecordData[8], Integer.parseInt(largeEmployeeRecordData[9]), fileName);
            }else {
                String fileName = "employeerecordsuncorrupted";
                deleteFromEmployeeRecords(fileName);
                insertINTOEmployeeRecords(Integer.parseInt(largeEmployeeRecordData[0]), largeEmployeeRecordData[1], largeEmployeeRecordData[2], largeEmployeeRecordData[3], largeEmployeeRecordData[4], largeEmployeeRecordData[5], largeEmployeeRecordData[6], largeEmployeeRecordData[7], largeEmployeeRecordData[8], Integer.parseInt(largeEmployeeRecordData[9]), fileName);
            }
        }else{
            String fileName = "employeerecordslarge";
            deleteFromEmployeeRecords(fileName);
            insertINTOEmployeeRecords(Integer.parseInt(largeEmployeeRecordData[0]), largeEmployeeRecordData[1], largeEmployeeRecordData[2], largeEmployeeRecordData[3], largeEmployeeRecordData[4], largeEmployeeRecordData[5], largeEmployeeRecordData[6], largeEmployeeRecordData[7], largeEmployeeRecordData[8], Integer.parseInt(largeEmployeeRecordData[9]),fileName);
        }
        ConnectionManager.closeConnection();
    }

    public static void insertINTOEmployeeRecords(Integer id, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dob, String doj, Integer salary, String tableName){
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionManager.getConnection();
        String statement = "";
        String[] statementArr = {"INSERT INTO `employeerecords`.`",tableName,"` (`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`,`email`, `dob`, `doj`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"};
        statementConcat(statementArr, statement);
        try {
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, namePrefix);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, middleInitial);
            preparedStatement.setString(5, lastName);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, dob);
            preparedStatement.setString(9, doj);
            preparedStatement.setInt(10, salary);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void statementConcat(String[] statementArr, String statement) {
        for(String part : statementArr){
            statement.concat(part);
        }
    }

    public static void deleteFromEmployeeRecords(String tableName){

        String statement = "";
        String[] statementArr ={"DELETE FROM `employeerecords`.`","employeerecordslarge","`"};
        statementConcat(statementArr, statement);
        Connection connection = ConnectionManager.getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.closeConnection();
    }
}

