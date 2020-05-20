package entity;

public class Employee implements SuperEntity {

    private String Emp_ID;
    private String NIC;
    private String Position;
    private String Monthly_Sal;
    private String Branch;
    private String Date_of_Recruited;
    private String Grade;

    public Employee(String emp_ID, String NIC, String position, String monthly_Sal, String branch, String date_of_Recruited, String grade) {
        Emp_ID = emp_ID;
        this.NIC = NIC;
        Position = position;
        Monthly_Sal = monthly_Sal;
        Branch = branch;
        Date_of_Recruited = date_of_Recruited;
        Grade = grade;
    }

    public Employee() {
    }

    public String getEmp_ID() {
        return Emp_ID;
    }

    public void setEmp_ID(String emp_ID) {
        Emp_ID = emp_ID;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getMonthly_Sal() {
        return Monthly_Sal;
    }

    public void setMonthly_Sal(String monthly_Sal) {
        Monthly_Sal = monthly_Sal;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getDate_of_Recruited() {
        return Date_of_Recruited;
    }

    public void setDate_of_Recruited(String date_of_Recruited) {
        Date_of_Recruited = date_of_Recruited;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Emp_ID='" + Emp_ID + '\'' +
                ", NIC='" + NIC + '\'' +
                ", Position='" + Position + '\'' +
                ", Monthly_Sal='" + Monthly_Sal + '\'' +
                ", Branch='" + Branch + '\'' +
                ", Date_of_Recruited='" + Date_of_Recruited + '\'' +
                ", Grade='" + Grade + '\'' +
                '}';
    }
}
