package com.spartaglobal.gm;
//Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary


import java.time.LocalDate;

public class EmployeeDTO {
        private int postition;
        private int empID;
        private String namePrefix;
        private String firstNAme;
        private char middleInitial;
        private String lastName;
        private char gender;
        private String email;
        private LocalDate dob;
        private LocalDate doj;
        private int salary;
        private boolean isCorrupted;


    public EmployeeDTO(int empID, String namePrefix, String firstNAme, char middleInitial, String lastName, char gender, String email, LocalDate dob, LocalDate doj, int salary, int postition, boolean isCorrupted) {
        this.postition = postition;
        this.empID = empID;
        this.namePrefix = namePrefix;
        this.firstNAme = firstNAme;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.doj = doj;
        this.salary = salary;
        this.isCorrupted = isCorrupted;
    }

    public int getEmpID() {
        return empID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isCorrupted() {
        return isCorrupted;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empID=" + empID +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstNAme='" + firstNAme + '\'' +
                ", middleInitial=" + middleInitial +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", doj=" + doj +
                ", salary=" + salary +
                '}';
    }
}


