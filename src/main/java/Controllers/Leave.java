package Controllers;

import java.util.HashMap;

public class Leave {

    private HashMap<String, String> leaveData; // Holds employee data

    // Constructor to initialize employee data
    public Leave(HashMap<String, String> employeeData) {
        this.leaveData = new HashMap<>(employeeData); // Create a new instance to avoid overwriting
    }

    // Getters for the fields
    public String getSno() {
        return leaveData.get("sno");
    }
    public String getLeaveId() {
        return leaveData.get("leave_id");
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



    // Method to display employee data (optional, for debugging)
//
}
