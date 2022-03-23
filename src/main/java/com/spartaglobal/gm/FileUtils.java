package com.spartaglobal.gm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {
    static void readFile(String fileName) {

        int count = 0;
        try {
            var fileReader = new FileReader(fileName);
            var bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] employeeData = line.split(",");
                String[] splitEmpNum = employeeData[0].split("");
                String[] splitSalary = employeeData[employeeData.length-1].split("");
                extractEmployeeNumber(employeeData, splitEmpNum);
                extractEmployeeSalary(employeeData, splitSalary);
                EmployeeDTO.employees.set(count, Arrays.toString(employeeData));
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractEmployeeSalary(String[] employeeData, String[] splitSalary) {
        String salary = "";
        for(int i = 0; i < splitSalary.length - 1; i++){
            salary.concat(splitSalary[i]);
        }
        employeeData[employeeData.length - 1] = salary;
    }

    private static void extractEmployeeNumber(String[] employeeData, String[] splitEmpNum) {
        String employeeNum = "";
        for(int i = 1; i < splitEmpNum.length; i++){
            employeeNum.concat(splitEmpNum[i]);
        }
        employeeData[0] = employeeNum;
    }
}
