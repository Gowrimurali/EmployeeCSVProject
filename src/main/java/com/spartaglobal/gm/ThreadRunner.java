package com.spartaglobal.gm;

public class ThreadRunner {
    public static void runThreads() {
        FileReadCopy.readFile("src/main/resources/EmployeeRecordsLarge.csv");
//        System.out.println(EmployeeDTO.employees);
        FileReadUsingThread f1 = new FileReadUsingThread(0, 5038);
        FileReadUsingThread f2 = new FileReadUsingThread(5039, 10076);
        FileReadUsingThread f3 = new FileReadUsingThread(10077, 15114);
        FileReadUsingThread f4 = new FileReadUsingThread(15115, 20152);
        FileReadUsingThread f5 = new FileReadUsingThread(20153, 25190);
        FileReadUsingThread f6 = new FileReadUsingThread(25191, 30228);
        FileReadUsingThread f7 = new FileReadUsingThread(30229, 35266);
        FileReadUsingThread f8 = new FileReadUsingThread(35267, 40305);
        FileReadUsingThread f9 = new FileReadUsingThread(40306, 45344);
        FileReadUsingThread f10 = new FileReadUsingThread(45345, 50383);
        FileReadUsingThread f11 = new FileReadUsingThread(50384, 55422);
        FileReadUsingThread f12 = new FileReadUsingThread(55423, 60428);
        FileReadUsingThread f13 = new FileReadUsingThread(60429, 65498);
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
