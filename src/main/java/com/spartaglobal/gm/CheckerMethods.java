package com.spartaglobal.gm;

import static com.spartaglobal.gm.EmployeeDTO.employees;

public class CheckerMethods {

    public boolean employeeIdChecker(EmployeeDTO employee ){
        for(int i = 0; i < employees.size(); i++){
            String values = employees.get(i);
            String[] splitValues = values.split(",");
            int employeeNum = Integer.parseInt(splitValues[0]);
            if(employeeNum == employee.getEmpID()){
                return true;
            }
        }
        return false;
    }
}
