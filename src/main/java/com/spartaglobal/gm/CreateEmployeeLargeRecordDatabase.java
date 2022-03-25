package com.spartaglobal.gm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateEmployeeLargeRecordDatabase {
    public static void createLargeRecordTable(String[] largeEmployeeRecordData) {
        Connection connection = ConnectionManager.getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        PreparedStatement preparedStatement = null;
        employeeDAO.insertINTOEMployeeRecordsLarge(preparedStatement,Integer.parseInt(largeEmployeeRecordData[0]),
                largeEmployeeRecordData[1],
                largeEmployeeRecordData[2],
                largeEmployeeRecordData[3],
                largeEmployeeRecordData[4],
                largeEmployeeRecordData[5],
                largeEmployeeRecordData[6],
                largeEmployeeRecordData[7],
                largeEmployeeRecordData[8],
                Integer.parseInt(largeEmployeeRecordData[9]));


    }




    public static void deleteFromEmployeeLargeRecords(){
        Connection connection = ConnectionManager.getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM `employeerecords`.`employeerecordslarge`");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.closeConnection();
    }
}
