package Controllers;

import java.util.HashMap;

public class Attendence extends EmployeeData {
    private HashMap<String, String> attendanceData; // Holds attendance data specific to the employee

    // Constructor to initialize employee data and attendance details using a HashMap
    public Attendence(HashMap<String, String> attendanceData) {
        super(attendanceData);
        this.attendanceData = new HashMap<>(attendanceData); // Clone the data to avoid overwriting the original
    }

    // Getters and Setters using HashMap data
    public String getSno() {
        return attendanceData.get("sno");
    }

    public void setSno(String sno) {
        attendanceData.put("sno", sno);
    }

//    public String getEmployeeId() {
//        return attendanceData.get("employeeId");
//    }
//
//    public void setEmployeeId(String employeeId) {
//        attendanceData.put("employeeId", employeeId);
//    }
//
//    public String getEmployeeName() {
//        return attendanceData.get("employeeName");
//    }
//
//    public void setEmployeeName(String employeeName) {
//        attendanceData.put("employeeName", employeeName);
//    }
//
//    public String getPhoneNumber() {
//        return attendanceData.get("phoneNumber");
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        attendanceData.put("phoneNumber", phoneNumber);
//    }

    public boolean isOnLeave() {
        return Boolean.parseBoolean(attendanceData.getOrDefault("onLeave", "false"));
    }

    public void setOnLeave(boolean onLeave) {
        attendanceData.put("onLeave", String.valueOf(onLeave));
    }

    public boolean isPresent() {
        return Boolean.parseBoolean(attendanceData.getOrDefault("isPresent", "false"));
    }

    public void setPresent(boolean isPresent) {
        attendanceData.put("isPresent", String.valueOf(isPresent));
    }

    // Getter for the entire HashMap
    public HashMap<String, String> getAttendanceData() {
        return attendanceData;
    }

    // Setter for the entire HashMap
    public void setAttendanceData(HashMap<String, String> attendanceData) {
        this.attendanceData = attendanceData;
    }

    public String getAttendenceId() {
        return attendanceData.get("attendenceId");
    }

    public String getOnLeave() {
        return attendanceData.get("onLeave");
    }

    public String getIsPresent() {
        return attendanceData.get("isPresent");
    }

    public String getDate(){
        return attendanceData.get("date");
    }

    public String getComments(){
        return attendanceData.get("comments");
    }

    public String getStatus(){
      return attendanceData.get("status");
    }

    @Override
    public String toString() {
        return "Attendence{" +
                "attendanceData=" + attendanceData +
                '}';
    }
}
