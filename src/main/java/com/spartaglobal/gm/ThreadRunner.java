package com.spartaglobal.gm;

import java.util.ArrayList;

public class ThreadRunner {
    public static void runThreads(ArrayList<EmployeeDTO> employees) {

        int arrayLength = employees.size();

//        FileReadCopy.readFile("src/main/resources/EmployeeRecordsLarge.csv");
//        System.out.println(EmployeeDTO.employees);
        FileReadUsingThread f1 = new FileReadUsingThread(0, arrayLength/13);
        FileReadUsingThread f2 = new FileReadUsingThread(arrayLength/13+1, (arrayLength/13)*2);
        FileReadUsingThread f3 = new FileReadUsingThread(((arrayLength/13)*2)+1, (arrayLength/13)*3);
        FileReadUsingThread f4 = new FileReadUsingThread(((arrayLength/13)*3)+1, (arrayLength/13)*4);
        FileReadUsingThread f5 = new FileReadUsingThread(((arrayLength/13)*4)+1, (arrayLength/13)*5);
        FileReadUsingThread f6 = new FileReadUsingThread(((arrayLength/13)*5)+1, (arrayLength/13)*6);
        FileReadUsingThread f7 = new FileReadUsingThread(((arrayLength/13)*6)+1, (arrayLength/13)*7);
        FileReadUsingThread f8 = new FileReadUsingThread(((arrayLength/13)*7)+1, (arrayLength/13)*8);
        FileReadUsingThread f9 = new FileReadUsingThread(((arrayLength/13)*8)+1, (arrayLength/13)*9);
        FileReadUsingThread f10 = new FileReadUsingThread(((arrayLength/13)*9)+1, (arrayLength/13)*10);
        FileReadUsingThread f11 = new FileReadUsingThread(((arrayLength/13)*10)+1, (arrayLength/13)*11);
        FileReadUsingThread f12 = new FileReadUsingThread(((arrayLength/13)*11)+1, (arrayLength/13)*12);
        FileReadUsingThread f13 = new FileReadUsingThread(((arrayLength/13)*12)+1, arrayLength - 1);
        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
        f6.start();
        f7.start();
        f8.start();
        f9.start();
        f10.start();
        f11.start();
        f12.start();
        f13.start();
        try {
            f1.join();
            f2.join();
            f3.join();
            f4.join();
            f5.join();
            f6.join();
            f7.join();
            f8.join();
            f9.join();
            f10.join();
            f11.join();
            f12.join();
            f13.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
