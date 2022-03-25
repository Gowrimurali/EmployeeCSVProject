package com.spartaglobal.gm.Start;

import com.spartaglobal.gm.DataBase.CreateDatabase;
import com.spartaglobal.gm.DataBase.EmployeeDTO;
import com.spartaglobal.gm.DataBase.FileUtils;
import com.spartaglobal.gm.Logs.Logger;
import com.spartaglobal.gm.Thread.ThreadRunner;
import com.spartaglobal.gm.View.Display;

public class Start {
    public static void run (){
        Logger.InfoMessage("Starting");
        Logger.InfoMessage("Reading large employee record");
        FileUtils.readFile("src/main/resources/EmployeeRecordsLarge.csv");
        CreateDatabase.deleteFromEmployeeRecords("employeerecordslarge");
        double startTime = System.nanoTime();
        ThreadRunner.runThreads(EmployeeDTO.employees);
        double stopTime = System.nanoTime();
        System.out.println("Total time is: milliseconds " + (stopTime-startTime)/1000000);
        Logger.InfoMessage("Reading employee record");
        FileUtils.readFile("src/main/resources/EmployeeRecords.csv");
        Logger.InfoMessage("Display corrupted and uncorrupted");
        Display.displayFiles();
    }
}
