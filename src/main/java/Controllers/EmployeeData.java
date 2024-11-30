package Controllers;

import java.util.HashMap;

public class EmployeeData {
    HashMap<String, String> employee = new HashMap<String, String>();



    public void EmployeeData(HashMap<String, String> employeeData) {
        employeeData.forEach((key, value) -> {
            this.employee.put(key, value);
        });
    }

    public HashMap<String, String> getEmployeeData() {
        return employee;
    }
}
