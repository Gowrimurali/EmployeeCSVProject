package com.spartaglobal.gm;

import com.spartaglobal.gm.Logs.Logger;

import java.sql.Connection;

public class App
{
    public static void main(String[] args) {
        Logger.createHandler();
        Logger.InfoMessage("Starting from main method");
        FileUtils.readFile("src/main/resources/EmployeeRecords.csv");
        Display.displayFiles();
//
////        FileUtils.readFile("src/main/resources/EmployeeRecords.csv");
//        double startTime = System.nanoTime();
//        FileReadForLargeRecord.readFile("src/main/resources/EmployeeRecordsLarge.csv");
//        double stopTime = System.nanoTime();
//        System.out.println(startTime);
//        System.out.println(stopTime);
//        System.out.println("Total time is: " + (stopTime-startTime));
//        Display.displayFiles();
//        CreateEmployeeLargeRecordDatabase.deleteFromEmployeeLargeRecords();


    }
}
