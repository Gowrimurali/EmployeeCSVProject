package com.spartaglobal.gm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateDatabase {

    public static void createDatabase(ArrayList<EmployeeDTO> employees, String csvPath, boolean isCorrupted){

        Connection connection = ConnectionManager.getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        if (csvPath.equals("src/main/resources/EmployeeRecords.csv")){
            if(isCorrupted) {
                String fileName = "employeerecordscorrupted";
                insertINTOEmployeeRecords(employees.get(0).getEmpID(), employees.get(1).getNamePrefix(), employees.get(2).getFirstNAme(), String.valueOf(employees.get(3).getMiddleInitial()), employees.get(4).getLastName(), String.valueOf(employees.get(5).getGender()), employees.get(6).getEmail(), employees.get(7).getDob().toString(), employees.get(8).getDoj().toString(), employees.get(9).getSalary(), SQLInterface.INSERT_TO_CORRUPTED_DB);
            }else {
                String fileName = "employeerecordsuncorrupted";
                insertINTOEmployeeRecords(employees.get(0).getEmpID(), employees.get(1).getNamePrefix(), employees.get(2).getFirstNAme(), String.valueOf(employees.get(3).getMiddleInitial()), employees.get(4).getLastName(), String.valueOf(employees.get(5).getGender()), employees.get(6).getEmail(), employees.get(7).getDob().toString(), employees.get(8).getDoj().toString(), employees.get(9).getSalary(), SQLInterface.INSERT_TO_UNCORRUPTED_DB);
            }
        }else{
            String fileName = "employeerecordslarge";
            insertINTOEmployeeRecords(employees.get(0).getEmpID(), employees.get(1).getNamePrefix(), employees.get(2).getFirstNAme(), String.valueOf(employees.get(3).getMiddleInitial()), employees.get(4).getLastName(), String.valueOf(employees.get(5).getGender()), employees.get(6).getEmail(), employees.get(7).getDob().toString(), employees.get(8).getDoj().toString(), employees.get(9).getSalary(),SQLInterface.INSERT_TO_LARGE_DB);
        }
        ConnectionManager.closeConnection();
    }

    public static void insertINTOEmployeeRecords(Integer id, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dob, String doj, Integer salary, String statement){
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionManager.getConnection();
        try {
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
            preparedStatement.addBatch();
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
        String[] statementArr ={"DELETE FROM `employeerecords`.`",tableName,"`"};
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


