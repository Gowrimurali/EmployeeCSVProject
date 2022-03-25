package com.spartaglobal.gm;

public interface SQLInterface {
    public final String INSERT_TO_DB = "INSERT INTO `employeerecords`.`employeerecordslarge` (`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`,`email`, `dob`, `doj`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
}
