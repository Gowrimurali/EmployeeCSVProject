package com.spartaglobal.gm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckerTest {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    private EmployeeDTO newEmployee = new EmployeeDTO(609576,"Prof.","Ronny",'C',"Legault",'M',"ronny.legault@gmail.com",LocalDate.parse("4/30/1977",formatter),LocalDate.parse("5/2/2010",formatter),83203);

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.DisplayName("employeeID checker checks values have six digits")

    void employeeIDCheckerChecksValuesHaveSixDigits() {
        readFile();
        assertEquals(false, CheckerMethods.employeeIdChecker(EmployeeDTO.employees.get(1)));
        assertEquals(false, CheckerMethods.employeeIdChecker(EmployeeDTO.employees.get(0)));
        assertEquals(true, CheckerMethods.employeeIdChecker(newEmployee));
    }

    @Test
    @DisplayName("employeeID checker checks the employeeNum is not in the arrayList")
    void employeeIDCheckerChecksTheEmployeeNumIsNotInTheArrayList() {
        readFile();
        assertEquals(true, CheckerMethods.employeeIdChecker(newEmployee));
        assertEquals(false, CheckerMethods.employeeIdChecker(EmployeeDTO.employees.get(0)));
    }

    @Test
    @DisplayName("genderChecker checks for a valid gender for database")
    void genderCheckerChecksForAValidGenderForDataBase() {
        readFile();
        assertEquals(false,CheckerMethods.genderChecker(EmployeeDTO.employees.get(0)));
        assertEquals(true,CheckerMethods.genderChecker(EmployeeDTO.employees.get(1)));
        assertEquals(true,CheckerMethods.genderChecker(EmployeeDTO.employees.get(2)));

    }

    @Test
    @DisplayName("dateChecker checks for an invalid amount of days in a month")
    void dateCheckerChecksForAnInvalidAmountOfDaysInAMonth() {
        readFile();
        assertEquals(true,CheckerMethods.dateChecker(EmployeeDTO.employees.get(2)));
        assertEquals(false,CheckerMethods.dateChecker(EmployeeDTO.employees.get(3)));
        assertEquals(false,CheckerMethods.dateChecker(EmployeeDTO.employees.get(4)));
    }


    private void readFile(){
        FileUtils.readFile("src/main/resources/EmployeeTest.csv");
    }
}
