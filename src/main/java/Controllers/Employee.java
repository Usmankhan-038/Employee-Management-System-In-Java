package Controllers;

public class Employee {

    private String sno;
    private String name;
    private String email;
    private String phone;
    private String position;
    private String gender;

    public Employee(int i, String sno, String name, String email, String phone, String position)
    {
        this.sno = sno;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.gender = gender;
    }
    public String getSno()
    {
        return sno;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPosition()
    {
        return position;
    }
    public String getPhone()
    {
        return phone;
    }
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "sno='" + sno + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", position='" + position + '\'' +
//                ", gender='" + gender + '\'' +
//                '}';
//    }

}
