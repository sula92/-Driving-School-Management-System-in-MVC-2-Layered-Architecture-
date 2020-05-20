package entity;

public class Branch implements SuperEntity {

    private String Branch_ID;
    private String Branch_Name;
    private String Address;
    private String Contact_Number;
    private String Email;
    private String Established_Date;

    public Branch() {
    }

    public Branch(String branch_ID, String branch_Name, String address, String contact_Number, String email, String established_Date) {
        Branch_ID = branch_ID;
        Branch_Name = branch_Name;
        Address = address;
        Contact_Number = contact_Number;
        Email = email;
        Established_Date = established_Date;
    }

    public String getBranch_ID() {
        return Branch_ID;
    }

    public void setBranch_ID(String branch_ID) {
        Branch_ID = branch_ID;
    }

    public String getBranch_Name() {
        return Branch_Name;
    }

    public void setBranch_Name(String branch_Name) {
        Branch_Name = branch_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact_Number() {
        return Contact_Number;
    }

    public void setContact_Number(String contact_Number) {
        Contact_Number = contact_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEstablished_Date() {
        return Established_Date;
    }

    public void setEstablished_Date(String established_Date) {
        Established_Date = established_Date;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "Branch_ID='" + Branch_ID + '\'' +
                ", Branch_Name='" + Branch_Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact_Number='" + Contact_Number + '\'' +
                ", Email='" + Email + '\'' +
                ", Established_Date='" + Established_Date + '\'' +
                '}';
    }
}
