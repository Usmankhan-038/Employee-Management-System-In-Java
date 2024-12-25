package Controllers;

public class Salary extends EmployeeData{
    private int salary;
    private int taxPercentage;
    private int medical_allowance;
    private int leave_charges;
    private int netSalary;

    public Salary(int salary, int taxPercentage, int medical_allowance, int leave_charges, int netSalary) {
        super(null);
        this.salary = salary;
        this.taxPercentage = taxPercentage;
        this.medical_allowance = medical_allowance;
        this.leave_charges = leave_charges;
        this.netSalary = netSalary;
    }



    public void netSalary() {
        int basicsalary = Integer.parseInt(getData("salary"));
        int tax = Integer.parseInt(getData("tax"));
        int medical_allowance = Integer.parseInt(getData("medical_allowance"));
        int leave_charges = Integer.parseInt(getData("charges"));
      int netSalary = (salary - (salary * taxPercentage) + medical_allowance) - leave_charges;
        this.salary = netSalary;
    }

    public int getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

//    public int getMedical_allowance() {
//        return medical_allowance;
//    }
//
//    public void setMedical_allowance(int medical_allowance) {
//        this.medical_allowance = medical_allowance;
//    }
//
//    public int getLeave_charges() {
//        return leave_charges;
//    }
//
//    public void setLeave_charges(int leave_charges) {
//        this.leave_charges = leave_charges;
//    }

    public int getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(int netSalary) {
        this.netSalary = netSalary;
    }
}
