# EmployeeCSVProject

This is the project for reading CSV files and filtering corrupted data. It then adds the data to MySQL.
The project also contains a test folder which does JUnit testinf to test the checker methods used to filter the corrupted and uncorrupted data. 
You will need to have a foldet containing CSV files and a .properties file which contains the url, username and password of the JDBC server. 
You will need to have a seperate test CSV file to test the checker methods.
The layout of the CSV files is shown: 
(`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`,`email`, `dob`, `doj`, `salary`)
