package com.spartaglobal.gm.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDatabase {

    public static void insertINTOEmployeeRecords(Integer id, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dob, String doj, Integer salary, PreparedStatement preparedStatement){
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

    private static String statementConcat(String[] statementArr, String statement) {
        String newStatement = "";
        for(String part : statementArr){
            newStatement = newStatement.concat(part);
        }
        return newStatement;
    }

    public static void deleteFromEmployeeRecords(String tableName){

        String statement = "";
        String[] statementArr ={"DELETE FROM `employeerecords`.`",tableName,"`"};
        statement = statementConcat(statementArr, statement);
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


