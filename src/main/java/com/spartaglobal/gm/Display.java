package com.spartaglobal.gm;

import java.util.ArrayList;

public class Display {
    public static void displayFiles(){
        System.out.println("Corrupted:");
        Display.displayList(EmployeeDTO.unCorruptedList);
        System.out.println("Uncorrupted:");
        Display.displayList(EmployeeDTO.corruptedList);
        System.out.println("Uncorrupted:");
        System.out.println(EmployeeDTO.unCorruptedList.size());
        System.out.println("Corrupted:");
        System.out.println(EmployeeDTO.corruptedList.size());
    }

    private static void displayList(ArrayList<EmployeeDTO> list){
        list.forEach((employee) -> System.out.println(employee.toString()));
    }

}
