package com.spartaglobal.gm.Thread;

import com.spartaglobal.gm.DataBase.EmployeeDTO;

import java.util.ArrayList;

public class ThreadRunner {
    public static void runThreads(ArrayList<EmployeeDTO> employees) {
        int arrayLength = employees.size();
        CreateDatabaseUsingThread f1 = new CreateDatabaseUsingThread(0, arrayLength/13);
        CreateDatabaseUsingThread f2 = new CreateDatabaseUsingThread(arrayLength/13+1, (arrayLength/13)*2);
        CreateDatabaseUsingThread f3 = new CreateDatabaseUsingThread(((arrayLength/13)*2)+1, (arrayLength/13)*3);
        CreateDatabaseUsingThread f4 = new CreateDatabaseUsingThread(((arrayLength/13)*3)+1, (arrayLength/13)*4);
        CreateDatabaseUsingThread f5 = new CreateDatabaseUsingThread(((arrayLength/13)*4)+1, (arrayLength/13)*5);
        CreateDatabaseUsingThread f6 = new CreateDatabaseUsingThread(((arrayLength/13)*5)+1, (arrayLength/13)*6);
        CreateDatabaseUsingThread f7 = new CreateDatabaseUsingThread(((arrayLength/13)*6)+1, (arrayLength/13)*7);
        CreateDatabaseUsingThread f8 = new CreateDatabaseUsingThread(((arrayLength/13)*7)+1, (arrayLength/13)*8);
        CreateDatabaseUsingThread f9 = new CreateDatabaseUsingThread(((arrayLength/13)*8)+1, (arrayLength/13)*9);
        CreateDatabaseUsingThread f10 = new CreateDatabaseUsingThread(((arrayLength/13)*9)+1, (arrayLength/13)*10);
        CreateDatabaseUsingThread f11 = new CreateDatabaseUsingThread(((arrayLength/13)*10)+1, (arrayLength/13)*11);
        CreateDatabaseUsingThread f12 = new CreateDatabaseUsingThread(((arrayLength/13)*11)+1, (arrayLength/13)*12);
        CreateDatabaseUsingThread f13 = new CreateDatabaseUsingThread(((arrayLength/13)*12)+1, arrayLength - 1);
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
