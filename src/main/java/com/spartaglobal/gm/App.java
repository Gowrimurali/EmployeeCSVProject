package com.spartaglobal.gm;

public class App 
{
    public static void main(String[] args) {
        FileUtils.readFile("src/main/resources/EmployeeRecords.csv");
        Display.displayFiles();
        
    }
}

