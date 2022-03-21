package com.spartaglobal.gm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {
    static void readFile(String fileName) {
        try {
            var fileReader = new FileReader(fileName);
            var bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] employeeData = line.split(",");
                System.out.println(Arrays.toString(employeeData));
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
