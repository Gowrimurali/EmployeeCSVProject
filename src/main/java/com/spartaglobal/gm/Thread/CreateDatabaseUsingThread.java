package com.spartaglobal.gm.Thread;
import com.spartaglobal.gm.DataBase.ConnectionManager;
import com.spartaglobal.gm.DataBase.CreateDatabase;
import com.spartaglobal.gm.DataBase.EmployeeDTO;
import com.spartaglobal.gm.DataBase.SQLInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDatabaseUsingThread extends Thread{

    private final int startPosition;
    private final int endPosition;

    public CreateDatabaseUsingThread(int startPosition, int endPosition) {
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
        insertAll(preparedStatement);
        try {
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertAll(PreparedStatement preparedStatement) {
        for (int i = startPosition; i<=endPosition; i++) {
            EmployeeDTO employee = EmployeeDTO.employees.get(i);
            synchronized (employee){
            CreateDatabase.insertINTOEmployeeRecords(employee.getEmpID(),
                    employee.getNamePrefix(),
                    employee.getFirstNAme(),
                    String.valueOf(employee.getMiddleInitial()),
                    employee.getLastName(),
                    String.valueOf(employee.getGender()),
                    employee.getEmail(),
                    employee.getDob().toString(),
                    employee.getDoj().toString(),
                    employee.getSalary(), preparedStatement);
            }
        }
    }


    @Override
    public void run() {
        createLargeRecordTable();
    }
}
