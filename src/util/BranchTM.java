package util;


import javafx.scene.control.Button;

public class BranchTM {

    private String branchId;
    private String branchName;
    private String  address;
    private String contactNumber;
    private String email;
    private String establishedDate;
    private Button btnDelete;

    public BranchTM() {
    }

    public BranchTM(String branchId, String branchName, String address, String contactNumber, String email, String establishedDate, Button btnDelete) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
        this.establishedDate = establishedDate;
        this.btnDelete = btnDelete;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = establishedDate;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "BranchTM{" +
                "branchId='" + branchId + '\'' +
                ", branchName='" + branchName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", establishedDate='" + establishedDate + '\'' +
                ", btnDelete=" + btnDelete +
                '}';
    }
}
