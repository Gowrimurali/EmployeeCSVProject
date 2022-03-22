package com.spartaglobal.gm;

public class Display {
    public static void displayFiles(EmployeeDTO employeeDTO){
        Display.displayCorruptedfiles(employeeDTO);
        Display.displayUncorruptedfiles(employeeDTO);
    }

    private static void displayCorruptedfiles(EmployeeDTO employeeDTO){
        if(employeeDTO.isCorrupted()){
            System.out.println(employeeDTO.toString());
        }

    }

    private static void displayUncorruptedfiles(EmployeeDTO employeeDTO){
        if(!employeeDTO.isCorrupted()){
            System.out.println(employeeDTO.toString());
        }
    }

}
