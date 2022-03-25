package com.spartaglobal.gm.Logs;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

public class Logger {
    public static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("sorterLogger");

    public static void createHandler(){
            try {
                Handler fileHandler = new FileHandler("src/main/java/com/spartaglobal/gm/Logs/EmployeeCSVLogs.log",true);
                logger.addHandler(fileHandler);
                fileHandler.setFormatter(new CustomFormatter());

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void InfoMessage(String Message){
        logger.log(Level.INFO,Message);
    }

    public static void warningMessage(String Message){
        logger.log(Level.WARNING,Message);
    }


}
