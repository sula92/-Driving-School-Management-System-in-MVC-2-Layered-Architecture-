package dto;

public class BranchDTO {

    private String BranchId;
    private String BranchNm;
    private String BranchAdd;
    private String Contact;
    private String Email;;
    private String DOE;

    public BranchDTO() {
    }

    public BranchDTO(String branchId, String branchNm, String branchAdd, String contact, String email, String DOE) {
        BranchId = branchId;
        BranchNm = branchNm;
        BranchAdd = branchAdd;
        Contact = contact;
        Email = email;
        this.DOE = DOE;
    }

    public String getBranchId() {
        return BranchId;
    }

    public void setBranchId(String branchId) {
        BranchId = branchId;
    }

    public String getBranchNm() {
        return BranchNm;
    }

    public void setBranchNm(String branchNm) {
        BranchNm = branchNm;
    }

    public String getBranchAdd() {
        return BranchAdd;
    }

    public void setBranchAdd(String branchAdd) {
        BranchAdd = branchAdd;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDOE() {
        return DOE;
    }

    public void setDOE(String DOE) {
        this.DOE = DOE;
    }

    @Override
    public String toString() {
        return "BranchDTO{" +
                "BranchId='" + BranchId + '\'' +
                ", BranchNm='" + BranchNm + '\'' +
                ", BranchAdd='" + BranchAdd + '\'' +
                ", Contact='" + Contact + '\'' +
                ", Email='" + Email + '\'' +
                ", DOE='" + DOE + '\'' +
                '}';
    }
}
