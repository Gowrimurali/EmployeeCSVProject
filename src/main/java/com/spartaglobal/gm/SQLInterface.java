package com.spartaglobal.gm;

public interface SQLInterface {
    public final String INSERT_TO_LARGE_DB = "INSERT INTO `employeerecords`.`employeerecordslarge` (`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`,`email`, `dob`, `doj`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public final String INSERT_TO_UNCORRUPTED_DB = "INSERT INTO `employeerecords`.`employeerecordsuncorrupted` (`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`,`email`, `dob`, `doj`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public final String INSERT_TO_CORRUPTED_DB = "INSERT INTO `employeerecords`.`employeerecordscorrupted` (`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`,`email`, `dob`, `doj`, `salary`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
}
