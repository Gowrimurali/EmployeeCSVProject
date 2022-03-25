package com.spartaglobal.gm.DataBase;

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


}
