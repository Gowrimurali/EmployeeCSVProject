package com.spartaglobal.gm.DataBase;

public interface SQLInterface {
    public final String INSERT_TO_LARGE_DB = "INSERT INTO `employeerecords`.`employeerecordslarge` (`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`,`email`, `dob`, `doj`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
}
