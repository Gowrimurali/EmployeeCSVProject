package com.spartaglobal.gm;

import java.time.LocalDate;

import static com.spartaglobal.gm.EmployeeDTO.employees;

public class CheckerMethods {

    public static boolean employeeIdChecker(EmployeeDTO employee){
        if (employee.getEmpID() <= 99999 && employee.getEmpID() >= 1000000){
            return false;
        }
        for(int i = 0; i < employees.size(); i++){
            EmployeeDTO values = employees.get(i);
            int employeeNum = values.getEmpID();
            if(employeeNum == employee.getEmpID()){
                return false;
            }
        }
        return true;
    }

    public static boolean genderChecker(EmployeeDTO employee){
        if (employee.getGender() == 'M' || employee.getGender() == 'F'){
            return true;
        }
        return false;
    }

    public static boolean dateChecker(EmployeeDTO employee){
        LocalDate dateOfBirth = employee.getDob();
        if(dateOfBirth.getDayOfMonth() >= dateOfBirth.lengthOfMonth()){
            return false;
        }
        return true;
    }
}
