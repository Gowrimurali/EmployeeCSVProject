package com.spartaglobal.gm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

public class FileReadForLargeRecord {
        static void readFile(String fileName){
            try {
                var fileReader = new FileReader(fileName);
                var bufferedReader = new BufferedReader(fileReader);
                bufferedReader.readLine();
                String line = bufferedReader.readLine();
                while (line != null) {
                    String[] largeEmployeeRecordData = line.split(",");
//                    insertINTOEMployeeRecordsLarge(Integer.parseInt(largeEmployeeRecordData[0]), largeEmployeeRecordData[1], largeEmployeeRecordData[2], largeEmployeeRecordData[3], largeEmployeeRecordData[4], largeEmployeeRecordData[5], largeEmployeeRecordData[6], largeEmployeeRecordData[7], largeEmployeeRecordData[8], Integer.parseInt(largeEmployeeRecordData[9]));
                    CreateEmployeeLargeRecordDatabase.createLargeRecordTable(largeEmployeeRecordData);
                    line = bufferedReader.readLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

