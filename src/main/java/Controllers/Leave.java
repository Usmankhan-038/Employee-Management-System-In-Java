package Controllers;

import java.util.HashMap;

public class Leave extends EmployeeData{

    private HashMap<String, String> leaveData; // Holds employee data

    // Constructor to initialize employee data

    public Leave(HashMap<String, String> employeeData) {
        super(employeeData);
        this.leaveData = new HashMap<>(employeeData); // Create a new instance to avoid overwriting
    }


    //setters for the fields
    public void setApproved(boolean isApproved) {
        leaveData.put("isApproved", isApproved ? "1" : "0");
    }

    public void setRejected(boolean isRejected) {
        leaveData.put("isRejected", isRejected ? "1" : "0");
    }
    // Getters for the fields
    public String getSno() {
        return leaveData.get("sno");
    }

    public Integer getLeaveId() {
        return Integer.parseInt(leaveData.get("leave_id"));
    }

    public String getEmployeeName() {
        return leaveData.get("emp_name");
    }

    public String getLeaveType() {
        return leaveData.get("leave_type");
    }

    public String getLeaveDate() {
        return leaveData.get("leave_date");
    }

    public String getLeaveReason() {

        return leaveData.get("reason");
    }
    public String getEmployeeId() {

        return leaveData.get("emp_id");
    }
    public Boolean isApproved() {
        return leaveData.get("isApproved").equals("1");
    }

    public Boolean isRejected() {
        return leaveData.get("isRejected").equals("1");
    }



    // Method to display employee data (optional, for debugging)
//
}
