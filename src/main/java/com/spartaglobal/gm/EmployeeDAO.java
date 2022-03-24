package com.spartaglobal.gm;

import java.sql.*;

public class EmployeeDAO {
    private Connection connection;
    private Statement statement;


    public EmployeeDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertINTOEMployeeRecordsLarge(Integer id, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dob, String doj, Integer salary){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO `employeerecords`.`employeerecordslarge` (`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`,`email`, `dob`, `doj`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,namePrefix);
            preparedStatement.setString(3,firstName);
            preparedStatement.setString(4,middleInitial);
            preparedStatement.setString(5,lastName);
            preparedStatement.setString(6,gender);
            preparedStatement.setString(7,email);
            preparedStatement.setString(8, dob);
            preparedStatement.setString(9,doj);
            preparedStatement.setInt(10,salary);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
