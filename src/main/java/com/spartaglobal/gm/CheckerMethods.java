package com.spartaglobal.gm;

import static com.spartaglobal.gm.EmployeeDTO.employees;

public class CheckerMethods {

    public boolean employeeIdChecker(EmployeeDTO employee ){
        if (employee.getEmpID() <= 99999){
            return false;
        }
        for(int i = 0; i < employees.size(); i++){
            String values = employees.get(i);
            String[] splitValues = values.split(",");
            int employeeNum = Integer.parseInt(splitValues[0]);
            if(employeeNum == employee.getEmpID()){
                return false;
            }
        }
        return true;
    }
    public boolean genderChecker(EmployeeDTO employee){
        if (employee.getGender() == 'M' || employee.getGender() == 'F'){
            return true;
        }
        return false;
    }

}
