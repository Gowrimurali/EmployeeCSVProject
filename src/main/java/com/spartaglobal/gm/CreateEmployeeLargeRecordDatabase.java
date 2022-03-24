package com.spartaglobal.gm;

import java.sql.Connection;

public class CreateEmployeeLargeRecordDatabase {
    public static void createLargeRecordTable(String[] largeEmployeeRecordData) {
        Connection connection = ConnectionManager.getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        employeeDAO.insertINTOEMployeeRecordsLarge(Integer.parseInt(largeEmployeeRecordData[0]), largeEmployeeRecordData[1], largeEmployeeRecordData[2], largeEmployeeRecordData[3], largeEmployeeRecordData[4], largeEmployeeRecordData[5], largeEmployeeRecordData[6], largeEmployeeRecordData[7], largeEmployeeRecordData[8], Integer.parseInt(largeEmployeeRecordData[9]));
        ConnectionManager.closeConnection();
    }
}
