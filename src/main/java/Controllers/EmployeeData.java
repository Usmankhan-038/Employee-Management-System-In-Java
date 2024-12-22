package Controllers;

import java.util.HashMap;

public class EmployeeData {
    private HashMap<String, String> employeeData; // Holds employee data

    // Constructor to initialize employee data
    public EmployeeData(HashMap<String, String> employeeData) {
        this.employeeData = new HashMap<>(employeeData); // Create a new instance to avoid overwriting
    }


    // Getters for the fields
    public String getSno() {
        return employeeData.get("sno");
    }
    public String getId() {
        return employeeData.get("id");
    }

    public String getName() {
        return employeeData.get("name");
    }

    public String getEmail() {
        return employeeData.get("email");
    }

    public String getPhone() {
        return employeeData.get("phone");
    }

    public String getPosition() {
        return employeeData.get("position");
    }

    public String getGender() {
        return employeeData.get("gender");
    }

    public String getSalary() {
        return employeeData.get("salary");
    }

    // Method to display employee data (optional, for debugging)
    public static void showEmployeeData(EmployeeData employee) {
        System.out.println("Employee Data: " + employee.employeeData);
    }

}

