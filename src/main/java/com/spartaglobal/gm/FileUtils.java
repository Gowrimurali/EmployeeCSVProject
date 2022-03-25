package com.spartaglobal.gm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileUtils {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    static void readFile(String fileName) {
        try {
            EmployeeDTO.unCorruptedList.removeAll(EmployeeDTO.unCorruptedList);
            EmployeeDTO.corruptedList.removeAll(EmployeeDTO.corruptedList);
            EmployeeDTO.employees.removeAll(EmployeeDTO.employees);
            var fileReader = new FileReader(fileName);
            var bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            if(fileName.equals("src/main/resources/EmployeeRecords.csv")){
                while (line != null) {
                    String[] employeeData = line.split(",");
                    EmployeeDTO employeeDTO = new EmployeeDTO(getIntEmpID(employeeData[0]), employeeData[1], employeeData[2], getCharMiddleInitial(employeeData[3]), employeeData[4], getCharGender(employeeData[5]), employeeData[6], getLocalDateDoB(employeeData[7]), getLocalDateDoJ(employeeData[8]), getIntSalary(employeeData[9]));
                    if (CheckerMethods.employeeIdChecker(employeeDTO) && CheckerMethods.genderChecker(employeeDTO)) {
                        if (CheckerMethods.dateChecker(employeeDTO)) {
                            EmployeeDTO.unCorruptedList.add(employeeDTO);
                        } else {
                            EmployeeDTO.corruptedList.add(employeeDTO);
                        }
                    } else {
                        EmployeeDTO.corruptedList.add(employeeDTO);
                    }
                    EmployeeDTO.employees.add(employeeDTO);
                    line = bufferedReader.readLine();
                }
            }else{
                while (line != null) {
                    String[] employeeData = line.split(",");
                    EmployeeDTO employeeDTO = new EmployeeDTO(getIntEmpID(employeeData[0]), employeeData[1], employeeData[2], getCharMiddleInitial(employeeData[3]), employeeData[4], getCharGender(employeeData[5]), employeeData[6], getLocalDateDoB(employeeData[7]), getLocalDateDoJ(employeeData[8]),getIntSalary(employeeData[9]));
                    EmployeeDTO.employees.add(employeeDTO);
                    line = bufferedReader.readLine();
                }
            }






        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getIntEmpID(String empID){
        return Integer.parseInt(empID);
    }

    private static char getCharMiddleInitial(String middleInitial){
        return middleInitial.charAt(0);
    }

    private static char getCharGender(String gender){
        return gender.charAt(0);
    }

    private static LocalDate getLocalDateDoB(String dob){

        return LocalDate.parse(dob,formatter);
    }

    private static LocalDate getLocalDateDoJ(String doj){
        return LocalDate.parse(doj,formatter);
    }

    private static int getIntSalary(String salary){
        return Integer.parseInt(salary);
    }

}
