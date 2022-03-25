package com.spartaglobal.gm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileReadUsingThread extends Thread{

    private final int startPosition;
    private final int endPosition;

    public FileReadUsingThread(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public void createLargeRecordTable() {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = connection.prepareStatement(SQLInterface.INSERT_TO_LARGE_DB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        for (int i = startPosition; i<=endPosition; i++) {
            EmployeeDTO employee = EmployeeDTO.employees.get(i);
            synchronized (employeeDAO){

            CreateDatabase.insertINTOEmployeeRecords(employee.getEmpID(),
                    employee.getNamePrefix(),
                    employee.getFirstNAme(),
                    String.valueOf(employee.getMiddleInitial()),
                    employee.getLastName(),
                    String.valueOf(employee.getGender()),
                    employee.getEmail(),
                    employee.getDob().toString(),
                    employee.getDoj().toString(),
                    employee.getSalary(),SQLInterface.INSERT_TO_LARGE_DB);
            }
        }

        try {
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void run() {
        createLargeRecordTable();
    }
}
