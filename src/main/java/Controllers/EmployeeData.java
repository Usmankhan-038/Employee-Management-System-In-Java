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

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "sno='" + employeeData.get("sno") + '\'' +
//                ", name='" + employeeData.get("name") + '\'' +
//                ", email='" + employeeData.get("email") + '\'' +
//                ", phone='" + employeeData.get("phone") + '\'' +
//                ", position='" + employeeData.get("position") + '\'' +
//                ", gender='" + employeeData.get("gender") + '\'' +
//                '}';
//    }
}

//
//package Controllers;
//
//import java.util.HashMap;
//
//public class EmployeeData {
//    private String sno;
//    private String id;
//    private String name;
//    private String email;
//    private String phone;
//    private String position;
//    private String gender;
//    private String action;
//
//    public EmployeeData(HashMap<String, String> data) {
//        this.sno = data.get("sno");
//        this.id = data.get("id");
//        this.name = data.get("name");
//        this.email = data.get("email");
//        this.phone = data.get("phone");
//        this.position = data.get("position");
//        this.gender = data.get("gender");
//        this.action = data.get("action");
//    }
//
//    // Getters
//    public String getSno() { return sno; }
//    public String getId() { return id; }
//    public String getName() { return name; }
//    public String getEmail() { return email; }
//    public String getPhone() { return phone; }
//    public String getPosition() { return position; }
//    public String getGender() { return gender; }
//    public String getAction() { return action; }
//
//    // Setters
//    public void setSno(String sno) { this.sno = sno; }
//    public void setId(String id) { this.id = id; }
//    public void setName(String name) { this.name = name; }
//    public void setEmail(String email) { this.email = email; }
//    public void setPhone(String phone) { this.phone = phone; }
//    public void setPosition(String position) { this.position = position; }
//    public void setGender(String gender) { this.gender = gender; }
//    public void setAction(String action) { this.action = action; }
//
//    // Helper method to get all data as HashMap
//    public HashMap<String, String> getEmployeeData() {
//        HashMap<String, String> data = new HashMap<>();
//        data.put("sno", this.sno);
//        data.put("id", this.id);
//        data.put("name", this.name);
//        data.put("email", this.email);
//        data.put("phone", this.phone);
//        data.put("position", this.position);
//        data.put("gender", this.gender);
//        data.put("action", this.action);
//        return data;
//    }

//    @Override
//    public String toString() {
//        return "EmployeeData{" +
//                "sno='" + sno + '\'' +
//                ", id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", position='" + position + '\'' +
//                ", gender='" + gender + '\'' +
//                ", action='" + action + '\'' +
//                '}';
//    }
//}



//package Controllers;
//
//public class EmployeeData {
//    private Integer sno;
//    private Integer id;
//    private String name;
//    private String email;
//    private String gender;
//    private String phone;
//    private String position;
//
//    private Double salary;
//
//    public EmployeeData(Integer sno,Integer employeeId, String name, String email, String gender, String phoneNum, String position){
//        this.sno = sno;
//        this.id = employeeId;
//        this.name = name;
//        this.email = email;
//        this.gender = gender;
//        this.phone = phoneNum;
//        this.position = position;
//
//    }
//    public EmployeeData(Integer sno,int employeeId, String firstName, String lastName,String position, Double salary){
//        this.sno = sno;
//        this.id = employeeId;
//        this.name = firstName;
//        this.email = lastName;
//        this.position = position;
//        this.salary = salary;
//    }
//
//    public EmployeeData(int id, String name, String email, String phone, String gender, String position) {
//    }
//
//
//    public Integer getId(){
//        return id;
//    }
//    public Integer getSno(){
//        return sno;
//    }
//    public String getName(){
//        return name;
//    }
//    public String getEmail(){
//        return email;
//    }
//    public String getGender(){
//        return gender;
//    }
//    public String getPhone(){
//        return phone;
//    }
//    public String getPosition(){
//        return position;
//    }
//
//    public Double getSalary(){
//        return salary;
//    }
//
////    @Override
////    public String toString() {
////        return "Employee{" +
////                "sno='" + employeeData.get("sno") + '\'' +
////                ", name='" + employeeData.get("name") + '\'' +
////                ", email='" + employeeData.get("email") + '\'' +
////                ", phone='" + employeeData.get("phone") + '\'' +
////                ", position='" + employeeData.get("position") + '\'' +
////                ", gender='" + employeeData.get("gender") + '\'' +
////                '}';
////    }
//}